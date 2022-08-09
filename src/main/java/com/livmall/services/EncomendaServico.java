package com.livmall.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.livmall.entities.Encomenda;
import com.livmall.repositories.EncomendaRepositorio;
import com.livmall.services.exceptions.AtualizacaoNaoEncontradoException;
import com.livmall.services.exceptions.DataBaseException;
import com.livmall.services.exceptions.RecursoNaoEncontradoException;

@Service
public class EncomendaServico {

	@Autowired
	private EncomendaRepositorio repositorio;

	public List<Encomenda> encontreTudo() {
		return repositorio.findAll();
	}

	public Encomenda encontrePeloId(Long id) {
		Optional<Encomenda> obj = repositorio.findById(id);
		return obj.orElseThrow(() -> new RecursoNaoEncontradoException(id));
	}

	public Encomenda inserir(Encomenda obj) {
		return repositorio.save(obj);
	}

	public void deletar(Long id) {
		try {
			repositorio.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new RecursoNaoEncontradoException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException(e.getMessage());
		}
	}

	public Encomenda atualizar(Long id, Encomenda obj) {
		try {
			Encomenda entity = repositorio.getOne(id);
			//atualizarDados(entity, obj);
			return repositorio.save(entity);
		} catch (EntityNotFoundException e) {
			throw new AtualizacaoNaoEncontradoException(e.getMessage());
		}
	}

	
	/*
	private void atualizarDados(Encomenda entity, Encomenda obj) {
		entity.setNome(obj.getNome());
		entity.setTelefone(obj.getTelefone());
		entity.setSenha(obj.getSenha());
		entity.setFuncao(obj.getFuncao());
		entity.setTurno(obj.getTurno());

	}

*/
}
