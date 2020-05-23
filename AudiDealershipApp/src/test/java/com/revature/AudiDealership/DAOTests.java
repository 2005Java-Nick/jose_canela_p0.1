package com.revature.AudiDealership;

import org.junit.Assert.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


import com.revature.DAO.*;
import com.revature.Objects.*;
import com.revature.Services.*;
import com.revature.AudiDealership.*;

public class DAOTests {

	AudiCarDAOPostGreSQL audiDAO = new AudiCarDAOPostGreSQL();
	
	OfferDAOPostgreSQL offerDAO = new OfferDAOPostgreSQL();
	
	UserDAOPostgreSQL userDAO = new UserDAOPostgreSQL();
	
	PaymentDAOPostgreSQL paymentDAO = new 	PaymentDAOPostgreSQL();
	
	AuthenticateUser authUser = new AuthenticateUser();
	
	BidOnAudiCar bidAudi = new BidOnAudiCar();
	
	ManageAudiCarPayments mngCar= new ManageAudiCarPayments();
	
	RegisterAudi regAudi = new RegisterAudi();
	
	RegisterUser regUser = new RegisterUser();
	
	RemoveRegisteredAudi rmAudi = new RemoveRegisteredAudi();
	
	RemoveUser rmUser = new RemoveUser();
	
	ViewAudi viewAudi = new ViewAudi();
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAuthenticateCustomer() {
		assertEquals(authUser.authenticateCustomer("andres","2"),true);
		
		
	}
	
	@Test
	public void testAuthenticateEmployee() {
		assertEquals(authUser.authenticateEmployee("jose","1"),true);
		
	}
	
	@Test
	public void testGetCustomerByUsername() {
		
		assertEquals(userDAO.readCustomerByUsername("andres").getUsername(),"andres");
		
	}
	
	@Test
	public void testGetEmployeeByUsername() {
		
		assertEquals(userDAO.readEmployeeByUsername("jose").getUsername(),"jose");
		
	}
	
	
	@Test
	public void testCustomerBalance() {
		assertEquals(userDAO.readCustomerByUsername("andres").getTotalBalance()==0,true);
		
	}
	
	@Test
	public void testCustomerPaymentHistory() {
		
		
	}
	
	@Test
	public void testViewAllPayments() {
		
		
	}
	
	@Test
	public void testAudiCarsAndPaymentInfo() {
		
		
	}
	
	@Test
	public void testAddAudiCar() {
		
		
	}
	
	@Test
	public void testRegisterCustomer() {
		
	}
	@Test
	public void testRegisterEmployee() {
		
		
	}
	
	@Test
	public void testRemoveAudiCar() {
		
		
	}
	
	@Test
	public void testRemoveUser() {
		
		
	}
	
	@Test
	public void testViewCustomers() {
		
		
	}
	
	
}
