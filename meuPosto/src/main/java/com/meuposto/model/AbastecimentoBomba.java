package com.meuposto.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "abastecimento_bomba")
public class AbastecimentoBomba {

	@Id
	private int id;
	@ManyToOne
	@JoinColumn(name="BANDEIRA_id")
	private Bandeira bandeira;
	@ManyToOne
	@JoinColumn(name="BOMBA_id")
	private Bomba bomba;
	private Date data;
	private float qtdLitros;
	private float preco;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Bandeira getBandeira() {
		return bandeira;
	}
	public void setBandeira(Bandeira bandeira) {
		this.bandeira = bandeira;
	}
	public Bomba getBomba() {
		return bomba;
	}
	public void setBomba(Bomba bomba) {
		this.bomba = bomba;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public float getQtdLitros() {
		return qtdLitros;
	}
	public void setQtdLitros(float qtdLitros) {
		this.qtdLitros = qtdLitros;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	
}
