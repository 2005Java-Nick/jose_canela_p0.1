package com.revature.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.revature.AudiDealership.Driver;
import com.revature.Objects.Customer;
import com.revature.Objects.Employee;
import com.revature.Objects.Payment;
import com.revature.Objects.User;
import com.revature.Util.ConnectionFactory;

public class UserDAOPostgreSQL implements UserDAO{
	private static Logger log = Logger.getRootLogger();
	@Override
	public void createCustomer(Customer customer) {
		// TODO Auto-generated method stub
		String sql = "call register_customer(?,?,?,?)";
		Connection conn = ConnectionFactory.getConnection();
		//register_customer(username varchar, cust_password varchar, monthly_installment numeric, total_balance numeric)
		
		try {
			CallableStatement call = conn.prepareCall(sql);
			//(cust_id bigint,car_id bigint, amount numeric, payment_time timestamp)
			call.setString(1,customer.getUsername());
			call.setString(2,customer.getPassword());
			call.setDouble(3,0);
			call.setDouble(4,0);
			//call.executeQuery();
			call.executeQuery();
			log.info("Payment("+customer.getUsername()+") added.");
		} catch (SQLException e) {
			log.trace(e.getMessage());

		} finally {
			try {
				conn.close();
				log.trace("Connection Closed");
			} catch (SQLException e) {
				//e.printStackTrace();
				log.trace(e.getMessage());
			}
		}
	}
	
	@Override
	public Customer readCustomer(Integer id) {
		// TODO Auto-generated method stub
		String sql = "Select * from customer where customer_id =?";

		Connection conn = ConnectionFactory.getConnection();

		Customer cust = null;

		try {
			PreparedStatement call = conn.prepareStatement(sql);
			call.setInt(1, id);
			ResultSet ret = call.executeQuery();
			if(ret.next()) {
			cust = new Customer(ret.getString(2),ret.getString(3),ret.getDouble(4), ret.getDouble(5));
			}
		} catch (SQLException e) {
			log.trace(e.getMessage());
		} finally {
			try {
				conn.close();
				log.info("Connection closed");
			} catch (SQLException e) {
				log.trace(e.getMessage());
			} finally {
			}
		}
		return cust;
	}

	@Override
	public Customer readCustomerByUsername(String username) {
		// TODO Auto-generated method stub
		String sql = "select * from customer where customer_username = ?";

		Connection conn = ConnectionFactory.getConnection();

		Customer cust = null;

		try {
			PreparedStatement call = conn.prepareStatement(sql);
			call.setString(1, username);
			ResultSet ret = call.executeQuery();
			if(ret.next()) {
				cust = new Customer(ret.getString(2),ret.getString(3),ret.getDouble(4), ret.getDouble(5));
				
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
		return cust;
	}

	@Override
	public void deleteCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
		//delete_customer(username varchar)
		String sql = "call delete_customer(?)";
		Connection conn = ConnectionFactory.getConnection();
		try {
			CallableStatement call = conn.prepareCall(sql);
			//(cust_id bigint,car_id bigint, amount numeric, payment_time timestamp)
			call.setString(1,customer.getUsername());
			//call.executeQuery();
			call.execute();
			log.info("Customer("+customer.getUsername()+") deleted.");
		} catch (SQLException e) {
			log.trace(e.getMessage());

		} finally {
			try {
				conn.close();
				log.trace("Connection Closed");
			} catch (SQLException e) {
				//e.printStackTrace();
				log.trace(e.getMessage());
			}
		}
	}

	@Override
	public ArrayList<Customer> readAllCustomers() {
		// TODO Auto-generated method stub
		
		String sql = "select * from all_customers()";
		Connection conn = ConnectionFactory.getConnection();
		ArrayList<Customer> allCustomers = new ArrayList<Customer>();
		try {
			PreparedStatement call = conn.prepareStatement(sql);
			ResultSet ret = call.executeQuery();

			while (ret.next()) {
				allCustomers.add(new Customer(ret.getString(2),ret.getString(3),ret.getDouble(4), ret.getDouble(5)));
			}
			log.info("readAllCustomers:Retrieved all customers");
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
		return allCustomers;
	}

	@Override
	public void viewCustomerBalance(String username) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
		//register_employee(username varchar, pw varchar)
		String sql = "call register_employee(?,?)";
		Connection conn = ConnectionFactory.getConnection();
		try {
			CallableStatement call = conn.prepareCall(sql);
			//(cust_id bigint,car_id bigint, amount numeric, payment_time timestamp)
			call.setString(1,employee.getUsername());
			call.setString(2,employee.getPassword());
			//call.executeQuery();
			call.execute();
			log.info("Employee("+employee.getUsername()+") added.");
		} catch (SQLException e) {
			log.trace(e.getMessage());

		} finally {
			try {
				conn.close();
				log.trace("Connection Closed");
			} catch (SQLException e) {
				//e.printStackTrace();
				log.trace(e.getMessage());
			}
		}
	}

	@Override
	public Employee readEmployeeByUsername(String employeeUsername) {
		// TODO Auto-generated method stub
		String sql = "select * from employee where employee_username = ?";

		Connection conn = ConnectionFactory.getConnection();

		Employee emp = null;

		try {
			PreparedStatement call = conn.prepareStatement(sql);
			call.setString(1,employeeUsername);
			ResultSet ret = call.executeQuery();
			if(ret.next()) {
			emp = new Employee(ret.getString(2),ret.getString(3));
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
		return emp;
	}

}
