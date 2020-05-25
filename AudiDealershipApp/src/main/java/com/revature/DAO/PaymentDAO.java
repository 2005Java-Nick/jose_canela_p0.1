package com.revature.DAO;

import java.util.ArrayList;
import com.revature.Objects.Payment;

/**
 * A Payment Data-Access-Object. The user of this interface has both access and control over
 * any customer's car payment information that's within the RDS database.
 * <p>
 * The PaymentDAO interface provides a method for inserting a customer's car payment information into the RDS database.
 * <p>
 * The PaymentDAO interface provides two methods for retrieving a customer's car payment information from the RDS database 
 * and returning a Payment object for further use.
 * <p>
 * The PaymentDAO interface provides a method for retrieving a list of all customer car payment information from the RDS database
 * and returning an ArrayList of Payment objects for further use (where each Payment object holds a particular set of information).
 * <p>
 * The PaymentDAO interface provides a method for retrieving a list of customer car payment information for a particular customer from the RDS database
 * and returning an ArrayList of Payment objects for further use (where each Payment object holds a particular set of information).
 * 
 * @author josecanela
 */
public interface PaymentDAO {
	
	/**
	 * Creates a Payment object and inserts it's information into the RDS database
	 * utilizing JDBC.
	 * <p>
	 * Makes a payment on a car
	 * 
	 * @param customerUsername
	 * @param carVin
	 * @param amount
	 */
	public void makePayment(Payment payment);
	
	/**
	 * Gets a Payment object's information using the customer payment's ID and 
	 * returns a Payment object.
	 * 
	 * @param id a customer payment's ID
	 * @return a Payment object
	 */
	public Payment readPayment(int id);
	
	/**
	 * Gets a Payment object's information using the customer's ID and 
	 * returns a Payment object.
	 * 
	 * @param custId a customer's ID
	 * @return a Payment object
	 */
	public Payment readPaymentByCust(int custId);
	
	/**
	 * Gets all the customer car payments made on cars
	 * 
	 * @return an ArrayList of all customer payments in the RDS database.
	 */
	public ArrayList<Payment> readAllPayments();

	/**
	 * Gets all the car payments that have been made by a particular customer
	 * 
	 * @param custId a customer's ID
	 * @return an ArrayList of all payments that have been made by a particular customer in the RDS database
	 */
	public ArrayList<Payment> readCustomerPayments(Integer custId);

}
