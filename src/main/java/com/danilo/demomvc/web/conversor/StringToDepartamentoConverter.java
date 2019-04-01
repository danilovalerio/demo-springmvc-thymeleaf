package com.danilo.demomvc.web.conversor;

import org.springframework.beans.factory.annotation.Autowired;
//Spring já fornece uma classe que realizar a conversão, sendo necessário
//		somente implementá-la
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.danilo.demomvc.domain.Departamento;
import com.danilo.demomvc.service.DepartamentoService;


//Faz a conversão de String para Objeto Departamento
		//passamos 2 tipos genéricos, um é o string que estamos recebendo lá da página
		//o segundo é o tipo de objeto que iremos retornar para o controller 
@Component //para gerenciar a injeção do nosso service
public class StringToDepartamentoConverter implements Converter<String, Departamento>{
	//para poder consultar o departamento que queremos retornar para o controller
	//injetamos o DepartamentoService
	@Autowired 
	private DepartamentoService service;

	@Override
	public Departamento convert(String text) {
		//para evitar excessão durante a conversão
		if(text.isEmpty()) {
			return null;
		}
		
		Long id = Long.valueOf(text);
		return service.buscarPorId(id);//busca o departamento por Id
	}
	
	

}
