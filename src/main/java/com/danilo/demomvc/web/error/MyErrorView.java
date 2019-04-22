package com.danilo.demomvc.web.error;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

@Component  //Transforma a classe num Bean do Spring
public class MyErrorView implements ErrorViewResolver {

	//Método fornecido pela interface ErrorViewResolver
	@Override
	public ModelAndView resolveErrorView(HttpServletRequest request, HttpStatus status, Map<String, Object> map) {
		
		ModelAndView model = new ModelAndView("/error");
		model.addObject("status", status.value());
		//Se ocorrer novas mensagens de erros com outros status podem ser incluídos aqui no tratamento também
		switch (status.value()) {
				case 404:
					model.addObject("error", "Página não encontrada.");
					model.addObject("message", "A url para a página '" + map.get("path") + "' não existe.");
					break;
				case 500:
					model.addObject("error", "Ocorreu um erro interno no servidor.");
					model.addObject("message", "Ocorreu um erro inexperado, tente mais tarde.");
					break;
				default:
					model.addObject("error", map.get("error"));
					model.addObject("message", map.get("message"));
					break;
		}		
		return model;
	}

}
