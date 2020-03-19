package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.domain.User;
import com.revature.service.AuthenticationService;
import com.revature.service.AuthenticationServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static AuthenticationService authService = new AuthenticationServiceImpl();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("Username: " + username + " Password: " + password);
		User user = authService.validateUser(username, password);
		System.out.println("User: " + user);
		if (user == null) {
			response.setStatus(response.SC_UNAUTHORIZED);
		} else {
			HttpSession sess = request.getSession(true);
			sess.setAttribute("user", user);
			response.sendRedirect("carlot");
		}
	}

}
