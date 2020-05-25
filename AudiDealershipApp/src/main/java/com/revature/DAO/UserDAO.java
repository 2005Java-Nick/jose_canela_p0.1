package com.revature.DAO;

import java.util.ArrayList;
import com.revature.Objects.Customer;
import com.revature.Objects.Employee;


/**
 * A User Data-Access-Object. The user of this interface has both access and control over
 * any customer information regarding authentication/registration and payment history within the RDS database. In addition,
 * the user of this interface has control over any employee information regarding authentication/registration within the RDS database.
 * <p>
 * The UserDAO interface provides a method for inserting a customer's authentication/registration information into the RDS database.
 * <p>
 * The UserDAO interface provides a method for inserting an employee's authentication/registration information into the RDS database.
 * <p>
 * The UserDAO interface provides a method for deleting a customer's account from the RDS database.
 * <p>
 *  The UserDAO interface provides two methods for retrieving a customer's information from the RDS database 
 * and creating a Customer object for further use.
 * <p>
 * The UserDAO interface provides one method for retrieving an employee's information from the RDS database 
 * and creating an Employee object for further use.
 * <p>
 * The UserDAO interface provides a method for retrieving a list of all customer information for from the RDS database
 * and returning an ArrayList of Customer objects for further use (where each Customer object holds a particular set of information).
 *  
 * @author josecanela
 */
public interface UserDAO {
	/**
	 * Creates a Customer object and inserts it's information into the RDS database
	 * utilizing JDBC.
	 * 
	 * @param customer a Customer object
	 */
	public void createCustomer(Customer customer);
	
	/**
	 * Gets a customer's information using the customer's ID
	 * and returns a Customer object.
	 * 
	 * @param id a customer's ID
	 * @return a Customer object
	 */
	public Customer readCustomer(Integer id);
	
	/**
	 * Gets a customer's information using the customer's username
	 * and returns a Customer object.
	 * 
	 * @param username a customer's username
	 * @return a Customer object
	 */
	public Customer readCustomerByUsername(String username);
	
	/**
	 * Deletes a customer account from the RDS database
	 * 
	 * @param user a Customer object
	 */
	public void deleteCustomer(Customer user);
	
	/**
	 * Gets all currently registered customers
	 * 
	 * @return an ArrayList of all customers in the RDS database
	 */
	public ArrayList<Customer> readAllCustomers();
	
	/**
	 * Creates an Employee object and inserts it's information into the RDS database
	 * utilizing JDBC.
	 * 
	 * @param employee an Employee object
	 */
	public void createEmployee(Employee employee);
	
	/**
	 * Gets an employee information using the employee's username
	 * and returns an Employee object.
	 * 
	 * @param employeeUsername an employee's username
	 * @return
	 */
	public Employee readEmployeeByUsername(String employeeUsername);

}
