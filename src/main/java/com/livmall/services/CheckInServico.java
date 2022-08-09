package com.livmall.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.livmall.entities.CheckIn;
import com.livmall.repositories.CheckInRepositorio;
import com.livmall.services.exceptions.AtualizacaoNaoEncontradoException;
import com.livmall.services.exceptions.DataBaseException;
import com.livmall.services.exceptions.RecursoNaoEncontradoException;

@Service
public class CheckInServico {

	@Autowired
	private CheckInRepositorio repositorio;

	public List<CheckIn> encontreTudo() {
		return repositorio.findAll();
	}

	public CheckIn encontrePeloId(Long id) {
		Optional<CheckIn> obj = repositorio.findById(id);
		return obj.orElseThrow(() -> new RecursoNaoEncontradoException(id));
	}

	public CheckIn inserir(CheckIn obj) {
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

	public CheckIn atualizar(Long id, CheckIn obj) {
		try {
			CheckIn entity = repositorio.getOne(id);
			//atualizarDados(entity, obj);
			return repositorio.save(entity);
		} catch (EntityNotFoundException e) {
			throw new AtualizacaoNaoEncontradoException(e.getMessage());
		}
	}

	
	/*
	private void atualizarDados(CheckIn entity, CheckIn obj) {
		entity.setNome(obj.getNome());
		entity.setTelefone(obj.getTelefone());
		entity.setSenha(obj.getSenha());
		entity.setFuncao(obj.getFuncao());
		entity.setTurno(obj.getTurno());

	}

*/
}
