package com.meuposto.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.meuposto.model.Login;

public class GerenteSQL {
	public int toLogin(Login login) throws SQLException {
		Connection connection = new ConexaoSQL().getConnection();
		String sql = "CALL login(?,?)";
		PreparedStatement statement = connection.prepareStatement(sql);
		
		statement.setString(1, login.getCpf());
		statement.setString(2, login.getSenha());
		ResultSet set = statement.executeQuery();
		
		if(set.next()) {
			return set.getInt(1);
		}
		
		return -1;
	}
}
