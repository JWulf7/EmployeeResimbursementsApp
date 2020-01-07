package com.revature.services;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.models.UserRoles;

public class UserLogicTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	/*
	 * **********************Role to Enum********************************
	 */
	@Test
	public void testRoleToEnumEmployeeGood() {
		UserLogic uLogic = new UserLogic();
		assertEquals(UserRoles.Employee, uLogic.roleToEnum(1));
	}
	@Test
	public void testRoleToEnumEmployeeBad() {
		UserLogic uLogic = new UserLogic();
		assertNotEquals(UserRoles.FinanceManager, uLogic.roleToEnum(1));
	}
	@Test
	public void testRoleToEnumFinanceManagerGood() {
		UserLogic uLogic = new UserLogic();
		assertEquals(UserRoles.FinanceManager, uLogic.roleToEnum(2));
	}
	@Test
	public void testRoleToEnumFinanceManagerBad() {
		UserLogic uLogic = new UserLogic();
		assertNotEquals(UserRoles.Employee, uLogic.roleToEnum(2));
	}
	
	/*
	 * *****************************************************************
	 */
	
	@Test
	public void testGrabWholeUser() {
		fail("Not yet implemented");
	}


	@Test
	public void testLogin() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateNewUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testUserExists() {
		fail("Not yet implemented");
	}

}
