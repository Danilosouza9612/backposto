package com.meuposto.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "abastecimento")
public class Abastecimento {

	@Id
	private int id;
	private Date data;
	private float preco;
	private float qtdLitros;
	@ManyToOne
	@JoinColumn(name = "CLIENTE_id")
	private Cliente cliente;
	@ManyToOne
	@JoinColumn(name = "BOMBA_id")
	private Bomba bomba;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public float getQtdLitros() {
		return qtdLitros;
	}

	public void setQtdLitros(float qtdLitros) {
		this.qtdLitros = qtdLitros;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Bomba getBomba() {
		return bomba;
	}

	public void setBomba(Bomba bomba) {
		this.bomba = bomba;
	}

}
