package com.interware.microservicios.enums;

public enum Activo {
	ACTIVO(1,"Si"),
	NO_ACTIVO(2,"No");
	
	private final int valor;
	private final String descricion;
	
	Activo(int valor1, String descricion1) {
        valor = valor1;
        descricion = descricion1;
    }

	public int getValor() {
		return this.valor;
	}

	public String getDescricion() {
		return this.descricion;
	}
	
}
