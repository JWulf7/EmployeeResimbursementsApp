package com.revature.web;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.revature.models.User;
import com.revature.services.UserLogic;

public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(LoginServlet.class);
	UserLogic uLogic = new UserLogic();
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {
		String username = req.getParameter("username");
		String passwordB4 = req.getParameter("password");
		
		logger.info("Attempted login with username: " + username);
		User user = uLogic.login(username, passwordB4);
		
		if(user != null) {
			HttpSession session = req.getSession();
			session.setAttribute("username", username);
			RequestDispatcher rd = req.getRequestDispatcher("employee/project1-employee.html");
			rd.forward(req, res);
			logger.info(username + " succesfully logged in: " + LocalDateTime.now());
		} else {
			logger.info("failed login with username: " + username);
			RequestDispatcher rd = req.getRequestDispatcher("project1-loginfail.html");
			rd.forward(req, res);
		}
	}
}
