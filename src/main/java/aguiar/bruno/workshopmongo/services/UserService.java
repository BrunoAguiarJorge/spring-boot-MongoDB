package aguiar.bruno.workshopmongo.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import aguiar.bruno.workshopmongo.models.dto.UserDTO;
import aguiar.bruno.workshopmongo.models.entities.User;
import aguiar.bruno.workshopmongo.repositories.UserRepository;
import aguiar.bruno.workshopmongo.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<UserDTO> findAll(){
		List<User> list = userRepository.findAll();
		return list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
	}
	public UserDTO findById(String id) {
		Optional<User> result = userRepository.findById(id);
		User entity = result.orElseThrow(() -> new ResourceNotFoundException("Object not found!"));
		return new UserDTO(entity);
		
	}
	
	public UserDTO insert(UserDTO dto) {
		User entity = new User();
		copyDtoToEntity(dto, entity);
		entity = userRepository.insert(entity);
		return new UserDTO(entity);
	}
	private void copyDtoToEntity(UserDTO dto, User entity) {
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		
	}
	
}
