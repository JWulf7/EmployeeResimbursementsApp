package com.revature.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.ReimbursementInput;
import com.revature.services.ReimbursementLogic;

@MultipartConfig
public class NewReimbursementServlet extends HttpServlet{

	private static final long serialVersionUID = 5550131717600337677L;
	private static final Logger logger = LogManager.getLogger(NewReimbursementServlet.class);
	//private static Logger logger = Logger.getLogger(NewReimbursementServlet.class);
	
	ReimbursementLogic rLogic = new ReimbursementLogic();
	
	private static ObjectMapper om = new ObjectMapper();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
		throws ServletException, IOException {
		try {
			doPost(req, res);
		} catch (ServletException | IOException e) {
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
		InputStream file = null;
		Part filePart = req.getPart("filename");
		if(filePart != null) {
			file = filePart.getInputStream();
		}
		System.out.println(file);
		byte[] receipt = IOUtils.toByteArray(file);
		System.out.println("got userID from session attribute inside doPost method inside NewReimbursementServlet started");
		//BufferedReader reader = req.getReader();
		double amount = Double.parseDouble(req.getParameter("amount"));
		int typeNum = Integer.parseInt(req.getParameter("typeNum"));
		String description = req.getParameter("description");
		ReimbursementInput reimbursementInput = new ReimbursementInput(amount, description, typeNum);
		
		
//		
//		StringBuilder jsonInput = new StringBuilder();
//		System.out.println("about to read line from bufferedreaders get request.getreader() inside doPost method inside NewReimbursementServlet started");
//		String line = reader.readLine();
//		System.out.println("about to loop through reader inside doPost method  inside NewReimbursementServlet started");
//		while(line != null) {
//			jsonInput.append(line);
//			line = reader.readLine();
//		}
//		String jsonInputString = jsonInput.toString();
//		System.out.println("about to set ReimbursementInput object = object mapper object readValue function inside doPost method  inside NewReimbursementServlet started");
//		ReimbursementInput reimbursementInput = om.readValue(jsonInputString, ReimbursementInput.class);
//		//reimbursementInput.setAuthor(userID);
		// make this into a conditional statement that executes if true/success or false failed vvvv
		System.out.println("about to start 'if' conditional which creates a new reimbursement with reimInput and userID inside doPost method  inside NewReimbursementServlet started");
		if(rLogic.createNewReimbursement(reimbursementInput, userID, receipt)) {
			logger.info("User # " + userID + " submitted new reimbursement: Type = " + reimbursementInput.getTypeNum() + "; Amount = $" 
						+ reimbursementInput.getAmount() + "; Description = " + reimbursementInput.getDescription());
			// do something here if a new reimbursement was created.
			// should probably log the reimbursement 
			// should create an alert with a success message.
			// should probably refresh the current page to reflect the user's new reimbursement on their reimbursement table
			res.setStatus(201);
			res.sendRedirect("/Project1/employee/project1-employee.html");
		}
		
	}
}
