package com.revature.Services;

import com.revature.Objects.Payment;

/**
 * @author josecanela
 *
 */
public interface ManageAudiPayments {
	// As an employee, I can view all payments.
		/**
		 * 
		 */
		public void viewAllPayments();
		

		public void createPayment(Integer custId,Integer carId, Double paymentAmount);
		
		/**
		 * @param username
		 */
		public void CustomerBalance(String username);


		void viewAudiCarsAndPaymentInfo(String username);


		void customerPaymentHistory(String username);
}
