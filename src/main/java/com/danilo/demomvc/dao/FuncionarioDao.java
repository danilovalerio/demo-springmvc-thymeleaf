package com.danilo.demomvc.dao;

import java.util.List;

import com.danilo.demomvc.domain.Funcionario;

public interface FuncionarioDao {
	
	void save(Funcionario funcionario);
	
	void update(Funcionario funcionario);
	
	void delete(Long id);
	
	List<Funcionario> findAll();

}
