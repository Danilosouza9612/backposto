package com.meuposto.repository;



import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.meuposto.model.Abastecimento;
import com.meuposto.model.ProjecaoQuery07;

@Repository
public interface AbastecimentoRepository extends JpaRepository<Abastecimento, Integer> {
	
	
	@Query(value = 
			"CALL novo_abastecimento(:data, :qtdLitros, :bombaId, :cpf, :nome)",nativeQuery = true)
	public void cadastrarAbastecimento(@Param("data") Date data,
													@Param("qtdLitros") float qtdLitros,
													@Param("bombaId") int bombaId,
													@Param("cpf") String cpf,
													@Param("nome") String nome);
	//5)Uma stored procedure para novos abastecimentos(Intermitência)	


	// 7)Dado um dia, listar todos os abastecimentos de um posto com nome do
	// combustível, CPF do cliente, quantidade de litros e o preço naquele momento

	@Query(value = "select b.POSTO_id as posto_id, a.data, c.nome as nome_cliente, c.cpf,cb.nome,a.qtd_litros,a.preco from COMBUSTIVEL as cb "
			+ "inner join BOMBA as b on cb.id = b.COMBUSTIVEL_id "
			+ "inner join ABASTECIMENTO as a on b.id = a.BOMBA_id " 
			+ "inner join CLIENTE as c on a.CLIENTE_id = c.id "
			/*+ "where DATE(a.data) = :data_param and b.POSTO_ID = :id_param"*/, nativeQuery = true)
	public List<ProjecaoQuery07> getAbastecimentosPosto();
	@Query(value = "select b.POSTO_id as posto_id, a.data, c.nome as nome_cliente, c.cpf,cb.nome,a.qtd_litros,a.preco from COMBUSTIVEL as cb " + 
			"inner join BOMBA as b on cb.id = b.COMBUSTIVEL_id " + 
			"inner join ABASTECIMENTO as a on b.id = a.BOMBA_id " + 
			"inner join CLIENTE as c on a.CLIENTE_id = c.id " + 
			"order by a.id DESC LIMIT 1 ", nativeQuery=true)
	public List<ProjecaoQuery07> getUltimoAbastecimento();
}
