package com.jithin.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBAccess {

	public static Connection getMySqlConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcUrl = "jdbc:mysql://" + DBConstants.MYSQL_HOST 
					+ ":" + DBConstants.MYSQL_PORT + "/" + DBConstants.MYSQL_DB_NAME;
			Connection connection = DriverManager.getConnection(
					jdbcUrl, 
					DBConstants.MYSQL_USERNAME, 
					DBConstants.MYSQL_PASSWORD
			);
			return connection;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String args[]) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3301/"+DBConstants.MYSQL_DB_NAME, "root", "root");
			//  root is username and password
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from questions");
			while (rs.next())
				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
