package com.meuposto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.meuposto.model.Bomba;
import com.meuposto.model.ProjecaoBomba;
import com.meuposto.model.ProjecaoQuery08;
import com.meuposto.repository.BombaRepository;

@RestController
@CrossOrigin
@RequestMapping("/bomba")
public class BombaController {

	@Autowired
	BombaRepository bombaRepository;

	@GetMapping("/listar")
	public List<Bomba> listarBombas() {
		return bombaRepository.findAll();
	}

	@GetMapping("/query08")
	public List<ProjecaoQuery08> getBombaInferior100Litros(@RequestParam String token) {
		return bombaRepository.getBombaInferior100Litros(AuthControl.getInstance().getPostoId(token));
	}

	@GetMapping("/query06")
	public int getBombaInferior1000Litros(@RequestParam String token) {
		return bombaRepository.getBombaInferior1000Litros(AuthControl.getInstance().getPostoId(token));
	}
	
	@GetMapping("/bombas")
	public List<ProjecaoBomba> getBombas(@RequestParam String token){
		return bombaRepository.getBombas(AuthControl.getInstance().getPostoId(token));
	}

}
