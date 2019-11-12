package com.meuposto.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Date;
import com.meuposto.model.Abastecimento;

public class AbastecimentoSQL {

	public void novoAbastecimento(Abastecimento abastecimento) throws SQLException {
		Connection connection = new ConexaoSQL().getConnection();
		String sql = "CALL novo_abastecimento(?,?,?,?,?)";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setTimestamp(1, new Timestamp(abastecimento.getData().getTime()));
		statement.setFloat(2, abastecimento.getQtdLitros());
		statement.setInt(3, abastecimento.getBomba().getId());
		statement.setString(4, abastecimento.getCliente().getCpf());
		statement.setString(5, abastecimento.getCliente().getNome());
		statement.execute();
		statement.close();
		connection.close();
	}
}
