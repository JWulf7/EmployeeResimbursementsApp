package com.revature.services;

import java.util.TreeMap;

import com.revature.models.ReimStatus;
import com.revature.models.ReimTypes;
import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.models.UserRoles;
import com.revature.repositories.ReimbursementsDAO;
import com.revature.repositories.ReimbursementsDAOImpl;
import com.revature.repositories.UsersDAO;
import com.revature.repositories.UsersDAOImpl;

public class UserLogic {

	UsersDAO uDAO = new UsersDAOImpl();
	ReimbursementsDAO rDAO = new ReimbursementsDAOImpl();
	
	
	
	// grab a whole user to work with -- not complete yet
	public User grabWholeUser(String userName, String password) {
		User user = uDAO.getUserByUserName(userName);
		TreeMap<Integer, Reimbursement> reimbursements = rDAO.getReimbursementsFromUserId(user.getUserId());
		
		
		return user;
	}
	
	
	// convert ints to enums
	public User userWithEnums(User user) {
		
	}
	
	

	
	public UserRoles roleToEnum(int roleNum) {
		UserRoles role;
		if(roleNum == 1) {
			role = UserRoles.Employee;
			return role;
		} else if(roleNum == 2) {
			role = UserRoles.FinanceManager;
			return role;
		}
		return null;
	}
}
