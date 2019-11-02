package com.meuposto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.meuposto.model.Combustivel;
import com.meuposto.model.ProjecaoQuery10;
import com.meuposto.repository.CombustivelRepository;

@RestController
@CrossOrigin
@RequestMapping("/combustivel")
public class CombustivelController {

	@Autowired
	CombustivelRepository combustivelRepository;

	@GetMapping("/listar")
	public List<Combustivel> listarCombustiveis() {
		return combustivelRepository.findAll();
	}

	@GetMapping("/query10")
	public List<ProjecaoQuery10> getQtdAbastecimento(@RequestParam int id) {
		return combustivelRepository.getQtdAbastecimento(id);
	}

}
