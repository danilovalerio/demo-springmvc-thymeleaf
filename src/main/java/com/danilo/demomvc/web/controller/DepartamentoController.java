package com.danilo.demomvc.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.danilo.demomvc.domain.Departamento;
import com.danilo.demomvc.service.DepartamentoService;

@Controller
@RequestMapping("/departamentos")
public class DepartamentoController {
	
	@Autowired
	private DepartamentoService service; //para termos acesso aos métodos do service
	
	@GetMapping("/cadastrar")
	public String cadastrar(Departamento departamento) {
		return "/departamento/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		//1 parâmetro é o nome da variável que esperamos na página, 2 é a lista através do buscar todos que está no service linha 18 jão
		model.addAttribute("departamentos", service.buscarTodos());
		return "/departamento/lista";
	}
	
	//Método para cadastrar os dados que vem do formulário através do submit
	@PostMapping("/salvar")
	public String salvar(@Valid Departamento departamento,  BindingResult result, RedirectAttributes attr) { //@Valid informa ao SpringMVC  que estamos fazendo a validação via Bean Validation do objeto Departamento
		if(result.hasErrors()) {
			return "/departamento/cadastro";
		}
		
		service.salvar(departamento);
		attr.addFlashAttribute("success", "Departamento salvo com sucesso.");
		return "redirect:/departamentos/cadastrar"; //após salvar redireciona para o cadastrar dep.
		
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("departamento", service.buscarPorId(id));
		return "/departamento/cadastro";
		
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Departamento departamento, BindingResult result, RedirectAttributes attr) { //por ter uma ação de redirect adicionamos o attr
		if(result.hasErrors()) {
			return "/departamento/cadastro";
		}
				
		service.editar(departamento);
		attr.addFlashAttribute("success", "Departamento editado com sucesso.");
		return "redirect:/departamentos/cadastrar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		if(service.departamentoTemCargos(id)) {
			model.addAttribute("fail", "Departamento não removido, Possui cargo(s) vinculado(s).");
		} else {
			service.excluir(id);
			model.addAttribute("success", "Departamento excluido com sucesso.");
		}
		
		//retorna uma lista para lista.html
		return listar(model);
	}
	
	
	
	
	
	
	

}
