package com.revature.Services;

/**
 * @author josecanela
 *
 */
public interface RmvUsers {
	/**
	 * @param username
	 * @param password
	 * @param customerUsername
	 */
	public void removeUser(String username, String password, String customerUsername);
	/**
	 * 
	 */
	public void viewCustomers();
}
