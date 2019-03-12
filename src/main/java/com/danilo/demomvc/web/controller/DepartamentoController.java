package com.danilo.demomvc.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/departamentos")
public class DepartamentoController {
	
	@GetMapping("/cadastrar")
	public String cadastrar() {
		System.out.println("Feita requisição do cadastrar...");
		return "/departamento/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar() {
		System.out.println("Feita requisição do listar...");
		return "/departamento/lista";
	}
	
	

}
