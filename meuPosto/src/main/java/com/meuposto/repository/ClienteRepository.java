package com.meuposto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.meuposto.model.Pessoa;
import com.meuposto.model.ProjecaoQuery11;

@Repository
public interface ClienteRepository extends JpaRepository<Pessoa, Integer> {

	// 11)Informar nome e CPF de clientes que foram no posto duas vezes ou mais

	@Query(value = "select c.id c.nome, c.cpf, COUNT(c.id) from CLIENTE as c " 
			+ "INNER JOIN ABASTECIMENTO as a "
			+ "ON a.CLIENTE_id = c.id " 
			+ "GROUP BY c.id " 
			+ "HAVING COUNT(c.id) >= 2", nativeQuery = true)
	public List<ProjecaoQuery11> getClientesByFrequencia();

}
