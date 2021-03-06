package com.danilo.demomvc.domain;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

//O nosso ID será do tipo long
@Entity
@Table(name = "DEPARTAMENTOS")
public class Departamento extends AbstractEntity<Long> {
	@NotBlank(message = "Informe um nome.")
	@Size(min = 3, max = 60, message = "O nome do departamento deve ter entre {min} e {max} caracteres.")
	//Coluna de nome nome, não pode ser nula, é unica, e tamanho max de 60 caracteres
	@Column(name = "nome", nullable = false, unique = true, length = 60)
	private String nome;
	
	//muitos cargos para um departamento
	@OneToMany(mappedBy = "departamento") //departamento é o lado fraco,visto que a FK está em cargo
	private List<Cargo> cargos;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Cargo> getCargos() {
		return cargos;
	}

	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}
	
	
	

}
