package combeat.beatbash;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")

public class UserController {
    @Autowired
    private UserService userService;

    @CrossOrigin(origins = "*")
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return new ResponseEntity<User>(userService.createUser(user), HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/{uid}")
    public ResponseEntity<Optional<User>> getUserByUserId(@PathVariable String uid) {
        return new ResponseEntity<Optional<User>>(userService.getUserById(uid), HttpStatus.OK);
    }
}
