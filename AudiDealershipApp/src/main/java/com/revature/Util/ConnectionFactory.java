package com.revature.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private static String url;
	private static String username;
	private static String password;
	private static String dbName;
	private static String port;

	private static ConnectionFactory cf;
	
	
	
	
	private ConnectionFactory() {
		
		
		dbName = System.getenv("RDS_DBNAME"); 
		port = System.getenv("RDS_PORT");
		url = System.getenv("RDS_HOSTNAME");
		url = "jdbc:postgresql://" + url + ":"+ port +"/" + dbName + "?";
		username = System.getenv("RDS_USERNAME");
		password = System.getenv("RDS_PASSWORD");
	}
	
	private Connection createConnection() {
		Connection conn = null;

		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Failed to load Driver");
		}

		try {
			conn = DriverManager.getConnection(url,username, password);
		} catch (SQLException e) {
			System.out.println("Unable to make connection");
			e.printStackTrace();
		}

		return conn;

	}


	public static Connection getConnection() {

		if (cf == null) {
			cf = new ConnectionFactory();
		}

		return cf.createConnection();
	}

}
