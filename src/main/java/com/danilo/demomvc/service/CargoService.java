package com.danilo.demomvc.service;

import java.util.List;

import com.danilo.demomvc.domain.Cargo;

public interface CargoService {
	
	void salvar(Cargo cargo);
	
	void editar(Cargo cargo);
	
	void excluir(Long id); //fará a exclusão através do Id
	
	Cargo buscarPorId(Long id);
	
	List<Cargo> buscarTodos();

}
