package com.revature.web;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.ReimbursementInput;
import com.revature.services.ReimbursementLogic;

public class NewReimbursementServlet extends HttpServlet{

	private static final long serialVersionUID = 5550131717600337677L;
	private static Logger logger = Logger.getLogger(NewReimbursementServlet.class);
	
	ReimbursementLogic rLogic = new ReimbursementLogic();
	
	private static ObjectMapper om = new ObjectMapper();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {
		HttpSession session = req.getSession();
		int userID = (int) session.getAttribute("userID");
		BufferedReader reader = req.getReader();
		StringBuilder jsonInput = new StringBuilder();
		String line = reader.readLine();
		while(line != null) {
			jsonInput.append(line);
			line = reader.readLine();
		}
		String jsonInputString = jsonInput.toString();
		ReimbursementInput reimbursementInput = om.readValue(jsonInputString, ReimbursementInput.class);
		
		
	}
}
