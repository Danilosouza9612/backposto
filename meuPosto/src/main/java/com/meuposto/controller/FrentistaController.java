package com.meuposto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meuposto.model.Frentista;
import com.meuposto.repository.FrentistaRepository;

@RestController
@CrossOrigin
@RequestMapping("/frentista")
public class FrentistaController {

	@Autowired
	FrentistaRepository context;
	
	@GetMapping("/frentistas")
	public List<Frentista> getFrentistas(String token){
		return this.context.getFrentistas(AuthControl.getInstance().getPostoId(token));
	}
}
