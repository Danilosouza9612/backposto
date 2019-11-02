package com.meuposto.model;

import java.io.IOException;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.meuposto.controller.DateDeserialize;

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

	@JsonCreator
	public Abastecimento(@JsonProperty("data") String data, @JsonProperty("qtdLitros") float litros,
			@JsonProperty("bombaId") int bombaId, @JsonProperty("cpf") String cpf, @JsonProperty("nome") String nome)
			throws IOException {
		this.data = DateDeserialize.deserialize(data);
		this.qtdLitros = litros;
		this.bomba = new Bomba();
		this.cliente = new Cliente();
		this.bomba.setId(bombaId);
		this.cliente.setCpf(cpf);
		this.cliente.setNome(nome);
	}

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
