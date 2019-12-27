package com.revature.services;

import java.util.TreeMap;

import com.revature.models.ReimStatus;
import com.revature.models.ReimTypes;
import com.revature.models.Reimbursement;
import com.revature.repositories.ReimbursementsDAO;
import com.revature.repositories.ReimbursementsDAOImpl;
import com.revature.repositories.UsersDAO;
import com.revature.repositories.UsersDAOImpl;

public class ReimbursementLogic {

	UsersDAO uDAO = new UsersDAOImpl();
	ReimbursementsDAO rDAO = new ReimbursementsDAOImpl();
	
	
	
	public ReimStatus statusToEnum(int statusNum) {
		ReimStatus status;
		if(statusNum == 0) {
			status = ReimStatus.Pending;
			return status;
		} else if(statusNum == 1) {
			status = ReimStatus.Approved;
			return status;
		} else if(statusNum == -1) {
			status = ReimStatus.Denied;
			return status;
		}
		return null;
	}
	
	public ReimTypes typeToEnum(int typeNum) {
		ReimTypes type;
		if(typeNum == 1) {
			type = ReimTypes.Lodging;
			return type;
		} else if(typeNum == 2) {
			type = ReimTypes.Travel;
			return type;
		} else if(typeNum == 3) {
			type = ReimTypes.Food;
			return type;
		} else if(typeNum == 4) {
			type = ReimTypes.Other;
			return type;
		}
		return null;
	}
	
	public TreeMap<Integer, Reimbursement> grabCompleteReimbursements(int userID) {
		TreeMap<Integer, Reimbursement> reimbursements = rDAO.getReimbursementsFromUserId(userID);
	}
	
}