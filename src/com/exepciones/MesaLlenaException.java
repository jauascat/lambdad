package com.exepciones;

public class MesaLlenaException extends Exception{

	public MesaLlenaException() {
		super("La mesa tiene demasiados jugadores");
	}
}
