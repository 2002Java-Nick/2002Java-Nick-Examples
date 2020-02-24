package com.revature.service;

import com.example.model.User;

public interface UserService {
	
	public void updatePassword(String username, String password);
	
	public User loginUser(String username, String password);

}
