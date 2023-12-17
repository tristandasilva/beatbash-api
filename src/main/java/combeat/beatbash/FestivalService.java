package combeat.beatbash;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FestivalService {
    @Autowired
    private FestivalRepository festivalRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Festival> allFestivals() {
        return festivalRepository.findAll();
    }

    public Festival createFestival(Festival festival) {
       return festivalRepository.save(festival);
    }

    public Festival updateFestival(Festival festival) {
        return festivalRepository.save(festival);
    }

    public Optional<Festival> deleteByFestivalId(String festivalId) {
        return festivalRepository.deleteByFestivalId(festivalId);
    }

    public Optional<Festival> getByFestivalId(String festivalId) {
        return festivalRepository.findByFestivalId(festivalId);

    }
}
