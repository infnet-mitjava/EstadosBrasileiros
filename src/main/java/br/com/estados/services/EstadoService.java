package br.com.estados.services;

import java.util.List;

import br.com.estados.model.Estado;


public interface EstadoService {
	List<Estado> listar();
	Estado pesquisar(Integer id);
	void salvar(Estado estado);
	void atualizar(Estado estado);
	void deletar(Integer id);
}
