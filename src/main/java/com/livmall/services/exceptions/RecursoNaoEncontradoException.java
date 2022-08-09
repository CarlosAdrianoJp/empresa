package com.livmall.services.exceptions;

public class RecursoNaoEncontradoException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public RecursoNaoEncontradoException(Object id) {
		super("Recurso nao encontrado. ID " + id);
	}
	

}
