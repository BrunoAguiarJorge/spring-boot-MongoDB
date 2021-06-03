package aguiar.bruno.workshopmongo.config;

import java.time.Instant;
import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import aguiar.bruno.workshopmongo.models.embedded.Author;
import aguiar.bruno.workshopmongo.models.embedded.Comments;
import aguiar.bruno.workshopmongo.models.entities.Post;
import aguiar.bruno.workshopmongo.models.entities.User;
import aguiar.bruno.workshopmongo.repositories.PostRepository;
import aguiar.bruno.workshopmongo.repositories.UserRepository;

@Configuration
@Profile("teste")
public class TestConfig {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@PostConstruct
	public void init() {
		
		userRepository.deleteAll();
		postRepository.deleteAll();

		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");

		userRepository.saveAll(Arrays.asList(maria, alex, bob));

		Post post1 = new Post(null, Instant.parse("2021-02-13T11:15:01Z"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new Author(maria));
		Post post2 = new Post(null, Instant.parse("2021-02-14T10:05:49Z"), "Bom dia", "Acordei feliz hoje!", new Author(maria));

		Comments c1 = new Comments("Boa viagem mano!", Instant.parse("2021-02-13T14:30:01Z"), new Author(alex));
		Comments c2 = new Comments("Aproveite", Instant.parse("2021-02-13T15:38:05Z"), new Author(bob));
		Comments c3 = new Comments("Tenha um ótimo dia!", Instant.parse("2021-02-14T12:34:26Z"), new Author(alex));

		post1.getComments().addAll(Arrays.asList(c1, c2));
		post2.getComments().addAll(Arrays.asList(c3));

		postRepository.saveAll(Arrays.asList(post1, post2));

		maria.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(maria);		

	}
}
