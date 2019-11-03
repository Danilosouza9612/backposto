package com.meuposto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.meuposto.model.Gerente;
import com.meuposto.model.ProjecaoGerente;

@Repository
public interface GerenteRepository extends JpaRepository<Gerente, Integer>  {

	@Query(value = "SELECT id, nome, cpf FROM GERENTE", nativeQuery=true)
	public List<ProjecaoGerente> getGerentes();
}
