package com.negocios;

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
	
	public void seDeshaceDeCarta()
	{
		int indiceCartaDesechar = (int) Math.random() * mano.size();
		mano.remove(indiceCartaDesechar);
	}

	public String getNombre() {
		return nombre;
	}
	
	public ArrayList<Carta> getMano() {
		return mano;
	}
}
