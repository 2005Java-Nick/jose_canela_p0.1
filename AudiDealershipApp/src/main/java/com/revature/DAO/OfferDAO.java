package com.revature.DAO;

import java.util.ArrayList;
import com.revature.Objects.Offer;

/**
 * An Offer Data-Access-Object. The user of this interface has both access and control over information
 * about any customer's offer on a car that's within the RDS database.
 * <p>
 * The OfferDAO interface provides a method for inserting a customer's offer on a car into the RDS database.
 * <p>
 * The OfferDAO interface provides two methods for deleting a customer's offer on a car from the RDS database.
 * <p>
 * The OfferDAO interface provides a method for retrieving information about a customer's offer on a car
 * from the RDS database and returning an Offer object for further use.
 * <p>
 * The OfferDAO interface provides a method a for retrieving a list of all customer offers on cars from the RDS database
 * and returning an ArrayList of Offer objects for further use (where each Offer object holds a particular set of information).
 * <p>
 * The OfferDAO interface provides a method for accepting a customer's offer on a car.
 * 
 * @author josecanela
 */
public interface OfferDAO {
	
	/**
	 * Creates an Offer object and inserts it's information into the RDS database
	 * utilizing JDBC.
	 * 
	 * @param offer an Offer object
	 */
	public void createOffer(Offer offer);

	/**
	 * Gets an Offer object's information using the ID of the car that a customer placed an 
	 * offer on and the ID of the customer that made an offer on the car and returns an Offer object.
	 * 
	 * @param custId a customer's ID
	 * @param carId the ID of the car that a customer with an ID of userId put an offer on
	 * @return an Offer object
	 */
	public Offer readOffer(Integer custId, Integer carId);

	/**
	 * Accepts a customer's offer on a car using the customer's Id
	 * 
	 * @param customerId a customer's ID.
	 */
	public void acceptOffer(Integer customerId);

	/**
	 * Deletes an offer that was made on a car using the offer's ID.
	 * 
	 * @param offerId an offer's ID
	 */
	public void deleteOffer(Integer offerId);
	
	/**
	 * Deletes an offer that was made on a car using the customer's ID.
	 * 
	 * @param custId a customer's ID
	 */
	public void deleteOfferByCust(Integer custId);

	/**
	 * Gets all of the offers made on cars.
	 * 
	 * @return an ArrayList of all the offers in the RDS database
	 */
	public ArrayList<Offer> readAllOffers();

}
