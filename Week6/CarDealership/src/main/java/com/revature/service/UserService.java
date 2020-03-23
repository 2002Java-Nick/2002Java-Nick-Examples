package com.revature.service;

import java.util.List;

import com.revature.domain.User;
import com.revature.exception.UserInsertionException;

public interface UserService {

	public void registerUser(User user) throws UserInsertionException;
	
	public List<User> retrieveAllUsers();
	
}
