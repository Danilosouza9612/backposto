package com.meuposto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.meuposto.model.Bomba;
import com.meuposto.model.ProjecaoBomba;
import com.meuposto.model.ProjecaoQuery08;

@Repository
public interface BombaRepository extends JpaRepository<Bomba, Integer> {

	/*
	 * 8)Listar as bombas de combustível com nome do combustível de um posto com
	 * quantidade inferior a 100 litros.
	 */

	@Query(value = "select b.preco,b.qtd_restante,p.nome_fantasia,c.nome as nome_combustivel from POSTO as p "
			+ "inner join BOMBA as b on p.id = b.POSTO_id " + "inner join COMBUSTIVEL as c on b.COMBUSTIVEL_id = c.id "
			+ "WHERE b.qtd_restante < 1000", nativeQuery = true)
	public List<ProjecaoQuery08> getBombaInferior100Litros();

	/*
	 * 6)Uma stored procedure para informar as bombas de combustível com nome do
	 * posto e tipo de combustível com quantidade inferior a 1000 litros
	 * (Intermitência – Deve-se saber em tempo real quais bombas estão com
	 * quantidade inferior a 1000 litros para solicitar um novo abastecimento)
	 */

	@Query(value = "call Verificar_Bombas_Combustivel(:id_param)", nativeQuery = true)
	public int getBombaInferior1000Litros(@Param("id_param") int id);
	@Query(value = "SELECT b.id, c.nome FROM BOMBA as b INNER JOIN COMBUSTIVEL as c ON b.COMBUSTIVEL_id = c.id WHERE b.POSTO_id = :id_param ;", nativeQuery = true)
	public List<ProjecaoBomba> getBombas(@Param("id_param") int id);
}
