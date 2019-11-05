package com.meuposto.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.meuposto.model.AbastecimentoBomba;

public class AbastecimentoBombaSQL {

	public void novoAbastecimentoBomba(AbastecimentoBomba abastecimentoBomba) throws SQLException {
		Connection connection = new ConexaoSQL().getConnection();
		String sql = "INSERT INTO ABASTECIMENTO_BOMBA(BOMBA_id, data, qtd_Litros, preco, BANDEIRA_id)"
				+ " values(?,?,?,?,?)";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, abastecimentoBomba.getBomba().getId());
		statement.setDate(2, new Date(abastecimentoBomba.getData().getTime()));
		statement.setFloat(3, abastecimentoBomba.getPreco());
		statement.setFloat(4, abastecimentoBomba.getQtdLitros());
		statement.setInt(5, abastecimentoBomba.getBandeira().getId());
		statement.execute();
		statement.close();
		connection.close();
	}

}
