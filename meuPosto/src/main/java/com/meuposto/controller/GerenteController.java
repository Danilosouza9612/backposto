package com.meuposto.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meuposto.model.Gerente;
import com.meuposto.model.Login;
import com.meuposto.model.ProjecaoGerente;
import com.meuposto.repository.GerenteRepository;
import com.meuposto.repository.GerenteSQL;

@RestController
@CrossOrigin
@RequestMapping("/gerente")
public class GerenteController {
	@Autowired
	GerenteRepository gerenteRepository;
	GerenteSQL sql;
	
	public GerenteController() {
		this.sql = new GerenteSQL();
	}
	
	@GetMapping("/gerentes")
	public List<Gerente> getGerentes(){
		return gerenteRepository.findAll();
	}
	@PostMapping("/login")
	public String getPostoId(@RequestBody String loginJson) throws SQLException, JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		Login login = mapper.readValue(loginJson, Login.class);
		int postoId = this.sql.toLogin(login);
		String token;
		
		if(postoId==-1) {
			return "{ \"token\" : -1 }";
		}else {
			token = AuthControl.getInstance().getToken(login, postoId);
			return "{ \"token\" : \""+token+"\" }";
		}
	}
}
