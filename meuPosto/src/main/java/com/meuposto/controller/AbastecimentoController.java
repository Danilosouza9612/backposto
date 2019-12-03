package com.meuposto.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.TimeZone;

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
import com.meuposto.model.Abastecimento;
import com.meuposto.model.NoSQLQuery7;
import com.meuposto.model.ProjecaoQuery07;
import com.meuposto.repository.AbastecimentoNoSQL;
import com.meuposto.repository.AbastecimentoRepository;
import com.meuposto.repository.AbastecimentoSQL;
import com.observablepattern.Observable;
import com.observablepattern.Observer;

@RestController
@CrossOrigin
@RequestMapping("/abastecimento")
public class AbastecimentoController implements Observable {

	@Autowired
	AbastecimentoRepository abastecimentoRepository;
	private AbastecimentoSQL absSQL;
	private AbastecimentoNoSQL noSQL;
	private List<Observer> observers;

	public AbastecimentoController() {
		this.absSQL = new AbastecimentoSQL();
		this.noSQL = new AbastecimentoNoSQL();
		this.observers = new LinkedList<Observer>();
		this.observers.add(noSQL);
	}

	@PostMapping("/query05")
	public ResponseEntity<?> cadastrarAbastecimento(@RequestBody String body)
			throws JsonParseException, JsonMappingException, IOException, SQLException {
		ObjectMapper mapper = new ObjectMapper();
		Abastecimento abastecimento = mapper.readValue(body, Abastecimento.class);
		absSQL.novoAbastecimento(abastecimento);
		this.notificar();
		return ResponseEntity.ok("Novo abastecimento cadastrado com sucesso");
	}

	@GetMapping("/query07")
	public List<NoSQLQuery7> getAbastecimentosPosto(@RequestParam Date data, @RequestParam String token) throws JsonProcessingException {
		this.noSQL.setSQL(abastecimentoRepository);
		System.out.println(token);
		return noSQL.getResult(AuthControl.getInstance().getPostoId(token), data);
	}
	@Override
	public void notificar() {
		this.noSQL.setSQL(abastecimentoRepository);
		observers.forEach(observer->{observer.update(this);});
	}
}
