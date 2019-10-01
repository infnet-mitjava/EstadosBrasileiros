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

	@RequestMapping(value = "/estados/list", method = RequestMethod.GET)
	public String listar(Model model) {
		List<Estado> estados= estadoService.listar();
		model.addAttribute("listaEstados", estados);
		return "estados/list";
	}
	
	@RequestMapping(value = "/estados/form" , method = RequestMethod.GET)
	public String viewForm(Model model) {
		return "estados/form";
	}
	
	
	@RequestMapping(value = "/estados/add", method = RequestMethod.POST)
	public String save(Model model, Estado estado) {
		estadoService.salvar(estado);
		return "redirect:/estados/list";
	}
	
	@RequestMapping(value = "/estados/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable("id") Integer id, Model model) {
		Estado estado = estadoService.pesquisar(id);
		model.addAttribute("estado", estado);
		return "estados/edit";
	}
	
	@RequestMapping(value = "/estados/update", method = RequestMethod.POST)
	public String update(Model model, Estado estado) {
		estadoService.atualizar(estado);
		return "redirect:/estados/list";
	}
}
