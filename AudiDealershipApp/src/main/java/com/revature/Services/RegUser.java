package com.revature.Services;

/**
 * A user account registration service
 * <p>
 * The RegUser interface provides methods for registering both employees and customers.
 * 
 * @author josecanela
 */
public interface RegUser {
	/**
	 * Creates a Customer object and inserts it's information into the RDS database
	 * utilizing JDBC - hence, registering a customer user.
	 * 
	 * @param username a customer's username
	 * @param password a customer's username
	 */
	public void registerCustomer(String username, String password);
	/**
	 * Creates an Employee object and inserts it's information into the RDS database
	 * utilizing JDBC - hence, registering an employee user.
	 * 
	 * @param username an employee's username
	 * @param password an employee's username
	 */
	public void registerEmployee(String username, String password);
}
