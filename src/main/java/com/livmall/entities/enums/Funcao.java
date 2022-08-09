package com.livmall.entities.enums;

public enum Funcao {
	
	ADMINISTRACAO(1),
	PORTARIA(2),
	LIMPEZA(3);

	
	private int codigo;
	
	private Funcao(int codigo) {
		this.codigo = codigo;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public static Funcao valorDo(int codigo) {
		for(Funcao valor : Funcao.values()) {
			if(valor.getCodigo() == codigo) {
				return valor;
			}
		}
		throw new IllegalArgumentException("codigo da funcao invalido");
	}
	
}
