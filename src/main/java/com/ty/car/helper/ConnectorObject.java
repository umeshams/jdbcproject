package com.ty.car.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectorObject {

	static String url = "jdbc:mysql://localhost:3306/learn_first";
	static String username = "root";
	static String password = "root";

	static {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection connect() {
		Connection connection = null;

		try {
			connection = DriverManager.getConnection(url, username, password);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return connection;
	}
}
