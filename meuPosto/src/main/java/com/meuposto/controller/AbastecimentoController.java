package com.meuposto.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meuposto.model.Abastecimento;
import com.meuposto.repository.AbastecimentoRepository;

@RestController
@CrossOrigin
@RequestMapping("/abastecimento")
public class AbastecimentoController {

	@Autowired
	AbastecimentoRepository abastecimentoRepository;

	@GetMapping("/listar")
	public List<Abastecimento> listarAbastecimentos() {
		return abastecimentoRepository.findAll();
	}
	
	@PostMapping("/query05")
	public ResponseEntity<?> cadastrarAbastecimento(Date data,float litros,int bombaId,String cpf,String nome){
		abastecimentoRepository.cadastrarAbastecimento(data,litros,bombaId,cpf,nome);
		return ResponseEntity.ok("Novo abastecimento cadastrado com sucesso");
	}
}
