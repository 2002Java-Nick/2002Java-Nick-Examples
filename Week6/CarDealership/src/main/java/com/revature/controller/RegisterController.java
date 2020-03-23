package com.revature.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity.BodyBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.revature.domain.User;
import com.revature.exception.UserInsertionException;
import com.revature.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
public class RegisterController {
	
	private UserService userService;
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
	
	@PostMapping("/register")
	public ResponseEntity<User> registerUser(@RequestBody User user) {
		try {
			userService.registerUser(user);
			return ResponseEntity.created(new URI('/'+user.getUsername())).body(user);
		} catch (UserInsertionException e) {
			e.printStackTrace();
			
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(null);
		
	}

}
