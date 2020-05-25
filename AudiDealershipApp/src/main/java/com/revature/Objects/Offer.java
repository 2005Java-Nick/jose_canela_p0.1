package com.revature.Objects;

import java.util.Objects;


/**
 * An offer that a customer places on a car
 * 
 * @author josecanela
 */
public class Offer {
	/** A customer offer's ID */
	private int offerId;
	/** The ID of the customer that made the offer on a car*/
	private int customerId;
	/** The ID of the car that the customer made an offer on*/
	private int carId;
	/** The customer's offer amount*/
	private Double offerAmount;
	/** Whether or not an employee accepted the customer's offer*/
	private boolean accepted;

	/**
	 * Instantiates an Offer object (that an employee has not accepted) with a customer ID,
	 * a car ID, and an offer amount.
	 * 
	 * @param customerId the ID of the customer that made the offer on a car
	 * @param carId the ID of the car that the customer made an offer on
	 * @param offerAmount the customer's offer amount
	 * @param accepted whether or not an employee accepted the customer's offer
	 */
	public Offer(int customerId, int carId, Double offerAmount, boolean accepted) {
		super();
		this.customerId = customerId;
		this.carId = carId;
		this.offerAmount = offerAmount;
		this.accepted = false;
	}

	/**
	 * Instantiates an Offer object with a customer ID, a car ID, an offer amount, 
	 * and whether or not an employee accepted the customer's offer.
	 * 
	 * @param customerId the ID of the customer that made the offer on a car
	 * @param carId the ID of the car that the customer made an offer on
	 * @param offerAmount the customer's offer amount
	 * @param accepted whether or not an employee accepted the customer's offer
	 */
	public void ReadOffer(int customerId, int carId, Double offerAmount, boolean accepted) {
		this.customerId = customerId;
		this.carId = carId;
		this.offerAmount = offerAmount;
		this.accepted = accepted;
	}
	
	/**
	 * Gets a customer offer's ID and returns it
	 * 
	 * @return a customer offer's ID
	 */
	public int getOfferId() {
		return offerId;
	}

	/**
	 * Sets a customer offer's ID
	 * 
	 * @param offerId a customer offer's ID
	 */
	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}

	/**
	 * Gets a customer's offer amount and returns it
	 * 
	 * @return a customer's offer amount
	 */
	public Double getOfferAmount() {
		return offerAmount;
	}

	/**
	 * Sets a customer's offer amount
	 * 
	 * @param offerAmount a customer's offer amount
	 */
	public void setOfferAmount(Double offerAmount) {
		this.offerAmount = offerAmount;
	}

	/**
	 * Gets whether or not an employee accepted the customer's offer and returns true or false
	 * 
	 * @return whether or not an employee accepted the customer's offer
	 */
	public boolean isAccepted() {
		return accepted;
	}

	/**
	 * Sets whether or not an employee accepted the customer's offer as true or false
	 * 
	 * @param accepted whether or not an employee accepted the customer's offer
	 */
	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}

	/**
	 * Gets the ID of the customer that made the offer on a car and returns it
	 * 
	 * @return the ID of the customer that made the offer on a car
	 */
	public int getCustomerId() {
		return customerId;
	}

	/**
	 * Sets the ID of the customer that made the offer on a car
	 * 
	 * @param customerId the ID of the customer that made the offer on a car
	 */
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	/**
	 * Gets the ID of the car that the customer made an offer on and returns it
	 * 
	 * @return the ID of the car that the customer made an offer on
	 */
	public int getCarId() {
		return carId;
	}

	/**
	 * Sets the ID of the car that the customer made an offer on
	 * 
	 * @param carId the ID of the car that the customer made an offer on
	 */
	public void setCarId(int carId) {
		this.carId = carId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(accepted, carId, customerId, offerAmount, offerId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Offer other = (Offer) obj;
		return accepted == other.accepted && carId == other.carId && customerId == other.customerId
				&& Objects.equals(offerAmount, other.offerAmount) && offerId == other.offerId;
	}
}
