package com.livmall.entities.enums;

public enum Turno {
	MANHA(1),
	NOITE(2);
	
	
	
	private int codigo;
	
	private Turno(int codigo) {
		this.codigo = codigo;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	
	public static Turno valorDo(int codigo) {
		for(Turno valor : Turno.values()) {
			if(valor.getCodigo() == codigo) {
				return valor;
			}
		}
		throw new IllegalArgumentException("codigo do turno invalido");
	}
}
