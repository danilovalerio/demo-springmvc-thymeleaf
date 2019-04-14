package com.danilo.demomvc.domain;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(name = "ENDERECOS")
public class Endereco extends AbstractEntity<Long> {
	//Não utilizamos name porque será igual ao que consta na tabela
	@NotBlank
	@Size(max=255, min=3)
	@Column(nullable = false) 
	private String logradouro;
	
	@NotBlank
	@Size(max=255, min=3)
	@Column(nullable = false)
	private String bairro;
	
	@NotBlank
	@Size(max=255, min=3)
	@Column(nullable = false)
	private String cidade;
	
	//Será um ENUM que irá representar este objeto
	@NotNull(message = "{NotNull.endereco.uf}")
	@Column(nullable = false, length = 2)
	@Enumerated(EnumType.STRING) //Um ENUM que salva dados do tipo String no banco
	private UF uf;
	
	@NotBlank
	@Size(min=9, max=9)
	@Column(nullable = false, length = 9)
	private String cep;
	
	@NotNull(message = "{NotNull.endereco.numero}")
	@Digits(integer = 5, fraction=0)
	@Column(nullable = false, length = 5)
	private Integer numero;
	
	//por não ser obrigatório não precisa de anotação e adota
	//o tamanho de 255 caracteres por padrão do tipo String
	@Size(max=255)
	private String complemento;
	
	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public UF getUf() {
		return uf;
	}

	public void setUf(UF uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

}
