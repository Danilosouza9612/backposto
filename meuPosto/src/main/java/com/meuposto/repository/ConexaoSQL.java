package com.meuposto.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoSQL {
	private Connection connection;

	public ConexaoSQL() throws SQLException {
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/posto", "root", "123456");
	}

	public Connection getConnection() {
		return connection;
	}
}
