package com.accolite.rest.RestSample.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DataConnection{
	public static Connection connection;
	private DataConnection() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/excersice", "root", "root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	public static Connection getConnection() {
		if(connection == null) {
			DataConnection dataConnection= new DataConnection();
		}
		return connection;
	}
}
