package aguiar.bruno.workshopmongo.config;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import aguiar.bruno.workshopmongo.models.entities.User;
import aguiar.bruno.workshopmongo.repositories.UserRepository;

@Configuration
@Profile("teste")
public class TestConfig {

	@Autowired
	private UserRepository userRepository;
	
	@PostConstruct
	public void init() {
		
		userRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User bruno = new User(null, "Bruno Aguiar", "bruno@gmail.com");
		User sara = new User(null, "Sara Carlota", "sara@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, bruno, sara));
	}
}
