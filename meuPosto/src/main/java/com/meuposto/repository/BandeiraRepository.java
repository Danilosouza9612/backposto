package com.meuposto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.meuposto.model.Bandeira;


public interface BandeiraRepository extends JpaRepository<Bandeira, Integer>{
	
	@Query(value = "SELECT * FROM BANDEIRA", nativeQuery=true)
	public List<Bandeira> getBandeiras();
}
