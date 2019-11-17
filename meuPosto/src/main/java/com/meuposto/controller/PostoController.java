package com.meuposto.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meuposto.model.Posto;
import com.meuposto.model.ProjecaoQuery07;
import com.meuposto.model.ProjecaoQuery9;
import com.meuposto.repository.AbastecimentoNoSQL;
import com.meuposto.repository.PostoRepository;
import com.meuposto.repository.PostoSQL;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

@RestController
@CrossOrigin
@RequestMapping("/posto")
public class PostoController {

	private PostoSQL postoSQL;
	private AbastecimentoNoSQL noSQL;
	@Autowired
	PostoRepository postoRepository;

	public PostoController() {
		this.postoSQL = new PostoSQL();
		this.noSQL = new AbastecimentoNoSQL();
	}
	
	@GetMapping("/listar")
	public List<Posto> listarPostos() {
		return postoRepository.findAll();
	}

	@GetMapping("/query09")
	public List<ProjecaoQuery9> getQtdAbastecimento(@RequestParam int mes, @RequestParam int ano) {
		return postoRepository.getFaturamento(mes, ano);
	}
	@PostMapping("/query12")
	public ResponseEntity<?> cadastrarPosto(@RequestBody String body)
			throws JsonParseException, JsonMappingException, IOException, SQLException {
		ObjectMapper mapper = new ObjectMapper();
		Posto posto = mapper.readValue(body, Posto.class);
		postoSQL.novoPosto(posto);
		return ResponseEntity.ok("Novo posto cadastrado com sucesso");
	}
}
