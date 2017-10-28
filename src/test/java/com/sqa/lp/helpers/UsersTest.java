package com.sqa.lp.helpers;

import java.sql.*;

import org.testng.annotations.*;

public class UsersTest {

	@Test
	public void testDBConnection() throws ClassNotFoundException, SQLException {
		// Create driver for MySQL database
		Class.forName("com.mysql.jdbc.Driver");
		// Create the Connection by calling the getConnection method of the
		// DriverManager and passing in the URL for the database along with the
		// username and password to connect to the database
		Connection dbconn =
				DriverManager.getConnection("jdbc:mysql://localhost:8889/sqadb", "root", "root");
		// Statement is return when you create one from the Connection so that
		// Queries can be executed
		Statement stmt = dbconn.createStatement();
		// ResultSet object is return when you call the executeQuery method of
		// the Statement object
		ResultSet rs = stmt.executeQuery("select * from users");
		// You will want to perform a loop based on the results or ResultSet
		// object
		while (rs.next()) {
			// Use the proper method to get specific return types, getInt(),
			// getString()
			int userID = rs.getInt("id");
			// Pass a String to specify the column name, or an int to specify
			// column number
			String userName = rs.getString(2);
			String userPass = rs.getString("password");
			String userAlias = rs.getString(4);
			System.out.println(" userID= " + userID + " userName = " + userName + " password="
					+ userPass + " userAlias= " + userAlias);
		}
		// Close all connections to prevent memory leaks
		rs.close();
		stmt.close();
		dbconn.close();
	}
}
