package com.danilo.demomvc.web.validator;

import java.time.LocalDate;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.danilo.demomvc.domain.Funcionario;

//Classe com validação avançada usando o Spring Validator
public class FuncionarioValidator implements Validator{
	
	//Método supports 
	//Avalia se a classe que estou recebendo é igual a classe que queremos testar
	//Se for vai lá para o validate
	@Override
	public boolean supports(Class<?> clazz) { 
		//retorna se clazz que é o objeto funcionarios que vem do formulário é da classe funcionário
		return Funcionario.class.equals(clazz);
	}

	//Validate recebe dois parâmetros um é o objeto que estamos recebendo, funcionário no caso
	// e Errors é o objeto que vamos lhe dar com a validação
	@Override
	public void validate(Object object, Errors errors) {
		
		Funcionario f = (Funcionario) object; //Cast que transforma object em funcionário
		
		LocalDate entrada = f.getDataEntrada(); //pega data de entrada do objeto f
		
		if (f.getDataSaida() != null) {//como não é obrigatório só é testado quando não é nulo
			//Se a data de saída for anterior a data de entrada
			if (f.getDataSaida().isBefore(entrada)) {
				//método do validate que recebe dois valores
				//1º nome do campo que estamos validando 2º a msg de validação
				errors.rejectValue("dataSaida", "PosteriorDataEntrada.funcionario.dataSaida");//esta no arquivo messages.properties
			}
		}
	}

}
