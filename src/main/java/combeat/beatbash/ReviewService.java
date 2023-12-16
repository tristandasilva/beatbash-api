package combeat.beatbash;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Review createReview(String reviewBody, String festivalId) {

        Review review = reviewRepository.insert(new Review(reviewBody));

        mongoTemplate.update(Festival.class)
                .matching(Criteria.where("festivalId").is(festivalId))
                .apply(new Update().push("reviews").value(review))
                .first();

        return review;
    }
}
