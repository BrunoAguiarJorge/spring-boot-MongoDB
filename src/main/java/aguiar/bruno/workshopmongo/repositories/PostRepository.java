package aguiar.bruno.workshopmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import aguiar.bruno.workshopmongo.models.entities.Post;
import aguiar.bruno.workshopmongo.models.entities.User;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

}
