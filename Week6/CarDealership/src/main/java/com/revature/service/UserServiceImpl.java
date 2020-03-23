package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOPostgres;
import com.revature.domain.User;
import com.revature.exception.UserInsertionException;

@Service
public class UserServiceImpl implements UserService {
	
	private static UserDAO userDao;
	
	@Autowired
	public void setUserDAO(UserDAO userDao) {
		this.userDao = userDao;
	}
	
	public void registerUser(User user) throws UserInsertionException {
		userDao.createUser(user);
	}
	
	public List<User> retrieveAllUsers() {
		return userDao.getAllUsers();
	}

}
