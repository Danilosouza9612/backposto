package com.meuposto.model;

import java.io.IOException;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.meuposto.controller.DateDeserialize;

@Entity
@Table(name = "ABASTECIMENTO_BOMBA")
public class AbastecimentoBomba {

	@Id
	private int id;
	@ManyToOne
	@JoinColumn(name = "BANDEIRA_id")
	private Bandeira bandeira;
	@ManyToOne
	@JoinColumn(name = "BOMBA_id")
	private Bomba bomba;
	private Date data;
	private float qtdLitros;
	private float preco;

	@JsonCreator
	public AbastecimentoBomba(@JsonProperty("bandeiraId") int bandeiraId, 
							  @JsonProperty("bombaId") int bombaId,
							  @JsonProperty("data") String data, 
							  @JsonProperty("qtdLitros") float qtdLitros,
							  @JsonProperty("preco") float preco) throws IOException {
		this.bandeira = new Bandeira();
		this.bandeira.setId(bandeiraId);
		this.bomba = new Bomba();
		this.bomba.setId(bombaId);
		this.data = DateDeserialize.deserializeWithoutTime(data);
		this.qtdLitros = qtdLitros;
		this.preco = preco;
	}

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
