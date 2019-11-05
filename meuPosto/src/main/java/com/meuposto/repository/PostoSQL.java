package com.meuposto.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.meuposto.model.Posto;

public class PostoSQL {

	public void novoPosto(Posto posto) throws SQLException {
		Connection connection = new ConexaoSQL().getConnection();
		String sql = "CALL cadastrar_posto(?,?,?,?,?,?,?,?,?)";
		PreparedStatement statement = connection.prepareStatement(sql);
		
		/*
		IN cnpj_param VARCHAR(45), 1
		IN razao_social VARCHAR(45), 2
		IN nome_fantasia VARCHAR(45), 3
		IN telefone VARCHAR(11), 4
		IN cpf_gerente VARCHAR(11), 5
		IN bandeira_id INT 6,
		IN cep VARCHAR(8), 7
		IN numero VARCHAR(10), 8
		IN complemento VARCHAR(45) 9
		 */
		
		statement.setString(1, posto.getCnpj());
		statement.setString(2, posto.getRazaoSocial());
		statement.setString(3, posto.getTelefone());
		statement.setString(4, posto.getNomeFantasia());
		statement.setString(5, posto.getGerente().getCpf());
		if(posto.getBandeira()==null) {
			statement.setString(6, null);
		}else {
			statement.setInt(6, posto.getBandeira().getId());
		}
		statement.setString(7, posto.getEndereco().getCep());
		statement.setString(8, posto.getEndereco().getNumero());
		statement.setString(9, posto.getEndereco().getComplemento());
		statement.execute();
		statement.close();
		connection.close();
	}
	
	
}

