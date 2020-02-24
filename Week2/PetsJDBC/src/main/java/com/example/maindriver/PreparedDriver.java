package com.example.maindriver;

import java.util.Scanner;

import com.example.model.User;
import com.revature.service.UserService;
import com.revature.service.UserServiceImpl;

public class PreparedDriver {

	private static UserService uService = new UserServiceImpl();
	
	public static void main(String[] args) {

		System.out.println("Do you want to login or change password?");
		
		Scanner sc = new Scanner(System.in);
		
		String answer = sc.nextLine();
		
		if ("login".equals(answer.toLowerCase())) {
			System.out.println("Enter your username: ");
			String username = sc.nextLine();
			System.out.println("Enter your password: ");
			String password = sc.nextLine();
			User u = uService.loginUser(username, password);
			if (u != null) {
				System.out.println("Welcome User " + u.getUsername());
			} else {
				System.out.println("Incorrect username/password combination!!!!!!");
			}
		}
		
	}

}
