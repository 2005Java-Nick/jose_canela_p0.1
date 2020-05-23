package com.revature.Services;

import com.revature.Objects.Customer;
import com.revature.Objects.Employee;

/**
 * @author josecanela
 *
 */
public interface Authenticate {

	
	/**
	 * @param id
	 * @param customerUsername
	 * @param Password
	 * @return
	 */
	public boolean authenticateCustomer(String customerUsername, String Password);
	
	/**
	 * @param id
	 * @param employeeUsername
	 * @param employeePassword
	 * @return
	 */
	public boolean authenticateEmployee(String employeeUsername, String employeePassword);
	
	/**
	 * @param customerUsername
	 * @return
	 */
	public Customer getCustomerByUsername(String customerUsername);
	
	/**
	 * @param employeeUsername
	 * @return
	 */
	public Employee getEmployeeByUsername(String employeeUsername);
	
}
