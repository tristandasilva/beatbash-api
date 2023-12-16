package combeat.beatbash;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FestivalService {
    @Autowired
    private FestivalRepository festivalRepository;
    public List<Festival> allFestivals() {
        return festivalRepository.findAll();
    }

//    public Optional<Festival> getSingleFestival(ObjectId id) {
//        return festivalRepository.findById(id);
//     }

    public Optional<Festival> getByFestivalId(String festivalId) {
        return festivalRepository.findByFestivalId(festivalId);

    }
}
