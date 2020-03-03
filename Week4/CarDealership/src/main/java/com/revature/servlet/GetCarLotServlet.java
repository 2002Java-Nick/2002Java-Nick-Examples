package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetCarLotServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String carLot = "[{\"make\":\"Ford\",\"model\":\"Explorer\"}]";
		PrintWriter pw = resp.getWriter();
		pw.write(carLot);
	}
	
	

}
