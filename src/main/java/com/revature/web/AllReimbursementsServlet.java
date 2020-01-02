package com.revature.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Reimbursement;
import com.revature.services.ReimbursementLogic;

public class AllReimbursementsServlet extends HttpServlet{

	private static final long serialVersionUID = 634005650525646592L;
	private static final Logger logger = LogManager.getLogger(AllReimbursementsServlet.class);
	//private static Logger logger = Logger.getLogger(AllReimbursementsServlet.class);
	
	ReimbursementLogic rLogic = new ReimbursementLogic();
	
	private static ObjectMapper om = new ObjectMapper();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		try {
			doGet(req, res);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException {
		PrintWriter outputStream = res.getWriter();
		res.setContentType("application/json");
		res.setStatus(200);
		System.out.println("inside the doGet method of AllReimbursementsServlet");
		TreeMap<Integer, Reimbursement> allReimbursements = rLogic.grabAllCompleteReimbursements();
		outputStream.println(om.writeValueAsString(allReimbursements));
	}
	
}
