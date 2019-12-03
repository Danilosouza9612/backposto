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

	@Query(value = "SELECT ANY_VALUE(p.nome_fantasia) as nomeFantasia, IF(ANY_VALUE(a.id) IS NULL, 0 ,SUM(a.preco*a.qtd_litros)) as faturamento, ANY_VALUE(p.telefone) " + 
			"FROM (SELECT * FROM ABASTECIMENTO WHERE MONTH(data) = :mes_param AND YEAR(data) = :ano_param ) as a " + 
			"RIGHT JOIN BOMBA as b ON b.id = a.BOMBA_id " + 
			"INNER JOIN POSTO as p ON p.id = b.POSTO_id " + 
			"GROUP BY b.POSTO_id ", nativeQuery = true)
	public List<ProjecaoQuery9> getFaturamento(@Param("mes_param") int mes,
			@Param("ano_param") int ano);
}
