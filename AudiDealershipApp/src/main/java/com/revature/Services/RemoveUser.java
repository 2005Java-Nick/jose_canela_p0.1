package com.revature.Services;

import org.apache.log4j.Logger;

import com.revature.DAO.UserDAOPostgreSQL;
import com.revature.Objects.*;

/**
 * @author josecanela
 *
 */
public class RemoveUser implements RmvUsers{
	private static Logger log = Logger.getRootLogger();
	
	AuthenticateUser authUser = new AuthenticateUser();
	UserDAOPostgreSQL userDAO = new UserDAOPostgreSQL();
	

	/**
	 * @param username
	 * @param password
	 * @param customer
	 */
	@Override
	public void removeUser(String username, String password, String customerUsername) {
	
		if (authUser.authenticateEmployee(username, password)) {
			if(customerUsername != null) {
				userDAO.deleteCustomer(userDAO.readCustomerByUsername(customerUsername));
				
				log.info("removeUser: Employee ("+ username +", "+ password +") removed Customer ("+ customerUsername +")");
			} else {
				System.out.println("This customer ("+customerUsername+") doesn't exist.");
				
				log.error("removeUser: Employee ("+ username +", "+ password +") failed to remove a Customer ("+customerUsername+") "
						+ "given they don't exist.");
			}
			
		}

	}
	
	/**
	 *
	 */
	public void viewCustomers() {
		for (Customer cust: userDAO.readAllCustomers()) {
			System.out.println(cust.getUsername()); 
			
			log.info("viewCustomers: Employee viewed Customer ("+ cust.getUsername() +").");
		}
	}

	
}
