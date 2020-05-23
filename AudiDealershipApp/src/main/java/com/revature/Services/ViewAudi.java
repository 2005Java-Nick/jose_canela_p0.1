package com.revature.Services;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import com.revature.DAO.AudiCarDAOPostGreSQL;
import com.revature.DAO.UserDAOPostgreSQL;
import com.revature.Objects.*;

/**
 * @author josecanela
 *
 */
public class ViewAudi implements ViewAudiCars{
	private static Logger log = Logger.getRootLogger();
	AuthenticateUser authUser = new AuthenticateUser();
	UserDAOPostgreSQL userDAO = new UserDAOPostgreSQL();
	AudiCarDAOPostGreSQL audiDAO = new AudiCarDAOPostGreSQL();
	
	@Override
	public void viewAudis(String username, String password) {
		// TODO Auto-generated method stub
		if (authUser.authenticateEmployee(username, password)) {
			for(AudiCar car:audiDAO.readAllCars()) {
				System.out.println("(Audi)"+": "+car.toString());
			}
			
			log.info("viewAudis: Employee ("+username+") viewed all cars DATABASE");
			
		} else if(authUser.authenticateCustomer(username, password)) {
			for(AudiCar car:audiDAO.readAllCarsOnLot()) {
				System.out.println("(Audi)"+": "+car.toString());
			}	
			log.info("viewAudis: Customer ("+username+") viewed all cars ON THE LOT");
		}
		
	}
	
}
