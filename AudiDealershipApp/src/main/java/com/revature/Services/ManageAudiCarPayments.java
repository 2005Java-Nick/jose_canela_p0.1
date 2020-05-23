package com.revature.Services;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import com.revature.DAO.AudiCarDAO;
import com.revature.DAO.AudiCarDAOPostGreSQL;
import com.revature.DAO.PaymentDAOPostgreSQL;
import com.revature.DAO.UserDAOPostgreSQL;
//import com.revature.DAO.UserDAO;
import com.revature.Objects.*;

/**
 * @author josecanela
 *
 */
/**
 * @author josecanela
 *
 */
public class ManageAudiCarPayments implements ManageAudiPayments{
	private static Logger log = Logger.getRootLogger();

	
	@Override
	public void viewAllPayments() {
		// TODO Auto-generated method stub
		PaymentDAOPostgreSQL paymentDAO = new PaymentDAOPostgreSQL();
		for(Payment payment: paymentDAO.readAllPayments()) {
				System.out.println(payment.toString());
				
				log.info("viewAllPayments: Employee viewed all payments");
		}
	}
	
	@Override
	public void viewAudiCarsAndPaymentInfo(String username) {  
		// TODO Auto-generated method stub
		UserDAOPostgreSQL userDAO = new UserDAOPostgreSQL();
		AudiCarDAOPostGreSQL audiDAO = new AudiCarDAOPostGreSQL();
		Customer cust = userDAO.readCustomerByUsername(username);
		
		System.out.println("Vehicles Owned by: " + username);
		System.out.println("--------------------------------------------------------------------------------------------------------");
		
		for(AudiCar car: audiDAO.readCarsOwned(username)) {
			System.out.println("|-Vehicle: " + "VIN: " + car.getVinNumber() + ", Year: " + car.getYear() + ", Model: " + car.getModel() + " \n" + "|-Original Price: "
					+ car.getPrice() + ", Monthly Installments: $" + cust.getMonthlyPayment() + ", Remaining payments:"
					+ cust.getMonthlyPayment());
			
			System.out.println("--------------------------------------------------------------------------------------------------------");

			log.info("viewAudiCarsAndPaymentInfo: Customer ("+ username +") viewed all of their payments for their cars.");
		}
			
	}
	
	
	@Override
	public void customerPaymentHistory(String username) {
		// TODO Auto-generated method stub
		PaymentDAOPostgreSQL paymentDAO = new PaymentDAOPostgreSQL();
		UserDAOPostgreSQL userDAO = new UserDAOPostgreSQL();
		Customer cust = userDAO.readCustomerByUsername(username);
		
		for(Payment payment: paymentDAO.readCustomerPayments(cust.getUserId())) {
				System.out.println(payment.toString());
				
				log.info("customerPaymentHistory: Customer ("+ username +") viewed all of their payments");
		}
	}
	
	
	@Override
	public void createPayment(Integer custId,Integer carId, Double paymentAmount) {
		// TODO Auto-generated method stub
		PaymentDAOPostgreSQL paymentDAO = new PaymentDAOPostgreSQL();
		Payment pay = new Payment(custId,carId);
		
		pay.setPaymentAmount(paymentAmount);
		
		paymentDAO.makePayment(pay);
		
		log.info("createPayment: A Customer w/ Customer ID ("+ custId +") made of payment of ($"+paymentAmount+").");
	}

	@Override
	public void CustomerBalance(String username) {
		// TODO Auto-generated method stub
		UserDAOPostgreSQL userDAO = new UserDAOPostgreSQL();
		Customer cust = userDAO.readCustomerByUsername(username);
		
		System.out.println(cust.getTotalBalance());
		
		log.info("CustomerBalance: Customer ("+username+") viewed their balance");
	}
	
}
