package com.revature;

import org.apache.commons.codec.digest.DigestUtils;

import com.revature.models.User;
import com.revature.repositories.UsersDAOImpl;

public class Driver {

	public static void main(String[] args) {
		UsersDAOImpl uDAO = new UsersDAOImpl();
		User test = uDAO.getUserByUserName("Employee");
		
		System.out.println(test.toString());
		
		String password = "Password1";
		password = DigestUtils.sha256Hex(password);
		System.out.println(password);

	}

}
