package combeat.beatbash;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BeatbashApplication {
	public static void main(String[] args) {
		SpringApplication.run(BeatbashApplication.class, args);
	}

	@GetMapping("/")
	public String apiRoot() {
		return "Welcome to the festivals API!";
	}
}
