package com.meuposto.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties("_id")
public class NoSQLQuery7{
	
	private int idPosto;
	private Date data;
	private String nomeCliente;
	private String cpf;
	private String nome;
	private float qtdLitros;
	private float preco;
	private String frentista;
	
	@JsonCreator
	public NoSQLQuery7(@JsonProperty("idPosto") int idPosto,
					   @JsonProperty("data") Map<String, Long> data,
					   @JsonProperty("nomeCliente") String nomeCliente,
					   @JsonProperty("cpf") String cpf,
					   @JsonProperty("nome") String nome,
					   @JsonProperty("qtdLitros") float qtdLitros,
					   @JsonProperty("preco") float preco,
					   @JsonProperty("frentista") String frentista) {
		this.data= Calendar.getInstance().getTime();
		this.data.setTime(data.get("$numberLong")+10800000);
		this.nomeCliente=nomeCliente;
		this.cpf=cpf;
		this.nome=nome;
		this.qtdLitros=qtdLitros;
		this.preco=preco;
		this.frentista=frentista;
	}
	

	public int getIdPosto() {
		return idPosto;
	}
	
	public String getData() {
		// TODO Auto-generated method stub
		SimpleDateFormat format = new SimpleDateFormat("HH:mm");
		return format.format(data);
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
	public String getFrentista() {
		return frentista;
	}

}
