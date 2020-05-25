package com.revature.Objects;

import java.util.Objects;

/**
 * A customer user of the Audi Dealership application
 * 
 * @author josecanela
 */

public class Customer extends User {
	/** A customer's total balance on a car they've bought*/
	private Double totalBalance;
	/** A customer's monthly installment on a car they've bought*/
	private Double monthlyPayment;

	/**
	 * Instantiates a Customer object.
	 */
	public Customer() {
		// TODO Auto-generated constructor stub
		super();
		this.totalBalance = 0D;
		this.monthlyPayment = 0D;
	}

	/**
	 * Gets a customer's total balance on a car they've bought and returns it
	 * 
	 * @return a customer's total balance on a car they've bought
	 */
	public Double getTotalBalance() {
		return totalBalance;
	}

	/**
	 * Sets a customer's total balance on a car they've bought
	 * 
	 * @param totalBalance a customer's total balance on a car they've bought
	 */
	public void setTotalBalance(Double totalBalance) {
		this.totalBalance = totalBalance;
	}

	/**
	 * Gets a customer's monthly installment on a car they've bought and returns it
	 * 
	 * @return a customer's monthly installment on a car they've bought
	 */
	public Double getMonthlyPayment() {
		return monthlyPayment;
	}

	/**
	 * Sets a customer's monthly installment on a car they've bought
	 * 
	 * @param monthlyPayment a customer's monthly installment on a car they've bought
	 */
	public void setMonthlyPayment(Double monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
	}

	/**
	 * Instantiates a Customer object with a username, password, 
	 * monthly installment on a car they've bought, and their total balance on the car
	 * 
	 * @param username a customer's username
	 * @param password a customer's password
	 * @param monthlyPayment a customer's monthly installment on a car they've bought
	 * @param totalBalance a customer's total balance on the car they've bought
	 */
	public Customer(String username, String password,Double monthlyPayment,Double totalBalance) {
		super();
		this.username = username; //unique
		this.password = password;
		this.monthlyPayment = monthlyPayment;
		this.totalBalance = totalBalance;
	}

	/**
	 * Instantiates a Customer object with a username and password, but no payment history.
	 * 
	 * @param username a customer's username
	 * @param password a customer's password
	 */
	public Customer(String username, String password) {
		super();
		this.username = username;
		this.password = password;
		this.monthlyPayment = 0D;
		this.totalBalance = 0D;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(monthlyPayment, totalBalance);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(monthlyPayment, other.monthlyPayment) && Objects.equals(totalBalance, other.totalBalance);
	}

}
