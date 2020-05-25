package com.revature.Services;


/**
 * A customer car payment management service
 * <p>
 * The ManageAudiPayments interface provides a method that allows an employee user to view
 * all the customer car payments in the AWS RDS database.
 * <p> 
 * The ManageAudiPayments interface provides a method that allows a customer to make a 
 * payment on an Audi car.
 * <p>
 * The ManageAudiPayments interface provides a method that allows a customer to
 * view the information on every car they own - including the customer's payment history
 * pertaining to each car.
 * <p>
 * The ManageAudiPayments interface provides a method that prints all the car payments
 * made by a particular customer.
 * <p>
 * The ManageAudiPayments interface provides a method that gets and prints a customer's
 * total car balance 
 * 
 * @author josecanela
 */
public interface ManageAudiPayments {
		/**
		 * Gets all the customer car payments made on cars and prints them
		 */
		public void viewAllPayments();
		
		/**
		 * Creates a Payment object and inserts it's information into the RDS database
		 * utilizing JDBC - hence, making a payment on a car.
		 * 
		 * @param custId a customer's ID 
		 * @param carId the ID of the car that the customer is making a payment on
		 * @param paymentAmount a customer's payment amount
		 */
		public void createPayment(Integer custId,Integer carId, Double paymentAmount);
		
		/**
		 * Gets and prints a customer's total car balance
		 * 
		 * @param username a customer's username
		 */
		public void CustomerBalance(String username);


		/**
		 * Gets and prints information on all the cars a customer owns and 
		 * the customer's payment history with respect to each car.
		 * 
		 * @param username a customer's username
		 */
		public void viewAudiCarsAndPaymentInfo(String username);


		/**
		 * Gets all the car payments that have been made by a 
		 * particular customer and prints them
		 * 
		 * @param username a customer's username
		 */
		public void customerPaymentHistory(String username);
}
