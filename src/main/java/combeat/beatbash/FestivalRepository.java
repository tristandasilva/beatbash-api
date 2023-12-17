package combeat.beatbash;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface FestivalRepository extends MongoRepository<Festival, ObjectId> {
    Optional<Festival> findByFestivalId(String festivalId);

    Optional<Festival> deleteByFestivalId(String festivalId);
}
