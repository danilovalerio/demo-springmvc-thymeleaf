package com.danilo.demomvc.service;

import java.util.List;

import com.danilo.demomvc.domain.Departamento;

public interface DepartamentoService {
	
	 void salvar(Departamento departamento);

	 void editar(Departamento departamento);

	 void excluir(Long id);

	 Departamento buscarPorId(Long id);
	    
	 List<Departamento> buscarTodos();

	 //Verifica de tem algum cargo nesse departamento id
	 boolean departamentoTemCargos(Long id);

}
