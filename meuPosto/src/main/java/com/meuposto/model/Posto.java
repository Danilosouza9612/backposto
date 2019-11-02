package com.meuposto.model;

import java.io.IOException;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "posto")
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

	@JsonCreator
	public Posto(@JsonProperty("cnpj") String cnpj, @JsonProperty("razao_social") String razaoSocial,
			@JsonProperty("nome_fantasia") String nomeFantasia, @JsonProperty("telefone") String telefone,
			@JsonProperty("cep") String cep, @JsonProperty("numero") String numero,
			@JsonProperty("complemento") String complemento, @JsonProperty("nome_gerente") String nomeGerente,
			@JsonProperty("cpf_gerente") String cpfGerente, @JsonProperty("telefone_gerente") String telefoneGerente,
			@JsonProperty("senha_gerente") String senhaGerente) throws IOException {

		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
		this.nomeFantasia = nomeFantasia;
		this.telefone = telefone;
		EnderecoPosto enderecoPosto = new EnderecoPosto();
		enderecoPosto.setCep(cep);
		enderecoPosto.setNumero(numero);
		enderecoPosto.setComplemento(complemento);
		Gerente gerente = new Gerente();
		gerente.setNome(nomeGerente);
		gerente.setCpf(cpfGerente);
		gerente.setTelefone(telefoneGerente);
		gerente.setSenha(senhaGerente);
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
		this.cnpj = cnpj;
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

}
