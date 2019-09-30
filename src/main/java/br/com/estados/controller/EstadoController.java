package br.com.estados.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.estados.model.Estado;
import br.com.estados.services.EstadoService;

@Controller
public class EstadoController {
	
	@Autowired
	private EstadoService estadoService;

	@RequestMapping(value = "/todos/list", method = RequestMethod.GET)
	public String listar(Model model) {
		List<Estado> estados= estadoService.listar();
		model.addAttribute("listaEstados", estados);
		return "todos/list";
	}
	
	@RequestMapping(value = "/todos/form" , method = RequestMethod.GET)
	public String viewForm(Model model) {
		return "todos/form";
	}
	
	
	@RequestMapping(value = "/todos/add", method = RequestMethod.POST)
	public String save(Model model, Estado estado) {
		estadoService.salvar(estado);
		return "redirect:/todos/list";
	}
	
	@RequestMapping(value = "/todos/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable("id") Integer id, Model model) {
		Estado estado = estadoService.pesquisar(id);
		model.addAttribute("estado", estado);
		return "todos/edit";
	}
	
	@RequestMapping(value = "/todos/update", method = RequestMethod.POST)
	public String update(Model model, Estado estado) {
		estadoService.atualizar(estado);
		return "redirect:/todos/list";
	}
}
