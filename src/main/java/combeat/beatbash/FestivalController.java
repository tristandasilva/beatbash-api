package combeat.beatbash;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/festivals")
public class FestivalController {
    @Autowired
    private FestivalService festivalService;
    @CrossOrigin(origins = "${env.PROXY}")
    @GetMapping
    public ResponseEntity<List<Festival>> getAllFestivals() {
        return new ResponseEntity<List<Festival>>(festivalService.allFestivals(), HttpStatus.OK);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Optional<Festival>> getFestivalById(@PathVariable ObjectId id) {
//        return new ResponseEntity<Optional<Festival>>(festivalService.getSingleFestival(id), HttpStatus.OK);
//    }

    @CrossOrigin(origins = "${env.PROXY}")
    @GetMapping("/{festivalId}")
    public ResponseEntity<Optional<Festival>> getFestivalByFestivalId(@PathVariable String festivalId) {
        return new ResponseEntity<Optional<Festival>>(festivalService.getByFestivalId(festivalId), HttpStatus.OK);
    }
}
