package com.revature.Services;

import java.util.Iterator;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import com.revature.DAO.AudiCarDAO;
import com.revature.DAO.AudiCarDAOPostGreSQL;
import com.revature.DAO.OfferDAOPostgreSQL;
import com.revature.DAO.UserDAO;
import com.revature.DAO.UserDAOPostgreSQL;
import com.revature.Objects.*;

/**
 * @author josecanela
 *
 */
public class BidOnAudiCar implements BidOnAudis{
	private static Logger log = Logger.getRootLogger();

	@Override
	public void addOffer(Integer customerId, Integer carid, Double amount) {
		// TODO Auto-generated method stub
		OfferDAOPostgreSQL offerDAO = new OfferDAOPostgreSQL();
		offerDAO.createOffer(new Offer(customerId, carid, amount, false));
		
		log.info("addOffer: An offer of ($"+amount+") was made on car ("+carid+") by Customer ("+ customerId +")");
	}

	@Override
	public void acceptOffer(String username) {
		// TODO Auto-generated method stub
		UserDAOPostgreSQL userDAO = new UserDAOPostgreSQL();
		Customer cust = userDAO.readCustomerByUsername(username);
		
		OfferDAOPostgreSQL offerDAO = new OfferDAOPostgreSQL();
		offerDAO.acceptOffer(cust.getUserId());
		
		log.info("acceptOffer: Customer ("+cust.getUserId()+") had their offer accepted)");
	}

	public void getCurrentOffers() {
		// TODO Auto-generated method stub
		OfferDAOPostgreSQL offerDAO = new OfferDAOPostgreSQL();
		UserDAOPostgreSQL userDAO = new UserDAOPostgreSQL();
		AudiCarDAOPostGreSQL audiDAO = new AudiCarDAOPostGreSQL();
		
		for(Offer offer:offerDAO.readAllOffers()) {
			System.out.println("("+userDAO.readCustomer(offer.getCustomerId()).getUsername()+", "+audiDAO.readCarByCarId(offer.getCarId()).getVinNumber()+"): " + offer.toString());
		
			log.info("getCurrentOffers: Employee viewed Offer:" + "\n("+userDAO.readCustomer(offer.getCustomerId()).getUsername()+", "+audiDAO.readCarByCarId(offer.getCarId()).getVinNumber()+"): " + offer.toString());
		}
		
	}
	
	
}
