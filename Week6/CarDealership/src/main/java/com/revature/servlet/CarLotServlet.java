package com.revature.servlet;

import java.io.IOError;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CarLotServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession sess = req.getSession(false);
		if (sess != null && sess.getAttribute("user") != null) { // user has logged in
			RequestDispatcher rd = req.getRequestDispatcher("pages/carlot.html");
			rd.forward(req, resp);
		} else {
			resp.sendRedirect("pages/login.html");
		}
	}
	
}
