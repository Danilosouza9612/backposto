package com.meuposto.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.meuposto.model.Abastecimento;
import com.meuposto.model.Posto;

public class PostoSQL {

	public void novoPosto(Posto posto) throws SQLException {
		Connection connection = new ConexaoSQL().getConnection();
		String sql = "CALL cadastrar_posto(?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement statement = connection.prepareStatement(sql);
		
		statement.setString(1, posto.getCnpj());
		statement.setString(2, posto.getRazaoSocial());
		statement.setString(3, posto.getNomeFantasia());
		statement.setString(4, posto.getTelefone());
		statement.setString(5, x); //PAREI AQUI
		statement.setString(6, x);
		statement.setString(7, x);
		statement.setString(8, x);
		statement.setString(9, x);
		statement.setString(10, x);
		statement.setString(11, x);
	
		statement.execute();
		statement.close();
		connection.close();
	}
	
	
}

