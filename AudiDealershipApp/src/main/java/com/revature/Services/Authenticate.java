package com.revature.Services;

import com.revature.Objects.Customer;
import com.revature.Objects.Employee;

/**
 * A user authentication service.
 * <p>
 * The Authenticate interface provides methods that authenticate users (whether they are
 * a customers or employees).
 * <p>
 * The Authenticate interface also provides methods for getting and returning Employee objects
 * and Customer objects (by using usernames).
 * 
 * @author josecanela
 */
public interface Authenticate {

	
	/**
	 * Authenticates a customer user for customer login
	 * 
	 * @param customerUsername a customer's username
	 * @param Password a customer's password
	 * @return whether or not a user is a registered customer
	 */
	public boolean authenticateCustomer(String customerUsername, String Password);
	
	/**
	 * Authenticates an employee user for employee login
	 * 
	 * @param employeeUsername an employee's username
	 * @param employeePassword an employee's password
	 * @return whether or not a user is a registered employee
	 */
	public boolean authenticateEmployee(String employeeUsername, String employeePassword);
	
	/**
	 * Gets a customer (by their username) and returns it
	 * 
	 * @param customerUsername a customer's username
	 * @return a Customer object
	 */
	public Customer getCustomerByUsername(String customerUsername);
	
	/**
	 * Gets an employee (by their username) and returns it
	 * 
	 * @param employeeUsername an employee's username
	 * @return an Employee object
	 */
	public Employee getEmployeeByUsername(String employeeUsername);
	
}
