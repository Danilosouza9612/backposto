package com.meuposto.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "FRENTISTA")
public class Frentista {
	@Id
	private int id;
	@JoinColumn(name = "nome")
	private String nome;
	@JoinColumn(name = "telefone")
	private String telefone;
	@JoinColumn(name = "salario")
	private float salario;
	@ManyToOne
	@JoinColumn(name = "POSTO_id")
	private Posto posto;
	
	public Frentista() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}
	@JsonIgnore
	public Posto getPosto() {
		return posto;
	}
	public void setPosto(Posto posto) {
		this.posto = posto;
	}
}
