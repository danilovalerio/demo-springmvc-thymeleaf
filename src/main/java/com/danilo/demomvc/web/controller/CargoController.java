package com.danilo.demomvc.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.danilo.demomvc.domain.Cargo;
import com.danilo.demomvc.domain.Departamento;
import com.danilo.demomvc.service.CargoService;
import com.danilo.demomvc.service.DepartamentoService;

@Controller
@RequestMapping("/cargos")
public class CargoController {
	
	@Autowired
	private CargoService cargoService; //para acessar métodos do service
	@Autowired
	private DepartamentoService departamentoService;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Cargo cargo) {
		return "cargo/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {//ModelMap model adicionado para listar no html
		//adicionamos todos os cargos na 'variável' cargos e passamos para o front
		model.addAttribute("cargos", cargoService.buscarTodos());
		return "cargo/lista";
	}
	
	//Realiza o cadastro do cargo
	@PostMapping("/salvar")
	public String salvar(@Valid Cargo cargo, BindingResult result, RedirectAttributes attr) { //@Valid informa ao SpringMVC  que estamos fazendo a validação via Bean Validation do objeto cargo
		//Objeto BindingResult é um objeto do SpringMVC e avalia se teve algum problema com as validações
		if(result.hasErrors()) { //se algum campo não passou na validação já retorna o erro
			return "cargo/cadastro";
		}
		
		cargoService.salvar(cargo);
		attr.addFlashAttribute("success", "Cargo inserido com sucesso.");
		return "redirect:/cargos/cadastrar";//após salvamento redireciona para o acadastro
	}
	
	//Exibe a lista de departamentos no combobox para selecionar ao cadastrar cargo
	@ModelAttribute("departamentos")
	public List<Departamento> listaDeDepartamentos(){
		return departamentoService.buscarTodos();
	}
	
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) { //ModelMap utilizado para enviar os dados lá para tela de cadastro
		model.addAttribute("cargo", cargoService.buscarPorId(id));
		return "cargo/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Cargo cargo,  BindingResult result, RedirectAttributes attr) { //@Valid informa ao SpringMVC  que estamos fazendo a validação via Bean Validation do objeto cargo
		//Objeto BindingResult é um objeto do SpringMVC e avalia se teve algum problema com as validações
		if(result.hasErrors()) {
			return "cargo/cadastro";
		}
		
		cargoService.editar(cargo);
		//envia para a página a mensagem de sucesso no caso do registro com sucesso 
		attr.addFlashAttribute("success", "Registro atualizado com sucesso.");
		return "redirect:/cargos/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		if(cargoService.cargoTemFuncionarios(id)) { //antes da exclusão verifica se o cargo possui funcionários
			attr.addFlashAttribute("fail", "Cargo não pode ser excluido, pois tem funcionário(s) vinculado(s).");
		} else {
			cargoService.excluir(id);
			attr.addFlashAttribute("success", "Cargo excluido com sucesso.");
		}

		//redireciona para a lista de cargos
		return "redirect:/cargos/listar";
	}
	

}
