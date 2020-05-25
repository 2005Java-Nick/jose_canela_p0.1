package com.revature.Services;

import org.apache.log4j.Logger;
import com.revature.DAO.UserDAOPostgreSQL;
import com.revature.Objects.*;

/**
 * @author josecanela
 *
 */
public class AuthenticateUser implements Authenticate{
	private static Logger log = Logger.getRootLogger();

	@Override
	public boolean authenticateCustomer(String customerUsername, String Password) {
		// TODO Auto-generated method stub
		UserDAOPostgreSQL userDAO = new UserDAOPostgreSQL();
		if(customerUsername == null || Password == null) {
			System.out.println("Incorrect username or password. Please try again.");
			
			log.error("The username or password is null");
		}else {
			Customer cust = userDAO.readCustomerByUsername(customerUsername);
			if (cust.getUsername().equals(customerUsername) && cust.getPassword().equals(Password)) {
				log.info("Customer ("+customerUsername+","+ Password+" logged in.");
				return true;
			} else {
				System.out.println("Incorrect username or password. Please try again.");
				log.info("The username or password is not valid.");
			}
		}

		return false;
	}

	@Override
	public boolean authenticateEmployee(String employeeUsername, String employeePassword) {
		// TODO Auto-generated method stub
		UserDAOPostgreSQL userDAO = new UserDAOPostgreSQL();
		if(employeeUsername == null || employeePassword == null) {
			System.out.println("Incorrect username or password. Please try again.");
			log.error("The username or password is null.");
		}else {
			Employee emp = userDAO.readEmployeeByUsername(employeeUsername);
			if (emp.getUsername().equals(employeeUsername) && emp.getPassword().equals(employeePassword)){
				log.info("Employee ("+employeeUsername+","+ employeePassword+" logged in.");
				return true;
			} else {
				System.out.println("Incorrect username or password. Please try again.");
				log.info("The username or password is not valid.");
			}
		}
		

		return false;
	}

	@Override
	public Customer getCustomerByUsername(String customerUsername) {
		// TODO Auto-generated method stub
		UserDAOPostgreSQL userDAO = new UserDAOPostgreSQL();
		return userDAO.readCustomerByUsername(customerUsername);
	}

	@Override
	public Employee getEmployeeByUsername(String employeeUsername) {
		// TODO Auto-generated method stub
		UserDAOPostgreSQL userDAO = new UserDAOPostgreSQL();
		return userDAO.readEmployeeByUsername(employeeUsername);
	}
	

}
