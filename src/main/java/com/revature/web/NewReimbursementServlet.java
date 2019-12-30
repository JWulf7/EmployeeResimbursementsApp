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
	protected void doGet(HttpServletRequest req, HttpServletResponse res) {
		try {
			doPost(req, res);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {
		System.out.println("doPost method inside NewReimbursementServlet started");
		HttpSession session = req.getSession();
		System.out.println("got session from request inside doPost method  inside NewReimbursementServlet started");
		int userID = (int) session.getAttribute("userID");
		System.out.println("got userID from session attribute inside doPost method inside NewReimbursementServlet started");
		BufferedReader reader = req.getReader();
		StringBuilder jsonInput = new StringBuilder();
		System.out.println("about to read line from bufferedreaders get request.getreader() inside doPost method inside NewReimbursementServlet started");
		String line = reader.readLine();
		System.out.println("about to loop through reader inside doPost method  inside NewReimbursementServlet started");
		while(line != null) {
			jsonInput.append(line);
			line = reader.readLine();
		}
		String jsonInputString = jsonInput.toString();
		System.out.println("about to set ReimbursementInput object = object mapper object readValue function inside doPost method  inside NewReimbursementServlet started");
		ReimbursementInput reimbursementInput = om.readValue(jsonInputString, ReimbursementInput.class);
		//reimbursementInput.setAuthor(userID);
		// make this into a conditional statement that executes if true/success or false failed vvvv
		System.out.println("about to start 'if' conditional which creates a new reimbursement with reimInput and userID inside doPost method  inside NewReimbursementServlet started");
		if(rLogic.createNewReimbursement(reimbursementInput, userID)) {
			// do something here if a new reimbursement was created.
			// should probably log the reimbursement 
			// should create an alert with a success message.
			// should probably refresh the current page to reflect the user's new reimbursement on their reimbursement table
			res.setStatus(201);
		}
		
	}
}
