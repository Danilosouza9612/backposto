package com.meuposto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.meuposto.model.Combustivel;
import com.meuposto.model.ProjecaoQuery10;

@Repository
public interface CombustivelRepository extends JpaRepository<Combustivel, Integer> {

	// 10)Informar a quantidade de abastecimentos de cada combustível em um
	// determinado posto
	@Query(value = "select count(cb.id), cb.nome from abastecimento as a " + "inner join bomba as b "
			+ "on b.id = a.bomba_id " + "inner join posto as p " + "on b.posto_id = p.id "
			+ "inner join combustivel as cb " + "on cb.id = b.combustivel_id " + "where p.id = :id_param "
			+ "group by cb.id", nativeQuery = true)
	public List<ProjecaoQuery10> getQtdAbastecimento(@Param("id_param") int id);
}
