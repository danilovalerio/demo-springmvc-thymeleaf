package com.danilo.demomvc.domain;

import java.util.List;

import javax.persistence.*;


@SuppressWarnings("serial") 
@Entity
@Table(name = "CARGOS")
public class Cargo extends AbstractEntity<Long> {
	
	@Column(name = "nome", nullable = false, unique = true, length = 60)
	private String nome;
	
	@ManyToOne //One departamento para Many (muitos) cargos (Nome da classe)
	@JoinColumn(name = "id_departamento_fk") //chave estrangeira que estará na tabela cargos
	private Departamento departamento;
	
	//Um mesmo cargo para muitos funcionários e cargo é o lado fraco 
	@OneToMany(mappedBy = "cargo") 
	private List<Funcionario> funcionarios;
	
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionario(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	
	
	

}
