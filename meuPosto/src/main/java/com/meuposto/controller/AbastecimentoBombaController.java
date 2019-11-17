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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meuposto.model.AbastecimentoBomba;
import com.meuposto.model.ProjecaoAbastecimentoBomba;
import com.meuposto.repository.AbastecimentoBombaRepository;
import com.meuposto.repository.AbastecimentoBombaSQL;

@RestController
@CrossOrigin
@RequestMapping("/abastecimento_bomba")
public class AbastecimentoBombaController {

	@Autowired
	private AbastecimentoBombaRepository context;
	private AbastecimentoBombaSQL absBombaSQL;

	public AbastecimentoBombaController() {
		this.absBombaSQL = new AbastecimentoBombaSQL();
	}

	@PostMapping("/query03")
	public ResponseEntity<?> cadastrarAbastecimentoBomba(@RequestBody String body)
			throws JsonParseException, JsonMappingException, IOException, SQLException {
		ObjectMapper mapper = new ObjectMapper();
		AbastecimentoBomba abastecimentoBomba = mapper.readValue(body, AbastecimentoBomba.class);
		absBombaSQL.novoAbastecimentoBomba(abastecimentoBomba);
		return ResponseEntity.ok("Novo abastecimento bomba cadastrado com sucesso");
	}
	@GetMapping("/query13")
	public List<ProjecaoAbastecimentoBomba> getAbastecimentosBomba(@RequestParam("id") int id,
																   @RequestParam("mes") int mes,
																   @RequestParam("ano") int ano){
		return this.context.getAbastecimentosBomba(id, mes, ano);
	}

}
