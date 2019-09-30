package br.com.estados.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.estados.model.Estado;
import br.com.estados.model.persistence.EstadoDao;
import br.com.estados.services.EstadoService;

@Service
public class EstadoServiceImpl implements EstadoService {
	
	@Autowired
	private EstadoDao estadoDao;

	@Override
	public List<Estado> listar() {
		return estadoDao.getAll();
	}
	
	@Transactional(propagation = Propagation.NEVER)
	@Override
	public Estado pesquisar(Integer id) {
		return estadoDao.findOne(id);
	}
	
	@Transactional(propagation = Propagation.NEVER)
	@Override
	public void salvar(Estado estado) {
		estadoDao.salvar(estado);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void atualizar(Estado estado) {
		estadoDao.editar(estado);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void deletar(Integer id) {
		estadoDao.deletar(id);
	}
}
