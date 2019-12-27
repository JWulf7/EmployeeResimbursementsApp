package com.revature;

import com.revature.models.ReimTypes;
import com.revature.models.User;
import com.revature.repositories.UsersDAOImpl;

public class Driver {

	public static void main(String[] args) {


		UsersDAOImpl uDAO = new UsersDAOImpl();
		User test = uDAO.getUserByUserName("Employee");
		
		System.out.println(test.toString());

	}

}
