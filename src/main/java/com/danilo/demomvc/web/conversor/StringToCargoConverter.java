package com.danilo.demomvc.web.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.danilo.demomvc.domain.Cargo;
import com.danilo.demomvc.service.CargoService;

//Faz a conversão de String para Objeto Cargo
		//passamos 2 tipos genéricos, um é o tipo String que estamos recebendo lá da página cadastro
		//o segundo é o tipo de objeto que iremos retornar para o controller no caso o Cargo 
@Component //notação para gerenciar a injeção do service
public class StringToCargoConverter implements Converter <String, Cargo>{ //implementa a Converter padrão do spring para uso
	
	@Autowired
	private CargoService service; //Paga consulta do cargo que retornaremos para controller

	@Override
	public Cargo convert(String text) {
		if(text.isEmpty()) { //trata se é nulo, para evitar nullpointer
			return null;
		}
		
		Long id = Long.valueOf(text);//converte o id de texto para long
		return service.buscarPorId(id); //busca o cargo por id
	} 

}
