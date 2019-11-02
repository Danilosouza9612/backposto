package com.meuposto.repository;



import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.meuposto.model.Abastecimento;

@Repository
public interface AbastecimentoRepository extends JpaRepository<Abastecimento, Integer> {
	
	
	@Query(value = 
			"CALL novo_abastecimento(:data, :qtdLitros, :bombaId, :cpf, :nome)",nativeQuery = true)
	public void cadastrarAbastecimento(@Param("data") Date data,
													@Param("qtdLitros") float qtdLitros,
													@Param("bombaId") int bombaId,
													@Param("cpf") String cpf,
													@Param("nome") String nome);
}
