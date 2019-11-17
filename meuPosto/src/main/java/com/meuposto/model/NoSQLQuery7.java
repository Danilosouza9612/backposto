package com.meuposto.model;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties("_id")
public class NoSQLQuery7 implements ProjecaoQuery07{
	
	private int idPosto;
	private Date data;
	private String nomeCliente;
	private String cpf;
	private String nome;
	private float qtdLitros;
	private float preco;
	
	@JsonCreator
	public NoSQLQuery7(@JsonProperty("idPosto") int idPosto,
					   @JsonProperty("data") Map<String, Long> data,
					   @JsonProperty("nomeCliente") String nomeCliente,
					   @JsonProperty("cpf") String cpf,
					   @JsonProperty("nome") String nome,
					   @JsonProperty("qtdLitros") float qtdLitros,
					   @JsonProperty("preco") float preco) {
		this.data= Calendar.getInstance().getTime();
		this.data.setTime(data.get("$numberLong"));
		this.nomeCliente=nomeCliente;
		this.cpf=cpf;
		this.nome=nome;
		this.qtdLitros=qtdLitros;
		this.preco=preco;
	}
	

	public int getIdPosto() {
		return idPosto;
	}
	
	public Date getData() {
		// TODO Auto-generated method stub
		return data;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public String getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public float getQtdLitros() {
		return qtdLitros;
	}

	public float getPreco() {
		return preco;
	}
}
