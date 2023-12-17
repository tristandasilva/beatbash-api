package combeat.beatbash;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/festivals")
public class FestivalController {
    @Autowired
    private FestivalService festivalService;

    @CrossOrigin(origins = "*")
    @GetMapping
    public ResponseEntity<List<Festival>> getAllFestivals() {
        return new ResponseEntity<List<Festival>>(festivalService.allFestivals(), HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/{festivalId}")
    public ResponseEntity<Optional<Festival>> getFestivalByFestivalId(@PathVariable String festivalId) {
        return new ResponseEntity<Optional<Festival>>(festivalService.getByFestivalId(festivalId), HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @PostMapping
    public ResponseEntity<Festival> addFestival(@RequestBody Festival festival) {
        return new ResponseEntity<Festival>(festivalService.createFestival(festival), HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/{festivalId}")
    public ResponseEntity<Festival> updateFestival(@PathVariable String festivalId, @RequestBody Festival festival) {
        Optional<Festival> festivalData = festivalService.getByFestivalId(festivalId);

        if (festivalData.isPresent()) {
            Festival updatedFestival = festivalData.get();
            updatedFestival.setCity(festival.getCity());
            updatedFestival.setCountry(festival.getCountry());
            updatedFestival.setGenres(festival.getGenres());
            updatedFestival.setImages(festival.getImages());
            updatedFestival.setName(festival.getName());
            updatedFestival.setDescription(festival.getDescription());
            return new ResponseEntity<>(festivalService.updateFestival(updatedFestival), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/{festivalId}")
    public ResponseEntity<HttpStatus> deleteFestival(@PathVariable String festivalId) {
        try {
            festivalService.deleteByFestivalId(festivalId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
