package com.danilo.demomvc.web.conversor;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

//Converter recebe dois parâmetros 
//<TIPO que está vindo do formulário (String), TIPO que queremos armazenar (Integer) >
@Component 
public class StringToInteger implements Converter <String, Integer> {

	@Override
	public Integer convert(String txt) {
		txt = txt.trim(); //para remover espaços em branco

		//verifica se possui somente digito com expressão regular regex
		if(txt.matches("[0-9]+")){ //[só pode digitos de 0 a 9]+ significa que podemos ter várias aparições de 0 até 9 
			return Integer.valueOf(txt);
		}
		
		return null;
	}

}
