package com.meuposto.model;

import java.io.IOException;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.meuposto.controller.DateDeserialize;

@Entity
@Table(name = "ABASTECIMENTO")
public class Abastecimento extends AbastecimentoAbstrato {
	
	@ManyToOne
	@JoinColumn(name = "CLIENTE_id")
	private Pessoa cliente;

	@JsonCreator
	public Abastecimento(@JsonProperty("data") String data, 
						 @JsonProperty("hora") String hora,
						 @JsonProperty("qtdLitros") float litros,
						 @JsonProperty("bombaId") int bombaId, 
						 @JsonProperty("cpf") String cpf, 
						 @JsonProperty("nome") String nome)
			throws IOException {
		super(DateDeserialize.deserialize(data + " "+hora), 0, litros, new Bomba());
		this.getBomba().setId(bombaId);
		if(cpf!=null && !cpf.trim().isEmpty()) {
			this.cliente = new Pessoa();
			this.cliente.setCpf(cpf);
			this.cliente.setNome(nome);
		}
	}
	public Pessoa getCliente() {
		return cliente;
	}

	public void setCliente(Pessoa cliente) {
		this.cliente = cliente;
	}
}
