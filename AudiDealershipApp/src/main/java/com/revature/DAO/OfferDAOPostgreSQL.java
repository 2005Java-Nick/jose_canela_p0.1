package com.revature.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.revature.Objects.Offer;
import com.revature.Util.ConnectionFactory;

/**
 * @author josecanela
 *
 */
public class OfferDAOPostgreSQL implements OfferDAO{
	private static Logger log = Logger.getRootLogger();
	
	@Override
	public void createOffer(Offer offer) {
		// TODO Auto-generated method stub
		String sql = " call make_offer(?,?,?,?)";
		Connection conn = ConnectionFactory.getConnection();

		try {
			CallableStatement call = conn.prepareCall(sql);
			
			call.setInt(1,offer.getCustomerId());
			call.setInt(2,offer.getCarId());
			call.setDouble(3,offer.getOfferAmount());
			call.setBoolean(4,offer.isAccepted());
			
			call.execute();
			
			log.info("Offer added.");
		} catch (SQLException e) {
			log.trace(e.getMessage());

		} finally {
			try {
				conn.close();
				
				log.trace("Connection Closed");
			} catch (SQLException e) {
				
				log.trace(e.getMessage());
			}
		}
	}

	@Override
	public Offer readOffer(Integer customerId, Integer carId) {
		// TODO Auto-generated method stub
		String sql = "select * from offer where offer_customer_id = ? + and offer_car_id = ?";
		Connection conn = ConnectionFactory.getConnection();
		Offer offer = null;

		try {
			PreparedStatement stmt = conn.prepareStatement(sql);;
			stmt.setInt(1, customerId);
			stmt.setInt(2, carId);
			
			ResultSet ret = stmt.executeQuery();
			if(ret.next()) {
			offer = new Offer(ret.getInt(2), ret.getInt(3), ret.getDouble(4),
					ret.getBoolean(5));
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
		return offer;
	}

	@Override
	public void acceptOffer(Integer customerId) {
		// TODO Auto-generated method stub
		String sql = "call accept_offer(?)";
		Connection conn = ConnectionFactory.getConnection();

		try {
			CallableStatement call = conn.prepareCall(sql);
			call.setInt(1,customerId);
			
			call.execute();
			
			log.info("Offer accepted");
		} catch (SQLException e) {
			log.trace(e.getMessage());

		} finally {
			try {
				conn.close();
				
				log.trace("Connection Closed");
			} catch (SQLException e) {
				
				log.trace(e.getMessage());
			}
		}
	}

	@Override
	public void deleteOffer(Integer offerId) {
		// TODO Auto-generated method stub
		String sql = "call delete_offer_by_id(?)";
		Connection conn = ConnectionFactory.getConnection();

		try {
			CallableStatement call = conn.prepareCall(sql);
			call.setInt(1,offerId);
			
			call.execute();
			
			log.info("Offer("+offerId+") deleted from DB");	
		} catch (SQLException e) {
			log.trace(e.getMessage());

		} finally {
			try {
				conn.close();
				
				log.trace("Connection Closed");
			} catch (SQLException e) {
				
				log.trace(e.getMessage());
			}
		}
	}
	
	@Override
	public void deleteOfferByCust(Integer custId) {
		// TODO Auto-generated method stub
		String sql = "call delete_offer_by_cust(?)";
		Connection conn = ConnectionFactory.getConnection();

		try {
			CallableStatement call = conn.prepareCall(sql);
			call.setInt(1,custId);
			
			call.execute();
			
			log.info("Offer w/ customer id("+custId+") deleted from DB");	
		} catch (SQLException e) {
			log.trace(e.getMessage());

		} finally {
			try {
				conn.close();
				
				log.trace("Connection Closed");
			} catch (SQLException e) {
				
				log.trace(e.getMessage());
			}
		}
	}
	
	@Override
	public ArrayList<Offer> readAllOffers() {
		// TODO Auto-generated method stub
		String sql = "select * from all_offers()";
		Connection conn = ConnectionFactory.getConnection();
		ArrayList<Offer> allOffers = new ArrayList<Offer>();
		
		try {
			PreparedStatement call = conn.prepareStatement(sql);
			ResultSet ret = call.executeQuery();

			while (ret.next()) {
				allOffers.add(new Offer(ret.getInt(2),ret.getInt(3),ret.getDouble(4),ret.getBoolean(5)));
			}
			log.info("readAllOffers:Retrieved all offers");
			
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
		return allOffers;
	}

}
