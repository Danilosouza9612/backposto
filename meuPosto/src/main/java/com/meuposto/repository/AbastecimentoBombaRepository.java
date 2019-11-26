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
	@Query(value = "SELECT "
			+ "a "
			+ "FROM AbastecimentoBomba a " + 
			"INNER JOIN a.bomba b" + 
			"INNER JOIN a.bandeira " + 
			"INNER JOIN a.bomba.posto " +
			"INNER JOIN a.bomba.combustivel " + 
			"WHERE a.bomba.posto.id = :id AND MONTH(a.data) = :mes AND YEAR(a.data) = :ano ORDER BY data ASC")
	public List<AbastecimentoBomba> getAbastecimentosBomba(@Param("id") int id, @Param("mes") int mes, @Param("ano") int ano);
}
