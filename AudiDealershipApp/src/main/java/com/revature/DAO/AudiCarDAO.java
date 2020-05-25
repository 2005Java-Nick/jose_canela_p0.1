package com.revature.DAO;

import java.util.ArrayList;
import com.revature.Objects.AudiCar;

/**
 * An Audi Car Data-Access-Object. The user of this interface has both access and control over
 * any car's information that's within the RDS database.
 * <p>
 * The AudiCarDAO interface provides a method for inserting a car's information into the RDS database.
 * <p>
 * The AudiCarDAO interface provides a method for deleting a car's information from the RDS database.
 * <p>
 * The AudiCarDAO interface provides a method for retrieving an car's id given by the RDS database.
 * <p>
 * The AudiCarDAO interface provides two methods for retrieving an Audi's information from the RDS database 
 * and creating an Audi object for further use.
 * <p>
 * The AudiCarDAO interface provides three methods for retrieving a list of Audi car information from the RDS database
 * and returning an ArrayList of AudiCar objects for further use (where each AudiCar object holds a particular set of information).
 * 
 * @author josecanela
 */
public interface AudiCarDAO {
	
	/**
	 * Creates an Audi object and inserts it's information into the RDS database
	 * utilizing JDBC.
	 * 
	 * @param audi an Audi car
	 */
	public void createCar(AudiCar audi);

	/**
	 * Gets an Audi object's information using its vehicle identification number
	 * and returns an Audi object
	 * 
	 * @param carVin a car's vehicle identification number
	 * @return an Audi object with vehicle identification number carVin
	 */
	public AudiCar readCar(String carVin);

	
	/**
	 * Deletes an Audi with a particular vehicle identification number. 
	 * 
	 * @param carVin a car's Vehicle Identification Number
	 */
	public void deleteCar(String carVin);

	/**
	 * Gets all the Audi cars from the RDS database.
	 * 
	 * @return an ArrayList of all the cars in the RDS database
	 */
	public ArrayList<AudiCar> readAllCars();
	
	/**
	 * Gets all the Audi cars on the Audi dealership lot.
	 * 
	 * @return an ArrayList of all the cars that have not been bought in the RDS database
	 */
	public ArrayList<AudiCar> readAllCarsOnLot();

	/**
	 * Gets all the Audi cars that have been bought by a particular customer
	 * 
	 * @param customerUsername a customer's username
	 * @return an ArrayList of all the cars that have been bought by a particular customer in the RDS database
	 */
	public ArrayList<AudiCar> readCarsOwned(String customerUsername);

	/**
	 * Gets an Audi object's information by its ID
	 * and returns an Audi object
	 * 
	 * @param carId an Audi's ID given by the RDS database.
	 * @return an Audi object
	 */
	public AudiCar readCarByCarId(int carId);

	/**
	 * Gets an Audi's ID
	 * 
	 * @param customerUsername
	 * @return an owned Audi's ID given by the RDS database
	 */
	int readOwnedCarId(String customerUsername);
	
}

