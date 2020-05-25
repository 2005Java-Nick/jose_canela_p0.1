package com.revature.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import com.revature.Objects.Payment;
import com.revature.Util.ConnectionFactory;

/**
 * @author josecanela
 *
 */
public class PaymentDAOPostgreSQL implements PaymentDAO{
	private static Logger log = Logger.getRootLogger();
	Payment pay = new Payment();
	
	@Override
	public void makePayment(Payment payment) {
		// TODO Auto-generated method stub
		
		String sql = "call make_payment(?,?,?)";
		Connection conn = ConnectionFactory.getConnection();

		try {
			CallableStatement call = conn.prepareCall(sql);
			
			call.setInt(1,payment.getCustId());
			call.setInt(2,payment.getCarId());
			call.setDouble(3,payment.getPaymentAmount());
			
			call.execute();
			
			log.info("Payment("+payment.getPaymentId()+") added.");
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
	public Payment readPayment(int id) {
		// TODO Auto-generated method stub
		
		String sql = "select * from payment where payment_id = ?";
		Connection conn = ConnectionFactory.getConnection();
		Payment payment = null;

		try {
			PreparedStatement call = conn.prepareStatement(sql);
			call.setInt(1, id);
			
			ResultSet ret = call.executeQuery();
			if(ret.next()) {
				payment = new Payment(ret.getInt(2),ret.getInt(3),ret.getDouble(4),ret.getTimestamp(5));
				
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
		return payment;
	}
	
	@Override
	public Payment readPaymentByCust(int custId) {
		// TODO Auto-generated method stub
		String sql = "select * from payment where payment_customer_id = ?";
		Connection conn = ConnectionFactory.getConnection();
		Payment payment= null;

		try {
			PreparedStatement call = conn.prepareStatement(sql);
			call.setInt(1, custId);
			
			ResultSet ret = call.executeQuery();
			while(ret.next()) {
				payment = new Payment(ret.getInt(2),ret.getInt(3),ret.getDouble(4),ret.getTimestamp(5));
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
		return payment;
	}
	

	@Override
	public ArrayList<Payment> readAllPayments() {
		// TODO Auto-generated method stub
		String sql = "select * from all_customer_payments()";
		Connection conn = ConnectionFactory.getConnection();
		ArrayList<Payment> allPayments = new ArrayList<Payment>();
		
		try {
			PreparedStatement call = conn.prepareStatement(sql);
			ResultSet ret = call.executeQuery();

			while (ret.next()) {
				allPayments.add(new Payment(ret.getInt(2),ret.getInt(3),ret.getDouble(4),ret.getTimestamp(5)));
			}
			
			log.info("readAllPayments:Retrieved all payments made");
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
		return allPayments;
	}

	@Override
	public ArrayList<Payment> readCustomerPayments(Integer custId) {
		// TODO Auto-generated method stub
		String sql = "select * from all_my_payments(?)";
		Connection conn = ConnectionFactory.getConnection();
		ArrayList<Payment> allMyPayments = new ArrayList<Payment>();
		
		try {
			PreparedStatement call = conn.prepareStatement(sql);
			call.setInt(1,custId);
			
			ResultSet ret = call.executeQuery();
			while (ret.next()) {
				allMyPayments.add(new Payment(ret.getInt(2),ret.getInt(3),ret.getDouble(4),ret.getTimestamp(5)));
			}
			
			log.info("readAllPayments:Retrieved all payments made");
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
		return allMyPayments;
	}

}
