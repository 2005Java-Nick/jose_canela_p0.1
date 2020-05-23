package com.revature.DAO;

import java.util.ArrayList;

import com.revature.Objects.Offer;

/**
 * @author josecanela
 *
 */
public interface OfferDAO {
	
	/**
	 * @param offer
	 */
	public void createOffer(Offer offer);

	/**
	 * @param userId
	 * @param carId
	 * @return
	 */
	public Offer readOffer(Integer userId, Integer carId);

	/**
	 * @param offer
	 * @param id
	 */
	public void updateOffer(Offer offer, int id);
	
	/**
	 * @param offerId
	 */
	public void acceptOffer(Integer customerId);

	/**
	 * @param offerId
	 */
	public void deleteOffer(Integer offerId);
	
	/**
	 * @param custId
	 */
	public void deleteOfferByCust(Integer custId);

	/**
	 * @return
	 */
	public ArrayList<Offer> readAllOffers();

}
