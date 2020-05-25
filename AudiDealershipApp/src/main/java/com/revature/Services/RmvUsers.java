package com.revature.Services;

/**
 * A customer account removal service
 * <p>
 * The RmvUsers interface provides a method that allows an employee to remove
 * a customer's account from the AWS RDS database
 * <p>
 * The RmvUsers interface provides a method that allows an employee to view
 * all the customer accounts in the AWS RDS database.
 * 
 * @author josecanela 
 */
public interface RmvUsers {
	/**
	 * Removes a customer account from the AWS RDS database
	 * 
	 * @param username an employee's username
	 * @param password an employee's password
	 * @param customerUsername a customer's username
	 */
	public void removeUser(String username, String password, String customerUsername);
	
	/**
	 * Prints all the customer usernames in the AWS RDS database.
	 */
	public void viewCustomers();
}
