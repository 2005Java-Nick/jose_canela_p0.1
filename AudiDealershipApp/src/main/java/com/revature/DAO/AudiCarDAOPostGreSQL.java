package com.revature.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.revature.Objects.AudiCar;
import com.revature.Util.ConnectionFactory;

/**
 * @author josecanela
 *
 */
public class AudiCarDAOPostGreSQL implements AudiCarDAO{
	private static Logger log = Logger.getRootLogger();
	UserDAOPostgreSQL userDAO = new UserDAOPostgreSQL();
	
	
	@Override
	public void createCar(AudiCar audi) {
		// TODO Auto-generated method stub
		String sql = "call register_car(?,?,?,?,?)";
		Connection conn = ConnectionFactory.getConnection();
		
		try {
			
			CallableStatement call = conn.prepareCall(sql);
		
			call.setString(1,audi.getModel());
			call.setString(2,audi.getYear());
			call.setDouble(3,audi.getPrice());
			call.setString(4,audi.getVinNumber());
			call.setBoolean(5,audi.isOwned());
			
			call.execute();
			log.info("createCar:Vehicle ("+audi.getVinNumber()+") added to lot");
			
		} catch (SQLException e) {
			
			log.trace(e.getMessage());
		} finally {
			try {
				conn.close();
				
				log.trace("DB Connection Closed");
			} catch (SQLException e) {
				
				log.trace(e.getMessage());
			}
		}
	}

	@Override
	public AudiCar readCar(String carVin) {
		// TODO Auto-generated method stub
		String sql = "select * from car_by_vin(?)";
		Connection conn = ConnectionFactory.getConnection();
		AudiCar audi = null;
		
		try {
			
			PreparedStatement call = conn.prepareStatement(sql);
			call.setString(1,carVin);
	
			ResultSet ret = call.executeQuery();
			if(ret.next()) {
			audi = new AudiCar(ret.getString(2),ret.getString(3),ret.getDouble(4),ret.getString(5),ret.getBoolean(6));
			}
			log.info("createCar:Vehicle ("+audi.getVinNumber()+") added to lot");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.trace(e.getMessage());
		} finally {
			try {
				conn.close();
				
				log.trace("DB Connection Closed");
			} catch (SQLException e) {
				
				log.trace(e.getMessage());
			}
		}
		return audi;
	}

	@Override
	public void deleteCar(String carVin) {
		// TODO Auto-generated method stub
		String sql = "call delete_car_from_lot(?)";
		Connection conn = ConnectionFactory.getConnection();
		try {
			
			CallableStatement call = conn.prepareCall(sql);
			call.setString(1,carVin);
			
			call.execute();
			
			log.info("createCar:Vehicle ("+carVin+") added to lot");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.trace(e.getMessage());
		} finally {
			try {
				conn.close();
				
				log.trace("DB Connection Closed");
			} catch (SQLException e) {
				
				log.trace(e.getMessage());
			}
		}
	}
	
	@Override
	public AudiCar readCarByCarId(int carId) {
		String sql = "select * from car where car_id = ?";
		Connection conn = ConnectionFactory.getConnection();
		AudiCar car = null;

		try {
			PreparedStatement call = conn.prepareStatement(sql);
			call.setInt(1, carId);
			
			ResultSet ret = call.executeQuery();
			if(ret.next()) {
			car = new AudiCar(ret.getString(2),ret.getString(3),ret.getDouble(4),ret.getString(5),ret.getBoolean(6));
			}
		} catch (SQLException e) {
			
			log.trace(e.getMessage());
		} finally {
			try {
				conn.close();
				
				log.info("Connection closed");
			} catch (SQLException e) {
				
				log.trace(e.getMessage());
			}
		}
		return car;
	}

	@Override
	public ArrayList<AudiCar> readAllCars() {
		// TODO Auto-generated method stub
		String sql = "select * from car";
		Connection conn = ConnectionFactory.getConnection();
		ArrayList<AudiCar> allAudisInDB = new ArrayList<AudiCar>();
		
		try {
			PreparedStatement call = conn.prepareStatement(sql);
			ResultSet ret = call.executeQuery();

			while (ret.next()) {
				allAudisInDB.add(new AudiCar(ret.getString(2),ret.getString(3),ret.getDouble(4),ret.getString(5),ret.getBoolean(6)));
			}
			
			log.info("readAllCars:Retrieved all cars from DB");
		} catch (SQLException e) {
			
			log.trace(e.getMessage());
		} finally {
			try {
				conn.close();
				
				log.info("Connection closed");
			} catch (SQLException e) {
				
				log.trace(e.getMessage());
			}
		}
		return allAudisInDB;
	}

	@Override
	public ArrayList<AudiCar> readAllCarsOnLot() {
		// TODO Auto-generated method stub
		String sql = "select * from all_cars_on_lot()";
		Connection conn = ConnectionFactory.getConnection();
		ArrayList<AudiCar> allAudisInLot = new ArrayList<AudiCar>();
		
		try {
			PreparedStatement call = conn.prepareStatement(sql);
			ResultSet ret = call.executeQuery();

			while (ret.next()) {
				allAudisInLot.add(new AudiCar(ret.getString(2),ret.getString(3),ret.getDouble(4),ret.getString(5),ret.getBoolean(6)));
			}
			
			log.info("readAllCarsOnLot:Retrieved all cars from lot");
		} catch (SQLException e) {
			
			log.trace(e.getMessage());
		} finally {
			try {
				conn.close();
				
				log.info("Connection closed");
			} catch (SQLException e) {
				
				log.trace(e.getMessage());
			}
		}
		return allAudisInLot;
	}
	@Override
	public int readOwnedCarId(String customerUsername){
		String stmt = "select customer_car_car_id where customer_car_customer_id = ?";
		Connection conn = ConnectionFactory.getConnection();
		int ownedCarId = 0;
		
		try {
			
			PreparedStatement call= conn.prepareStatement(stmt);
			call.setInt(1, userDAO.readCustomerByUsername(customerUsername).getUserId());
			
			ResultSet ret = call.executeQuery();
			if(ret.next()) {
				
				ownedCarId = ret.getInt(1);
			}
			
			log.info("readOwnedCarId:Retrieved Owned Car Id from Owner ("+customerUsername+")");
		} catch (SQLException e) {
			
			log.trace(e.getMessage());
		} finally {
			try {
				conn.close();
				
				log.info("Connection closed");
			} catch (SQLException e) {
				
				log.trace(e.getMessage());
			}
		}
		return ownedCarId;
	};
	
	@Override
	public ArrayList<AudiCar> readCarsOwned(String customerUsername) {
		// TODO Auto-generated method stub
		String sql = "select * from all_my_cars(?)";
		Connection conn = ConnectionFactory.getConnection();
		ArrayList<AudiCar> allAudisOwned = new ArrayList<AudiCar>();
		
		try {
			PreparedStatement call = conn.prepareStatement(sql);
			call.setInt(1, userDAO.readCustomerByUsername(customerUsername).getUserId());
			
			ResultSet ret = call.executeQuery();
			while(ret.next()) {
				
				allAudisOwned.add(readCarByCarId(readOwnedCarId(customerUsername)));
			}
			log.info("readAllOwned:Retrieved all cars owned by ("+customerUsername+")");
		
		} catch (SQLException e) {
			
			log.trace(e.getMessage());
		} finally {
			try {
				conn.close();
				
				log.info("Connection closed");
			} catch (SQLException e) {
				
				log.trace(e.getMessage());
			}
		}
		return allAudisOwned;
	}

}

