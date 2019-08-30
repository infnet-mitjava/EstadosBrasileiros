package br.edu.infnet.todoapp.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.infnet.todoapp.app.model.Todo;

@Controller
public class TodoController {

	@Autowired
	private TodoService service;
	
	@RequestMapping(value = "/todos", method = RequestMethod.GET)
	public String list(Model model) {

		model.addAttribute("listaTodos", service.getTodos());
		return "todos/list";
	}
	
	@RequestMapping(value = "/viewForm" , method = RequestMethod.GET)
	public String viewForm(Model model) {
		return "todos/form";
	}
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Model model, Todo todo) {
		service.persite(todo);
		return "redirect:todos";
	}
	
	
	public TodoService getService() {
		return service;
	}

	public void setService(TodoService service) {
		this.service = service;
	}
	
}