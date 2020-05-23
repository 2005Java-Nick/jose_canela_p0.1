package com.revature.Services;

import org.apache.log4j.Logger;

import com.revature.DAO.AudiCarDAOPostGreSQL;
import com.revature.Objects.*;

/**
 * @author josecanela  
 *
 */
public class RegisterAudi implements RegisterAudiCar{
	private static Logger log = Logger.getRootLogger();
	private static AudiCarDAOPostGreSQL audiDAO = new AudiCarDAOPostGreSQL();
	/**
	 * Works as a log as for the employee
	 * @param vinNumber
	 * @param model
	 * @param year
	 * @param price
	 */
	@Override
	public void addAudiCar(String vinNumber, String model, String year, Double price) {
		if(vinNumber == null || model == null || year == null || price == null) {
			System.out.println("Invalid Entries. A VIN, model, year, AND price must be entered for the Audi. Please try again.");
			
			log.error("addAudiCar: Employee tried to input null values while trying to add an Audi to the database.");
		}
		if (audiDAO.readCar(vinNumber).getVinNumber().equals(vinNumber)) {
			System.out.println("Car ("+ vinNumber+ ", "+ model+ ", "+ year +", "+ price +") already exists in the car lot.");
			
			log.info("addAudiCar:Employee tried to add Car ("+ vinNumber+ ", "+ model+ ", "+ year +", "+ price +") that already exists");
		} else {
			audiDAO.createCar(new AudiCar(model, year, price, vinNumber, false));
			
			log.info("addAudiCar:Car ("+ vinNumber+ ", "+ model+ ", "+ year +", "+ price +") created/registered");
		}

	}
}
