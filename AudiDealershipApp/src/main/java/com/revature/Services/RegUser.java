package com.revature.Services;

/**
 * @author josecanela
 *
 */
public interface RegUser {
	/**
	 * @param username
	 * @param password
	 */
	public void registerCustomer(String username, String password);
	/**
	 * @param username
	 * @param password
	 */
	public void registerEmployee(String username, String password);
}
