package com.meuposto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meuposto.repository.BandeiraRepository;
import com.meuposto.model.Bandeira;

@RestController
@CrossOrigin
@RequestMapping("/bandeira")
public class BandeiraController {
	@Autowired
	BandeiraRepository bandeiraRepository;
	
	@GetMapping("/bandeiras")
	public List<Bandeira> getBandeiras(){
		return bandeiraRepository.getBandeiras();
	}

}
