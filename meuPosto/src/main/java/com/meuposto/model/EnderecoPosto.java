package com.meuposto.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ENDERECO_POSTO")
public class EnderecoPosto {

	@Id
	private int id;
	@MapsId
	@OneToOne
	@JoinColumn(name = "POSTO_id")
	private Posto posto;
	private String cep;
	private String numero;
	private String complemento;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Posto getPosto() {
		return posto;
	}

	public void setPosto(Posto posto) {
		this.posto = posto;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

}
