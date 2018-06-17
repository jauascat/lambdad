package com.capalogica;

import java.util.ArrayList;

import org.junit.Test;

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

	public void EmpezarAJugar21()
	{
		saltearCartas(2);
	}
	
	private void saltearCartas(int cantidadCartas)
	{
		for(int i = 1; i <= cantidadCartas; i++)
			
			for(Jugador jugador : jugadores)
			
				repartidor.darCarta(jugador);
	}
	
	public Repartidor getRepartidor() {
		return repartidor;
	}
	
	public ArrayList<Jugador> getJugadores() {
		return jugadores;
	}
}
