package combeat.beatbash;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    public User createUser(User user) {
        return userRepository.save(user);
    }
    public Optional<User> getUserById(String uid) {
        return userRepository.findById(uid);
    }
}
