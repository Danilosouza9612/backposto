package com.meuposto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meuposto.model.Gerente;
import com.meuposto.model.ProjecaoGerente;
import com.meuposto.repository.GerenteRepository;

@RestController
@CrossOrigin
@RequestMapping("/gerente")
public class GerenteController {
	@Autowired
	GerenteRepository gerenteRepository;
	
	@GetMapping("/gerentes")
	public List<Gerente> getGerentes(){
		return gerenteRepository.findAll();
	}
}
