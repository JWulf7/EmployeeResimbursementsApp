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
	
	public int enumToStatus(ReimStatus statusEnum) {
		int status;
		if(statusEnum == ReimStatus.Pending) {
			status = 0;
			return status;
		} else if(statusEnum == ReimStatus.Approved) {
			status = 1;
			return status;
		} else if(statusEnum == ReimStatus.Denied) {
			status = -1;
			return status;
		}
		else return 100;
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
	
	public int enumToType(ReimTypes typeEnum) {
		int type;
		if(typeEnum == ReimTypes.Lodging) {
			type = 1;
			return type;
		} else if (typeEnum == ReimTypes.Travel) {
			type = 2;
			return type;
		} else if (typeEnum == ReimTypes.Food) {
			type = 3;
			return type;
		} else if (typeEnum == ReimTypes.Other) {
			type = 4;
			return type;
		}
		return 100;
	}
	
	public TreeMap<Integer, Reimbursement> grabCompleteReimbursements(int userID) {
		TreeMap<Integer, Reimbursement> reimbursements = rDAO.getReimbursementsFromUserId(userID);
		for(int i = 1; i <= reimbursements.size(); i++) {
			reimbursements.get(i).setStatus(statusToEnum(reimbursements.get(i).getStatusNum()));
			reimbursements.get(i).setType(typeToEnum(reimbursements.get(i).getTypeNum()));
		}
		return reimbursements;
	}
	
	
	
}