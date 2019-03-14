package com.danilo.demomvc.domain;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Table(name = "ENDERECOS")
public class Endereco extends AbstractEntity<Long> {
	//Não utilizamos name porque será igual ao que consta na tabela
	@Column(nullable = false) 
	private String logradouro;
	
	@Column(nullable = false)
	private String bairro;
	
	@Column(nullable = false)
	private String cidade;
	
	//Será um ENUM que irá representar este objeto
	@Column(nullable = false, length = 2)
	@Enumerated(EnumType.STRING) //Um ENUM que salva dados do tipo String no banco
	private UF uf;
	
	@Column(nullable = false, length = 9)
	private String cep;
	
	@Column(nullable = false, length = 5)
	private Integer numero;
	
	//por não ser obrigatório não precisa de anotação e adota
	//o tamanho de 255 caracteres por padrão do tipo String
	private String complemento;

}
