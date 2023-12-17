package combeat.beatbash;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @CrossOrigin(origins = "*")
    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews() {
        return new ResponseEntity<List<Review>>(reviewService.allReviews(), HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Review review) {
        return new ResponseEntity<Review>(reviewService.createReview(review), HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/{reviewId}")
    public ResponseEntity<Review> updateReview(@PathVariable String reviewId, @RequestBody Review review) {
        Optional<Review> reviewData = reviewService.getByReviewId(reviewId);

        if (reviewData.isPresent()) {
            Review updatedReview = reviewData.get();
            updatedReview.setBody(review.getBody());
            updatedReview.setStarRating(review.getStarRating());
            return new ResponseEntity<>(reviewService.updateReview(updatedReview), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/{reviewId}")
    public ResponseEntity<HttpStatus> deleteReview(@PathVariable String reviewId) {
        try {
            reviewService.deleteByReviewId(reviewId);
            return new ResponseEntity<>((HttpStatus.NO_CONTENT));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
