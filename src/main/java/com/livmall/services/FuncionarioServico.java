package com.livmall.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.livmall.entities.Funcionario;
import com.livmall.repositories.FuncionarioRepositorio;
import com.livmall.services.exceptions.AtualizacaoNaoEncontradoException;
import com.livmall.services.exceptions.DataBaseException;
import com.livmall.services.exceptions.RecursoNaoEncontradoException;

@Service
public class FuncionarioServico {

	@Autowired
	private FuncionarioRepositorio repositorio;

	public List<Funcionario> encontreTudo() {
		return repositorio.findAll();
	}

	public Funcionario encontrePeloId(Long id) {
		Optional<Funcionario> obj = repositorio.findById(id);
		return obj.orElseThrow(() -> new RecursoNaoEncontradoException(id));
	}

	public Funcionario inserir(Funcionario obj) {
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

	public Funcionario atualizar(Long id, Funcionario obj) {
		try {
			Funcionario entity = repositorio.getOne(id);
			atualizarDados(entity, obj);
			return repositorio.save(entity);
		} catch (EntityNotFoundException e) {
			throw new AtualizacaoNaoEncontradoException(e.getMessage());
		}
	}

	private void atualizarDados(Funcionario entity, Funcionario obj) {
		entity.setNome(obj.getNome());
		entity.setTelefone(obj.getTelefone());
		entity.setSenha(obj.getSenha());
		entity.setFuncao(obj.getFuncao());
		entity.setTurno(obj.getTurno());

	}

}
