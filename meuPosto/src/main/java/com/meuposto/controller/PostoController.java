package com.meuposto.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.meuposto.model.Posto;
import com.meuposto.model.ProjecaoQuery07;
import com.meuposto.repository.PostoRepository;

@RestController
@CrossOrigin
@RequestMapping("/posto")
public class PostoController {

	@Autowired
	PostoRepository postoRepository;
	
	@GetMapping("/listar")
	public List<Posto> listarPostos() {
		return postoRepository.findAll();
	}

	@GetMapping("/query09")
	public List<Double> getQtdAbastecimento(@RequestParam int id, @RequestParam int mes, @RequestParam int ano) {
		return postoRepository.getFaturamento(id,mes,ano);
	}
	
	@GetMapping("/query07")
	public List<ProjecaoQuery07> getAbastecimentosPosto(@RequestParam Date data, @RequestParam int id) {
		return postoRepository.getAbastecimentosPosto(data,id);
	}
	
}
