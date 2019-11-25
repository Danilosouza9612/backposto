package com.meuposto.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS )
public abstract class AbastecimentoAbstrato {
	@Id
	private int id;
	@Column(name = "data")
	private Timestamp data;
	@Column(name = "preco")
	private float preco;
	@Column(name = "qtd_Litros")
	private float qtdLitros;
	@ManyToOne
	@JoinColumn(name = "BOMBA_id")
	private Bomba bomba;
	
	public AbastecimentoAbstrato(Timestamp data, float preco, float qtdLitros, Bomba bomba) {
		this.data = data;
		this.preco = preco;
		this.qtdLitros = qtdLitros;
		this.bomba = bomba;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Timestamp getData() {
		return data;
	}
	public void setData(Timestamp data) {
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
	public Bomba getBomba() {
		return bomba;
	}
	public void setBomba(Bomba bomba) {
		this.bomba = bomba;
	}
}
