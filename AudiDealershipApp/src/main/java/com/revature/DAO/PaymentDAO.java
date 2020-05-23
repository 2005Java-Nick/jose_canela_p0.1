package com.revature.DAO;

import java.util.ArrayList;

import com.revature.Objects.Payment;

/**
 * @author josecanela
 *
 */
public interface PaymentDAO {
	
	/**
	 * @param customerUsername
	 * @param carVin
	 * @param amount
	 */
	public void makePayment(Payment payment);
	/**
	 * @param id
	 * @return
	 */
	public Payment readPayment(int id);
	public Payment readPaymentByCust(int custId);
	/**
	 * @return
	 */
	public ArrayList<Payment> readAllPayments();

	/**
	 * @param userId
	 * @return
	 */
	public ArrayList<Payment> readCustomerPayments(Integer custId);

}
