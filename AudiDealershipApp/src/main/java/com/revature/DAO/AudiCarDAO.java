package com.revature.DAO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import com.revature.Objects.AudiCar;
import org.apache.log4j.Logger;

/**
 * @author josecanela
 *
 */
@SuppressWarnings("serial")
public interface AudiCarDAO {
	
	/**
	 * @param audi
	 */
	public void createCar(AudiCar audi);

	/**
	 * @param carVin
	 * @return
	 */
	public AudiCar readCar(String carVin);

	
	/**
	 * @param carVin
	 */
	public void deleteCar(String carVin);

	/**
	 * @return
	 */
	public ArrayList<AudiCar> readAllCars();
	
	/**
	 * @return
	 */
	public ArrayList<AudiCar> readAllCarsOnLot();

	/**
	 * @param customerUsername
	 * @return
	 */
	public ArrayList<AudiCar> readCarsOwned(String customerUsername);

	/**
	 * @param carId
	 * @return
	 */
	public AudiCar readCarByCarId(int carId);
	
}

