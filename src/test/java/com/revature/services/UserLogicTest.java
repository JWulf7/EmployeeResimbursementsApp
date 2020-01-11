package com.revature.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.TreeMap;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.models.UserRoles;
import com.revature.repositories.ReimbursementsDAOImpl;
import com.revature.repositories.UsersDAOImpl;

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
	
	UsersDAOImpl uDAOMock = mock(UsersDAOImpl.class);
	DigestUtils digUMock = mock(DigestUtils.class);
	UserLogic uLogic = new UserLogic(uDAOMock, digUMock);
	ReimbursementsDAOImpl rDAOMock = mock(ReimbursementsDAOImpl.class);
	ReimbursementLogic rLogic = new ReimbursementLogic(rDAOMock);

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
	 * *************************GrabWholeUser****************************************
	 */
	
	@Test
	public void testGrabWholeUserGood() {
		User user = new User(1, "UserName", "EncryptedPassword", "John", "Doe", "email@email.com", 1);
		byte[] file = new byte[] {0,1,2,3,4,5};
		Reimbursement reim1 = new Reimbursement(1, 25.00, "1/1/2020", "1/2/2020", "Test", file, 1, 2, 1, 1);
		Reimbursement reim2 = new Reimbursement(2, 25.00, "1/1/2020", "1/2/2020", "Test", file, 1, 2, 1, 2);
		TreeMap<Integer, Reimbursement> reims = new TreeMap<>();
		reims.put(1, reim1);
		reims.put(2, reim2);
		user.setUserReimbursements(reims);
		user.setRole(uLogic.roleToEnum(user.getRoleNum()));
		when(uDAOMock.getUserByUserName("UserName")).thenReturn(user);
		when(rDAOMock.getReimbursementsFromUserId(1)).thenReturn(reims);
		assertEquals(user, uLogic.grabWholeUser("UserName", "EncryptedPassword"));
	}
	
	@Test
	public void testGrabWholeUserBadPassword() {
		User user = new User(1, "UserName", "EncryptedPassword", "John", "Doe", "email@email.com", 1);
		byte[] file = new byte[] {0,1,2,3,4,5};
		Reimbursement reim1 = new Reimbursement(1, 25.00, "1/1/2020", "1/2/2020", "Test", file, 1, 2, 1, 1);
		Reimbursement reim2 = new Reimbursement(2, 25.00, "1/1/2020", "1/2/2020", "Test", file, 1, 2, 1, 2);
		TreeMap<Integer, Reimbursement> reims = new TreeMap<>();
		reims.put(1, reim1);
		reims.put(2, reim2);
		user.setUserReimbursements(reims);
		user.setRole(uLogic.roleToEnum(user.getRoleNum()));
		when(uDAOMock.getUserByUserName("UserName")).thenReturn(user);
		when(rDAOMock.getReimbursementsFromUserId(1)).thenReturn(reims);
		assertNotEquals(user, uLogic.grabWholeUser("UserName", "WrongPassword"));
	}
	
	@Test
	public void testGrabWholeUserBadNoUser() {
		User user = new User(1, "UserName2", "EncryptedPassword", "John", "Doe", "email@email.com", 1);
		byte[] file = new byte[] {0,1,2,3,4,5};
		Reimbursement reim1 = new Reimbursement(1, 25.00, "1/1/2020", "1/2/2020", "Test", file, 1, 2, 1, 1);
		Reimbursement reim2 = new Reimbursement(2, 25.00, "1/1/2020", "1/2/2020", "Test", file, 1, 2, 1, 2);
		TreeMap<Integer, Reimbursement> reims = new TreeMap<>();
		reims.put(1, reim1);
		reims.put(2, reim2);
		user.setUserReimbursements(reims);
		user.setRole(uLogic.roleToEnum(user.getRoleNum()));
		when(uDAOMock.getUserByUserName("UserName2")).thenReturn(user);
		when(rDAOMock.getReimbursementsFromUserId(1)).thenReturn(reims);
		assertNull(uLogic.grabWholeUser("UserName", "EncryptedPassword"));
	}

/*
 * ******************************************************************************
 */							
	/*					TESTING VERY COMPLICATED/IMPOSSIBLE BECAUSE USING A DEPENDENICES STATIC METHOD (SHA256Hex of DigestUtil dependency)
	@Test
	public void tttttttttttttttttttttestLoginGood() {
		User user = new User(1, "UserName", "19513fdc9da4fb72a4a05eb66917548d3c90ff94d5419e1f2363eea89dfee1dd", "John", "Doe", "email@email.com", 1);
		byte[] file = new byte[] {0,1,2,3,4,5};
		Reimbursement reim1 = new Reimbursement(1, 25.00, "1/1/2020", "1/2/2020", "Test", file, 1, 2, 1, 1);
		Reimbursement reim2 = new Reimbursement(2, 25.00, "1/1/2020", "1/2/2020", "Test", file, 1, 2, 1, 2);
		TreeMap<Integer, Reimbursement> reims = new TreeMap<>();
		reims.put(1, reim1);
		reims.put(2, reim2);
		user.setUserReimbursements(reims);
		user.setRole(uLogic.roleToEnum(user.getRoleNum()));
		
		when(digUMock.sha256Hex("Password1")).thenReturn("19513fdc9da4fb72a4a05eb66917548d3c90ff94d5419e1f2363eea89dfee1dd");
		when(uDAOMock.getUserByUserName("UserName")).thenReturn(user);
		when(rDAOMock.getReimbursementsFromUserId(1)).thenReturn(reims);
		assertEquals(user, uLogic.grabWholeUser("UserName", "Password1"));
	}
	*/
	@Test
	public void testCreateNewUser() {
		fail("Not yet implemented");
	}

	@Test
	public void testUserExists() {
		fail("Not yet implemented");
	}

}
