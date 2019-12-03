package com.meuposto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.meuposto.model.Frentista;

public interface FrentistaRepository extends JpaRepository<Frentista, Integer>{
	@Query(value = "SELECT f FROM FRENTISTA f WHERE f.posto.id = :id")
	public List<Frentista> getFrentistas(@Param("id") int id);
}
