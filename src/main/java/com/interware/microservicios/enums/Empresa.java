package com.interware.microservicios.enums;

public enum Empresa {
	EMPRESA01("001","EMPRESA 1"),
	EMPRESA02("002","EMPRESA 2");
	
	private final String valor;
	private final String descricion;
	
	Empresa(String valor1, String descricion1) {
        valor = valor1;
        descricion = descricion1;
    }

	public String getValor() {
		return this.valor;
	}

	public String getDescricion() {
		return this.descricion;
	}
	
}
