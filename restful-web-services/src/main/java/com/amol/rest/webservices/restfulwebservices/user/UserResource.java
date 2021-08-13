package com.amol.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {

	@Autowired
	private UserDaoService userDaoService;
	
	@GetMapping(path = "/users")
	public List<User> getAllUsers() {
		return userDaoService.findAll();
	}
	
	@GetMapping(path = "/users/{id}")
	public User getUser(@PathVariable Integer id) {
		User user = userDaoService.findOne(id);
		if(user == null) {
			throw new UserNotFoundException("Not Found!");
		}
		
		return user;
	}
	
	@PostMapping(path = "/users")
	public ResponseEntity<Object> saveUser(@Valid @RequestBody User user) {
		User createdUser = UserDaoService.save(user);

		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(createdUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping(path = "/users/{id}")
	public User deleteUser(@PathVariable Integer id) {
		User user = userDaoService.deleteUserById(id);
		if(user == null) {
			throw new UserNotFoundException("Not Found!");
		}
		
		return user;
	}
}
