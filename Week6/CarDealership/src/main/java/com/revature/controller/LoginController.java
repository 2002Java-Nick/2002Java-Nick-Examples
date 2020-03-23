package com.revature.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.revature.domain.User;
import com.revature.service.AuthenticationService;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
public class LoginController {

	private AuthenticationService authService;
	
	@Autowired
	public void setAuthService(AuthenticationService authService) {
		this.authService = authService;
	}
	
	@PostMapping("/login")
	public ResponseEntity<HttpStatus> login(@RequestBody User user) {
		User authUser = authService.validateUser(user.getUsername(), user.getPassword());
		if (authUser == null) {
			return new ResponseEntity<HttpStatus>(HttpStatus.UNAUTHORIZED);
		} else {
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);			
		}
	
	}
	
}
