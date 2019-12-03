package com.meuposto.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meuposto.model.AbastecimentoBomba;
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
		context.saveAndFlush(abastecimentoBomba);
		return ResponseEntity.ok("Novo abastecimento bomba cadastrado com sucesso");
	}
	@RequestMapping(value = "/query13", 
					method=RequestMethod.GET,  
					produces = { MediaType.APPLICATION_JSON_VALUE })
	public String getAbastecimentosBomba(@RequestParam("id") String token,
																   @RequestParam("mes") int mes,
																   @RequestParam("ano") int ano) throws JsonProcessingException{
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(this.context.getAbastecimentosBomba(AuthControl.getInstance().getPostoId(token), mes, ano));
	}

}
