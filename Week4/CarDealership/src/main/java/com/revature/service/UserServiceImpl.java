package com.revature.service;

import java.util.List;

import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOPostgres;
import com.revature.domain.User;
import com.revature.exception.UserInsertionException;

public class UserServiceImpl {
	
	private static UserDAO userDao = new UserDAOPostgres();
	
	public void registerUser(User user) throws UserInsertionException {
		userDao.createUser(user);
	}
	
	public List<User> retrieveAllUsers() {
		return userDao.getAllUsers();
	}

}
