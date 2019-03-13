package com.danilo.demomvc.domain;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.Id;

/*
 * Classe abstrata responsável por auxiliar na criação das demais entidades
 * como teremos métodos similares para boa parte das entidades iremos
 * criar uma classe com esses métodos para servir de Herança para nossas entidades 
 *  
 */

@SuppressWarnings("serial") //O próprio JDK ira gerar o serial para nós então 'desativamos' os avisos
@MappedSuperclass //anotação para informar ao JPA que essa é nossa super classe das entidades
public abstract class AbstractEntity <ID extends Serializable> implements Serializable {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private ID id;

	public ID getId() {
		return id;
	}

	public void setId(ID id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractEntity<?> other = (AbstractEntity<?>) obj; //adicionado tipo genérico
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "[id=" + id + "]";
	}
	
	
	
	

}
