package com.meuposto.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meuposto.model.Abastecimento;
import com.meuposto.repository.AbastecimentoRepository;
import com.meuposto.repository.AbastecimentoSQL;

@RestController
@CrossOrigin
@RequestMapping("/abastecimento")
public class AbastecimentoController {

	@Autowired
	AbastecimentoRepository abastecimentoRepository;
	private AbastecimentoSQL absSQL;
	
	public AbastecimentoController() {
		this.absSQL = new AbastecimentoSQL();
	}

	@GetMapping("/listar")
	public List<Abastecimento> listarAbastecimentos() {
		return abastecimentoRepository.findAll();
	}
	
	@PostMapping("/query05")
	public ResponseEntity<?> cadastrarAbastecimento(@RequestBody String body) throws JsonParseException, JsonMappingException, IOException, SQLException{
		ObjectMapper mapper = new ObjectMapper();
		Abastecimento abastecimento = mapper.readValue(body, Abastecimento.class);
		absSQL.novoAbastecimento(abastecimento);
		return ResponseEntity.ok("Novo abastecimento cadastrado com sucesso");
	}
}
