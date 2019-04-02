package com.danilo.demomvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.danilo.demomvc.dao.CargoDao;
import com.danilo.demomvc.domain.Cargo;

@Service //Para ser um Bean gerenciado pelo Spring
@Transactional(readOnly = false) //valor padrão é false
public class CargoServiceImpl implements CargoService {
	
	//Para fazer uso dos dao's nas dependencias
	@Autowired
	private CargoDao dao;

	@Override
	public void salvar(Cargo cargo) {
		dao.save(cargo);
	}

	@Override
	public void editar(Cargo cargo) {
		dao.update(cargo);
		
	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);
		
	}

	@Override @Transactional(readOnly = true) //por ser somente de leitura não abre transação com o banco
	public Cargo buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override @Transactional(readOnly = true)
	public List<Cargo> buscarTodos() {
		return dao.findAll();
	}
	
	//Busca funcionário por id retorno true ou false
	@Override
	public boolean cargoTemFuncionarios(Long id) {
		if(buscarPorId(id).getFuncionarios().isEmpty()) {
			return false;
		}
		return true;
	}

}
