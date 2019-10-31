package com.meuposto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.meuposto.model.Cliente;
import com.meuposto.model.ProjecaoQuery11;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

	// 11)Informar nome e CPF de clientes que foram no posto duas vezes ou mais

	@Query(value = "select c.nome, c.cpf, COUNT(c.id) from CLIENTE as c " + "INNER JOIN ABASTECIMENTO as a "
			+ "ON a.CLIENTE_id = c.id " + "GROUP BY c.id " + "HAVING COUNT(c.id) >= 2", nativeQuery = true)
	public List<ProjecaoQuery11> getClientesByFrequencia();
	
	//4) Uma stored procedure para inserir clientes(Intermitência)
	
	@Query(value = "call inserir_clientes(:cpf_param,:nome_param)",nativeQuery = true)
	public ResponseEntity<?> cadastrarCliente(@Param("cpf_param") String cpf, @Param("nome_param") String nome);

}
