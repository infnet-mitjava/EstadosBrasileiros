package br.edu.infnet.todoapp.app.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.todoapp.app.model.Estado;
import br.edu.infnet.todoapp.app.model.persistence.EstadoDao;
import br.edu.infnet.todoapp.app.services.EstadoService;

@Service
public class EstadoServiceImpl implements EstadoService {
	
	@Autowired
	private EstadoDao estadoDao;

	@Override
	public List<Estado> listar() {
		return estadoDao.getAll();
	}
	
	@Override
	public Estado pesquisar(Integer id) {
		return estadoDao.findOne(id);
	}
	
	@Override
	public void salvar(Estado estado) {
		estadoDao.salvar(estado);
	}
	
	@Override
	public void atualizar(Estado estado) {
		estadoDao.editar(estado);
	}
	
	@Override
	public void deletar(Integer id) {
		estadoDao.deletar(id);
	}
}
