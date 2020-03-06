package com.revature.dao;

import com.revature.domain.User;

public interface UserDAO {
	
	public User getUserByUsername(String username);

}
