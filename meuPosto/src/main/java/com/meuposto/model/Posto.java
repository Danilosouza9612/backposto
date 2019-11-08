package com.meuposto.model;

import java.io.IOException;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "POSTO")
public class Posto {

	@Id
	private int id;
	private String cnpj;
	private String razaoSocial;
	private String nomeFantasia;
	private String telefone;
	@ManyToOne
	@JoinColumn(name = "BANDEIRA_id")
	private Bandeira bandeira;
	@OneToOne
	@JoinColumn(name = "GERENTE_id")
	private Gerente gerente;
	@OneToOne(mappedBy="posto")
	private EnderecoPosto endereco;

	@JsonCreator
	public Posto(@JsonProperty("cnpj") String cnpj, 
				 @JsonProperty("razaoSocial") String razaoSocial,
				 @JsonProperty("nomeFantasia") String nomeFantasia, 
				 @JsonProperty("telefone") String telefone,
				 @JsonProperty("gerenteCpf") String gerenteCpf,
				 @JsonProperty("bandeiraId") Integer bandeiraId,
				 @JsonProperty("cep") String cep, 
				 @JsonProperty("numero") String numero,
				 @JsonProperty("complemento") String complemento) throws IOException {

		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
		this.telefone = telefone;
		this.endereco = new EnderecoPosto();
		endereco.setCep(cep);
		endereco.setNumero(numero);
		endereco.setComplemento(complemento);
		this.gerente = new Gerente();
		gerente.setCpf(gerenteCpf);
		if(bandeiraId!=null) {
			this.bandeira = new Bandeira();
			bandeira.setId(bandeiraId);
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		if(cnpj.matches("[0-9]{14}")) {
			this.cnpj = cnpj;
		}else {
			throw new IllegalArgumentException("CNPJ Inválido");
		}
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Bandeira getBandeira() {
		return bandeira;
	}

	public void setBandeira(Bandeira bandeira) {
		this.bandeira = bandeira;
	}

	public Gerente getGerente() {
		return gerente;
	}

	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}

	public EnderecoPosto getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoPosto endereco) {
		this.endereco = endereco;
	}
	
}
