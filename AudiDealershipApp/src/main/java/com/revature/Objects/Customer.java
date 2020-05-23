package com.revature.Objects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/**
 * @author josecanela
 *
 */
@SuppressWarnings("serial")
public class Customer extends User {
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

	private Double totalBalance;
	private Double monthlyPayment;
	
	/**
	 * 
	 */
	public Customer() {
		// TODO Auto-generated constructor stub
		super();
		this.totalBalance = 0D;
		this.monthlyPayment = 0D;
	}

	/**
	 * @return
	 */
	public Double getTotalBalance() {
		return totalBalance;
	}

	/**
	 * @param totalBalance
	 */
	public void setTotalBalance(Double totalBalance) {
		this.totalBalance = totalBalance;
	}

	/**
	 * @return
	 */
	public Double getMonthlyPayment() {
		return monthlyPayment;
	}

	/**
	 * @param monthlyPayment
	 */
	public void setMonthlyPayment(Double monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
	}
	
	public Customer(String username, String password,Double monthlyPayment,Double totalBalance) {
		super();
		this.username = username; //unique
		this.password = password;
		this.monthlyPayment = monthlyPayment;
		this.totalBalance = totalBalance;
	}
	//Updated Constructor

	public Customer(String username, String password) {
		super();
		this.username = username;
		this.password = password;
		this.monthlyPayment = 0D;
		this.totalBalance = 0D;
	}

}
