package com.meuposto.model;

import java.io.IOException;
import java.sql.Timestamp;
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
public class AbastecimentoBomba extends AbastecimentoAbstrato {
	@ManyToOne
	@JoinColumn(name = "BANDEIRA_id")
	private Bandeira bandeira;

	@JsonCreator
	public AbastecimentoBomba(@JsonProperty("bandeiraId") int bandeiraId, 
							  @JsonProperty("bombaId") int bombaId,
							  @JsonProperty("data") String data, 
							  @JsonProperty("qtdLitros") float qtdLitros,
							  @JsonProperty("preco") float preco) throws IOException {
		super(new Timestamp(DateDeserialize.deserializeWithoutTime(data).getTime()), preco, qtdLitros, new Bomba());
		this.bandeira = new Bandeira();
		this.bandeira.setId(bandeiraId);
		this.getBomba().setId(bombaId);
	}

	public Bandeira getBandeira() {
		return bandeira;
	}

	public void setBandeira(Bandeira bandeira) {
		this.bandeira = bandeira;
	}

}
