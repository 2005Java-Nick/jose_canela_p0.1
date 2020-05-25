package com.revature.Services;



import org.apache.log4j.Logger;
import com.revature.DAO.*;
import com.revature.Objects.*;

/**
 * @author josecanela
 *
 */
public class RegisterUser implements RegUser {
	private static Logger log = Logger.getRootLogger();
	private static UserDAOPostgreSQL userDAO = new UserDAOPostgreSQL();
	
	@Override
	public void registerCustomer(String username, String password) {
		if(username == null || password == null) {
			System.out.println("Invalid username or password. A username AND password must be entered. Please try again.");
			
			log.error("registerCustomer: Customer username or password input is null");
		}
		else if (userDAO.readCustomerByUsername(username).getUsername().equals(username)) {
			System.out.println("The username (" + username + ") already exists. Try another username.");
			
			log.info("registerCustomer:Customer input a username ("+ username +") that already exists.");
		} else {
			userDAO.createCustomer(new Customer(username, password));
			
			log.info("registerCustomer:Customer("+username+") created/registered");
		}
		
	}

	@Override
	public void registerEmployee(String username, String password) {
		if(username == null || password == null) {
			System.out.println("Invalid username or password. A username AND password must be entered. Please try again.");
			
			log.error("registerEmployee: Employee username or password input is null");
		}
		else if (userDAO.readEmployeeByUsername(username).getUsername().equals(username)) {
			System.out.println("The username (" + username + ") already exists. Try another username.");
			
			log.info("registerEmployee:Employee input a username ("+ username +") that already exists.");
		} else{
			userDAO.createEmployee(new Employee(username, password));
	
			log.info("registerEmployee:Employee("+username+") created/registered");
		}
	}
}
