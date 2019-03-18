package com.danilo.demomvc.dao;

import java.util.List;

public interface Cargo {
	
	void save(Cargo cargo);
	
	void update(Cargo cargo);
	
	void delete(Long id);
	
	List<Cargo> findAll();


}
