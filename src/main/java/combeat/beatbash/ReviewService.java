package combeat.beatbash;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Review createReview(Review review) {

        Review newReview = reviewRepository.save(review);

        mongoTemplate.update(Festival.class)
                .matching(Criteria.where("festivalId").is(review.getFestivalId()))
                .apply(new Update().push("reviews").value(review))
                .first();

        return newReview;
    }

    public List<Review> allReviews() {
        return reviewRepository.findAll();
    }

    public Optional<Review> getByReviewId(String reviewId) {
        return reviewRepository.findByReviewId(reviewId);
    }

    public Review updateReview(Review review) {
        return reviewRepository.save(review);
    }

    public Optional<Review> deleteByReviewId(String reviewId) {
        return reviewRepository.deleteByReviewId(reviewId);
    }
}
