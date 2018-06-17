package com.capalogica;

import com.capalogica.Jugador;
import com.capalogica.Repartidor;

public class Mesa {

	private Repartidor repartidor;
	private Jugador[] jugadores;
	
	public Mesa() {
	
		repartidor = new Repartidor();
		jugadores = new Jugador[4];
		
		System.out.println(jugadores[0]);
	}
	
	public Repartidor getRepartidor() {
		return repartidor;
	}
	
	public Jugador[] getJugadores() {
		return jugadores;
	}
}
