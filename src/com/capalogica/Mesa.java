package com.capalogica;

import java.util.ArrayList;

public class Mesa {

	private Repartidor repartidor;
	private ArrayList<Jugador> jugadores;
	
	public Mesa() {
	
		repartidor = new Repartidor();
		jugadores = new ArrayList<>();
	}
	
	public void agregarJugador(Jugador jugadorNuevo) throws MesaLlenaException
	{
		if(jugadores.size() >= 4) throw new MesaLlenaException();
		else
			jugadores.add(jugadorNuevo);
	}
	
	public Repartidor getRepartidor() {
		return repartidor;
	}
	
	public ArrayList<Jugador> getJugadores() {
		return jugadores;
	}
}
