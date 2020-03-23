package com.revature.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.UserDAO;
import com.revature.domain.User;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{

	private static UserDAO userDao;
	
	@Autowired
	public void setUserDAO(UserDAO userDao) {
		this.userDao = userDao;
	}
	
	public User validateUser(String username, String password) {
		User user = userDao.getUserByUsername(username);
		if (user != null && user.getPassword().equals(password)) {
			return user;
		}
		return null;
	}

	
	
}
