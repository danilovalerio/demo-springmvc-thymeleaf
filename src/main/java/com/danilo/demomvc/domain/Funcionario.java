package com.danilo.demomvc.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.*;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.format.annotation.NumberFormat.Style;

@SuppressWarnings("serial")
@Entity
@Table(name = "FUNCIONARIOS")
public class Funcionario extends AbstractEntity<Long> {
	
	@Column(nullable = false, unique = true)
	private String nome;
	
	//Definido um valor de 7 digitos com 2 casas decimais e ao invés de nulo
	//por padrão receberá 0.00
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00") //CURRENCY é tipo moeda e padrão americano para salvar no banco
	@Column(nullable = false, columnDefinition = "DECIMAL(7,2) DEFAULT 0.00")
	private BigDecimal salario;
	
	//Formatação oferecida pelo Spring que são 3 tipos 
	//(DATE> Só para data DATE_TIME > data e hora ou TIME> Que é só para a hora
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "data_entrada", nullable = false, columnDefinition = "DATE")
	private LocalDate dataEntrada;
	
	@DateTimeFormat(iso = ISO.DATE)
	//removido nullable, que por padrão é true, não obrigando valor para data de saída
	@Column(name = "data_saida", columnDefinition = "DATE")
	private LocalDate dataSaida;
	
	//Um endereco para cada func, e cascade All por que toda vez que for
	//inserir um funcionário tem que inserir um endereço e se
	//editarmos o endereço no funcionário também editatará por padrão
	//quando excluir um funcionário também excluirá o endereço da base
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco_id_fk")
	private Endereco endereco;
	
	//Muitos funcionário para um cargo
	@ManyToOne
	@JoinColumn(name = "cargo_id_fk")
	private Cargo cargo;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public LocalDate getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(LocalDate dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public LocalDate getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(LocalDate dataSaida) {
		this.dataSaida = dataSaida;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	
	

}
