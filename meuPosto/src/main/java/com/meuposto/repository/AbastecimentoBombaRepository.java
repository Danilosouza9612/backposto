package com.meuposto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.meuposto.model.AbastecimentoBomba;
import com.meuposto.model.ProjecaoAbastecimentoBomba;

@Repository
public interface AbastecimentoBombaRepository extends JpaRepository<AbastecimentoBomba, Integer> {
	@Query(value = "SELECT DATE(ab.data), ab.qtd_litros, c.nome as c_nome, ban.nome as ban_nome, ab.preco FROM abastecimento_bomba as ab " + 
			"INNER JOIN bomba as b ON ab.BOMBA_id = b.id " + 
			"INNER JOIN combustivel as c ON c.id = b.COMBUSTIVEL_id " + 
			"INNER JOIN bandeira as ban ON ban.id = ab.BANDEIRA_id " + 
			"WHERE b.POSTO_id = :id AND MONTH(ab.data) = :mes AND YEAR(ab.data) = :ano ORDER BY data ASC", nativeQuery=true)
	public List<ProjecaoAbastecimentoBomba> getAbastecimentosBomba(@Param("id") int id, @Param("mes") int mes, @Param("ano") int ano);
}
