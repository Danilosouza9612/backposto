package com.meuposto.repository;


import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.meuposto.model.Abastecimento;

@Repository
public interface AbastecimentoRepository extends JpaRepository<Abastecimento, Integer> {
	
	//5)Uma stored procedure para novos abastecimentos(Intermitência)

	@Query(value = "call novo_abastecimento(:data_param,:litros_param,:bombaId_param,:cpf_param,:nome_param)",nativeQuery = true)
	public void cadastrarAbastecimento(@Param("data_param")Date data,@Param("litros_param")float litros,@Param("bombaId_param")int bombaId,@Param("cpf_param")String cpf,@Param("nome_param")String nome);
		

	
}
