package com.meuposto.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "GERENTE")
public class Gerente {

	@Id
	private int id;
	private String cpf;
	private String nome;
	private String telefone;
	private String senha;
	@OneToOne
	@JoinColumn(name = "POSTO_id")
	private Posto posto;

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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		if(cpf.matches("[0-9]{11}")) {
			throw new IllegalArgumentException("CPF Inválido");
		}
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		if(telefone.matches("[0-9]{11}")) {
			this.telefone = telefone;
		}else {
			throw new IllegalArgumentException("Telefone Inválido");
		}
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		if(senha.length()<6) {
			this.senha = senha;
		}
	}
	public Posto getPosto() {
		return posto;
	}
	public void setPosto(Posto posto) {
		this.posto = posto;
	}

}
