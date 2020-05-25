package com.revature.Services;

import org.apache.log4j.Logger;
import com.revature.DAO.AudiCarDAOPostGreSQL;


/**
 * @author josecanela
 *
 */
public class RemoveRegisteredAudi implements RemoveAudiCar{
	private static Logger log = Logger.getRootLogger();
	AudiCarDAOPostGreSQL audiDAO = new AudiCarDAOPostGreSQL();
	
	@Override
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
