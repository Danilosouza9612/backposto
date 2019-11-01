package com.meuposto.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public void cadastrarAbastecimento(@RequestParam Date data,@RequestParam float litros,@RequestParam int bombaId,@RequestParam String cpf,@RequestParam String nome){
		abastecimentoRepository.cadastrarAbastecimento(data,litros,bombaId,cpf,nome);
		//return ResponseEntity.ok("Novo abastecimento cadastrado com sucesso");
		//return ResponseEntity.status(HttpStatus.ACCEPTED).body("Novo abastecimento cadastrado com sucesso");
	}
}
