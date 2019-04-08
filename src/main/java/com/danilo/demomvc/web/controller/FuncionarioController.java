package com.danilo.demomvc.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.danilo.demomvc.domain.Cargo;
import com.danilo.demomvc.domain.Funcionario;
import com.danilo.demomvc.service.CargoService;
import com.danilo.demomvc.service.FuncionarioService;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {
	@Autowired
	private FuncionarioService funcionarioService;
	
	@Autowired
	private CargoService cargoService;
	
	
	@GetMapping("/cadastrar")
	public String cadastrar(Funcionario funcionario) {
		return "/funcionario/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar() {
		return "/funcionario/lista";
	}
	
	
	//Realiza o cadastro do funcionário
	@PostMapping("/salvar")
	public String salvar(Funcionario funcionario, RedirectAttributes attr) {
		funcionarioService.salvar(funcionario);
		attr.addFlashAttribute("success", "Funcionário cadastrado com sucesso!");
		return "redirect:/funcionarios/cadastrar"; //após salvar redireciona para cadastro
	}
	
	//Exibe lista de cargos no combobox
	@ModelAttribute("cargos")
	public List<Cargo> listaDeCargos(){
		return cargoService.buscarTodos();
	}

}
