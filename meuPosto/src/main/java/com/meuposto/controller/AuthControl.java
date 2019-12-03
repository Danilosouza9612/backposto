package com.meuposto.controller;

import com.meuposto.model.Login;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class AuthControl {
	private String key;
	private static AuthControl instance;
	
	private AuthControl() {
		this.key = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9";
	}
	public static AuthControl getInstance() {
		if(instance==null) {
			instance = new AuthControl();
		}
		
		return instance;
	}
	public String getToken(Login login, int postoId) {
		return Jwts.builder()
                .signWith(SignatureAlgorithm.HS512, key)
                .setSubject(login.getCpf())
                .claim("PostoID", Integer.toString(postoId))
                .compact();
	}
	public int getPostoId(String token) {
		Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
		return Integer.parseInt(claims.get("PostoID").toString());
	}
}
