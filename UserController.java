package com.cetpa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cetpa.models.User;
import com.cetpa.repositories.UserRepository;

@RestController
@RequestMapping("user")
public class UserController 
{
	@Autowired private UserRepository userRepo;
	
	private BCryptPasswordEncoder pe=new BCryptPasswordEncoder(); 
	
	@PostMapping("create")
	public ResponseEntity<User> createUser(@RequestBody User user)
	{
		/*String pa=user.getPassword();
		String epa=pe.encode(pa);
		user.setPassword(epa);*/
		user.setPassword(pe.encode(user.getPassword()));
		userRepo.save(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(user);
	}
}
