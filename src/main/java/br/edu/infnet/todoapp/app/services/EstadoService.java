package br.edu.infnet.todoapp.app.services;

import java.util.List;

import br.edu.infnet.todoapp.app.model.Estado;


public interface EstadoService {
	List<Estado> listar();
	Estado pesquisar(Integer id);
	void salvar(Estado estado);
	void atualizar(Estado estado);
	void deletar(Integer id);
}
