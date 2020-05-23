package com.revature.AudiDealership;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.revature.Util.ConnectionFactory;

public class ConnectionTest {
	//Connection conn = ConnectionFactory.getConnection();
	
	@Test
	public void test() {
		ConnectionFactory.getConnection();
	}
}
