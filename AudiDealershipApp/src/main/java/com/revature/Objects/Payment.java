package com.revature.Objects;

import java.sql.Timestamp;
import java.util.Objects;


/**
 * A customer's car payment
 * 
 * @author josecanela
 */
public class Payment {
	/** A customer payment's ID*/
	private Integer paymentId;
	/** The customer ID of the customer that made the payment on a car*/
	private Integer custId;
	/** The car ID of the car that a customer made a payment on*/
	private Integer carId;
	/** A customer's payment amount*/
	private Double paymentAmount;
	/** A customer payment's timestamp*/
	private Timestamp timestamp = new Timestamp(System.currentTimeMillis());

	/**
	 * Instantiates a Payment object
	 */
	public Payment() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a Payment object with a customer ID and a car ID
	 * 
	 * @param custId the customer ID of the customer that made the payment on a car
	 * @param carId the car ID of the car that a customer made a payment on
	 */
	public Payment(Integer custId, Integer carId) {
		super();
		this.custId = custId;
		this.carId = carId;
	}

	/**
	 * Instantiates a Payment object with a customer ID, car ID, payment amount, and timestamp
	 * 
	 * @param custId the customer ID of the customer that made the payment on a car
	 * @param carId the car ID of the car that a customer made a payment on
	 * @param paymentAmount a customer's payment amount
	 * @param datetime a customer payment's timestamp
	 */
	public Payment(Integer custId, Integer carId,Double paymentAmount, Timestamp timestamp) {
		super();
		this.custId = custId;
		this.carId = carId;
		this.paymentAmount = paymentAmount;
		this.timestamp = timestamp;
	}
	
	/**
	 * Gets a customer payment's ID and returns it
	 * 
	 * @return
	 */
	public Integer getPaymentId() {
		return paymentId;
	}

	/**
	 * Sets a customer payment's ID
	 * 
	 * @param paymentId a customer payment's ID
	 */
	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	/**
	 * Gets the car ID of the car that a customer made a payment on and returns it
	 * 
	 * @return the car ID of the car that a customer made a payment on
	 */
	public Integer getCarId() {
		return carId;
	}

	/**
	 * Sets the car ID of the car that a customer made a payment on
	 * 
	 * @param carId the car ID of the car that a customer made a payment on
	 */
	public void setCarId(Integer carId) {
		this.carId = carId;
	}
	
	/**
	 * Gets the customer ID of the customer that made the payment on a car and returns it
	 * 
	 * @return the customer ID of the customer that made the payment on a car
	 */
	public Integer getCustId() {
		return custId;
	}

	/**
	 * Sets the customer ID of the customer that made the payment on a car
	 * 
	 * @param custId the customer ID of the customer that made the payment on a car
	 */
	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	/**
	 * Gets a customer's payment amount and returns it
	 * 
	 * @return a customer's payment amount
	 */
	public Double getPaymentAmount() {
		return paymentAmount;
	}

	/**
	 * Sets a customer's payment amount
	 * 
	 * @param paymentAmount a customer's payment amount
	 */
	public void setPaymentAmount(Double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}
	
	/**
	 * Gets a customer payment's timestamp and returns it
	 * 
	 * @return a customer payment's timestamp
	 */
	public Timestamp getTimestamp() {
		return timestamp;
	}

	/**
	 * Sets a customer payment's timestamp
	 * 
	 * @param timestamp a customer payment's timestamp
	 */
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public int hashCode() {
		return Objects.hash(carId, custId, paymentAmount, paymentId, timestamp);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payment other = (Payment) obj;
		return Objects.equals(carId, other.carId) && Objects.equals(custId, other.custId)
				&& Objects.equals(paymentAmount, other.paymentAmount)
				&& Objects.equals(paymentId, other.paymentId) && Objects.equals(timestamp, other.timestamp);
	}
	
}
