package com.meuposto.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BOMBA")
public class Bomba {

	@Id
	private int id;
	@ManyToOne
	@JoinColumn(name = "POSTO_id")
	private Posto posto;
	@ManyToOne
	@JoinColumn(name = "COMBUSTIVEL_id")
	private Combustivel combustivel;
	private float preco;
	private float qtdRestante;

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

	public Combustivel getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(Combustivel combustivel) {
		this.combustivel = combustivel;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		if(preco>0) {
			this.preco = preco;
		}else {
			throw new IllegalArgumentException("Preço Inválido");
		}
	}

	public float getQtdRestante() {
		return qtdRestante;
	}

	public void setQtdRestante(float qtdRestante) {
		if(qtdRestante>0)
			this.qtdRestante = qtdRestante;
		else
			throw new IllegalArgumentException("Quantidade de litros inválida");
	}

}
