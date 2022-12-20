package com.devsuperior.hruser.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.hruser.entities.User;
import com.devsuperior.hruser.repositories.UserRepository;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserRepository usrRepository;

	// EndPoint 1
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {

		User obj = usrRepository.findById(id).get();
		return ResponseEntity.ok(obj);
	}
	
	// EndPoint 2    //o parametro psaamos a interrogação ?email=xxxxx
		@GetMapping(value = "/search") 
		public ResponseEntity<User> findByEmail(@RequestParam String email) {

			User obj = usrRepository.findByEmail(email);
			return ResponseEntity.ok(obj);
		}
}