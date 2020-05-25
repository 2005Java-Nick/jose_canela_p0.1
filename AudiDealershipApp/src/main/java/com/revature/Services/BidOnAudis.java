package com.revature.Services;

/**
 * An Audi car bidding service for customers
 * <p>
 * The BidOnAudis interface provides a method that allows a customer to make
 * an offer on an Audi car.
 * <p>
 * The BidOnAudis interface provides a method that allows an employee to accept 
 * an offer on an Audi car.
 * 
 * @author josecanela
 */
public interface BidOnAudis {
	
		/**
		 * Creates an Offer object and inserts it's information into the RDS database
		 * utilizing JDBC - hence, placing an offer on an Audi car.
		 * 
		 * @param userid a customer's ID
		 * @param carid the ID of the car that a customer with an ID of userid put an offer on
		 * @param amount a customer's offer amount
		 */
		public void addOffer(Integer userid, Integer carid, Double amount);
		
		/**
		 * Accepts a customer's offer on a car using the customer's username
		 * 
		 * @param username a customer's username
		 */
		public void acceptOffer(String username);

		/**
		 * Prints all current offers on the Audi cars on the lot - or rather, in the AWS RDS database
		 */
		public void getCurrentOffers();
		
		
}
