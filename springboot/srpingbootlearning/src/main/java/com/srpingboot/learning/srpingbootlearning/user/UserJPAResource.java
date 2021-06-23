package com.srpingboot.learning.srpingbootlearning.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserJPAResource {

	@Autowired
	private UserDaoService service;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	// Get user
	@GetMapping(path = "/jpa/users")
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	// Save user
	@PostMapping(path = "/jpa/users")
	public ResponseEntity<Object> addUser(@Valid @RequestBody User user) {
		User saveuser = userRepository.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saveuser.getId())
				.toUri();
		return ResponseEntity.created(location).build();

	}

	// find one user
	@GetMapping(path = "/jpa/users/{id}")
	public EntityModel<Optional<User>> findOne(@PathVariable int id) {
		Optional<User> user = userRepository.findById(id);
		if (!user.isPresent()) 
			throw new UserNotFoundException("id-" + id);
		EntityModel<Optional<User>> model = EntityModel.of(user);
		WebMvcLinkBuilder linkToUsers = linkTo(methodOn(this.getClass()).getAllUsers());
		model.add(linkToUsers.withRel("all-users"));
		return model;
	}

	@DeleteMapping(path = "/jpa/users/{id}")
	public void deleteUser(@PathVariable int id) {
		userRepository.deleteById(id);
		
}
	@GetMapping(path = "/jpa/users/{id}/posts")
	public List<Post> retrieveAllUsers(@PathVariable int id) {
		Optional<User> user = userRepository.findById(id);
		if (!user.isPresent()) 
			throw new UserNotFoundException("id-" + id);
		
	return user.get().getPosts();
	
}
	
	
	@PostMapping(path = "/jpa/users/{id}/posts")
	public ResponseEntity<Object> createPost(@PathVariable int id, @RequestBody Post post) {
		Optional<User> userOptional = userRepository.findById(id);
		if (!userOptional.isPresent()) 
			throw new UserNotFoundException("id-" + id);
		
		User user = userOptional.get();
		post.setUser(user);
		
		postRepository.save(post);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(post.getId())
				.toUri();
		return ResponseEntity.created(location).build();

	}
	
}
