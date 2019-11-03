package com.meuposto.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.meuposto.model.Posto;
import com.meuposto.model.ProjecaoQuery07;
import com.meuposto.model.ProjecaoQuery9;

@Repository
public interface PostoRepository extends JpaRepository<Posto, Integer> {

	// 9)Informar o faturamento de cada posto em um mês

	@Query(value = "SELECT ANY_VALUE(p.nome_fantasia) as nomeFantasia, SUM(a.preco*a.qtd_litros) as faturamento FROM ABASTECIMENTO as a "
			+ "INNER JOIN BOMBA as b " + "ON b.id = a.BOMBA_id " + "INNER JOIN POSTO as p ON p.id = b.POSTO_id "
			+ "WHERE MONTH(a.data) = :mes_param AND YEAR(a.data) = :ano_param "
			+ "GROUP BY b.POSTO_id", nativeQuery = true)
	public List<ProjecaoQuery9> getFaturamento(@Param("mes_param") int mes,
			@Param("ano_param") int ano);

	// 7)Dado um dia, listar todos os abastecimentos de um posto com nome do
	// combustível, CPF do cliente, quantidade de litros e o preço naquele momento

	@Query(value = "select c.cpf,cb.nome,a.qtd_litros,a.preco from COMBUSTIVEL as cb "
			+ "inner join BOMBA as b on cb.id = b.COMBUSTIVEL_id "
			+ "inner join ABASTECIMENTO as a on b.id = a.BOMBA_id " + "inner join CLIENTE as c on a.CLIENTE_id = c.id "
			+ "where DATE(a.data) = :data_param and b.POSTO_ID = :id_param", nativeQuery = true)
	public List<ProjecaoQuery07> getAbastecimentosPosto(@Param("data_param") Date data, @Param("id_param") int id);

}
