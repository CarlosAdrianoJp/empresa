package com.livmall.recouces.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;


import com.livmall.services.exceptions.AtualizacaoNaoEncontradoException;
import com.livmall.services.exceptions.DataBaseException;
import com.livmall.services.exceptions.RecursoNaoEncontradoException;

public class RecursoExceptionManual {

	
	@ExceptionHandler(RecursoNaoEncontradoException.class)
	public ResponseEntity<StandardError> recursoNaoEcontrado(RecursoNaoEncontradoException e, HttpServletRequest request){
		
		String error = "recurso nao encontrado";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	
	
	@ExceptionHandler(DataBaseException.class)
	public ResponseEntity<StandardError> dataBase(DataBaseException e, HttpServletRequest request){
		
		String error = "Erro na base de dados";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(AtualizacaoNaoEncontradoException.class)
	public ResponseEntity<StandardError> dataBase(AtualizacaoNaoEncontradoException e, HttpServletRequest request){
		
		String error = "Erro ao atualizar..";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}
