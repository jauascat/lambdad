package com.capalogica;

import java.util.ArrayList;

public class Jugador {

	private String nombre;
	private ArrayList<Carta> mano;
	
	public Jugador(String nombre) {
		this.nombre = nombre;
		mano = new ArrayList<>();
	}
	
	public void recibirCarta(Carta cartaRecibida)
	{
		mano.add(cartaRecibida);
	}

	public String getNombre() {
		return nombre;
	}
	
	public ArrayList<Carta> getMano() {
		return mano;
	}
}
