package com.revature.dao;

import java.util.List;

import com.revature.domain.User;
import com.revature.exception.UserInsertionException;

public interface UserDAO {
	
	public User getUserByUsername(String username);
	
	public void createUser(User user) throws UserInsertionException;
	
	public List<User> getAllUsers();

}
