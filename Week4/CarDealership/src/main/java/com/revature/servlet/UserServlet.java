package com.revature.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.GsonBuilder;
import com.revature.domain.User;
import com.revature.exception.UserInsertionException;
import com.revature.service.UserServiceImpl;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static UserServiceImpl userService = new UserServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
    }

    
    
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().write(new GsonBuilder().create().toJson(userService.retrieveAllUsers()));
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new GsonBuilder().create().fromJson(request.getReader().readLine(), User.class);
		
		try {
			userService.registerUser(user);
			response.setStatus(response.SC_CREATED);
		} catch (UserInsertionException e) {
			response.setStatus(response.SC_BAD_REQUEST);
		}
		
	}

}
