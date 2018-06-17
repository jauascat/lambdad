package com.capalogica;

public class ExceptionValorCartaInvalido extends Exception{

	public ExceptionValorCartaInvalido() {
		super();
	}
	
	public ExceptionValorCartaInvalido(String message) {
		super(message+" es un valor de carta invalido");
	}
}
