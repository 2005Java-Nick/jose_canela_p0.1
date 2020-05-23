package com.revature.Services;

import org.apache.log4j.Logger;

import com.revature.DAO.AudiCarDAOPostGreSQL;
import com.revature.Objects.*;

/**
 * @author josecanela
 *
 */
public class RemoveRegisteredAudi implements RemoveAudiCar{
	private static Logger log = Logger.getRootLogger();
	AudiCarDAOPostGreSQL audiDAO = new AudiCarDAOPostGreSQL();
	/**
	 * @param carVin
	 */
	public void removeAudiCar(String carVin) {
		if(carVin == null || !(audiDAO.readCar(carVin).getVinNumber().equals(carVin))) {
			System.out.println("Car does not exist");
			
			log.error("removeAudiCar: Employee input car VIN that doesn't exist in DB.");
		}else {
			audiDAO.readAllCars();
			audiDAO.deleteCar(carVin);
			
			log.info("removeAudiCar: Car with VIN ("+ carVin +") removed");
		}
	}

}
