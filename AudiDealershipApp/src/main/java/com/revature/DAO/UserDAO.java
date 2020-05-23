package com.revature.DAO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;

import com.revature.Objects.Customer;
import com.revature.Objects.Employee;
import com.revature.Objects.User;


/**
 * @author josecanela
 *
 */
@SuppressWarnings("serial")
public interface UserDAO {//implements Serializable {
	/**
	 * @param customer
	 */
	public void createCustomer(Customer customer);
	/**
	 * @param id
	 * @return
	 */
	public Customer readCustomer(Integer id);
	/**
	 * @param username
	 * @return
	 */
	public Customer readCustomerByUsername(String username);
	/**
	 * @param user
	 */
	public void deleteCustomer(Customer user);
	/**
	 * @return
	 */
	public ArrayList<Customer> readAllCustomers();
	
	/**
	 * @param employee
	 */
	public void createEmployee(Employee employee);
	/**
	 * @param id
	 * @return
	 */
	public Employee readEmployeeByUsername(String employeeUsername);

	public void viewCustomerBalance(String username);
}
