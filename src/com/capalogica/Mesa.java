package com.capalogica;

import java.util.ArrayList;

public class Mesa {

	private Repartidor repartidor;
	private ArrayList<Jugador> jugadores;
	
	public Mesa() {
	
		repartidor = new Repartidor();
		jugadores = new ArrayList<>();
	}
	
	public void agregarJugador(Jugador jugadorNuevo) throws ExceptionMesaLlena
	{
		if(jugadores.size() >= 4) throw new ExceptionMesaLlena();
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
	
	public ArrayList<Jugador> verificarGanadores21()
	{
		int mayorPuntaje = 0;
		int puntaje;
		ArrayList<Jugador> ganadores = new ArrayList<Jugador>();
		
		for(Jugador jugador : jugadores)
		{
			puntaje = jugador.verPuntaje21();
			if(puntaje <= 21)
			{
				if(puntaje > mayorPuntaje)
				{
					ganadores.clear();
					ganadores.add(jugador);
					mayorPuntaje = puntaje;
				}
				if(puntaje == mayorPuntaje)
				{
					ganadores.add(jugador);
				}
			}
		}
		return ganadores;
	}
	
	public Repartidor getRepartidor() {
		return repartidor;
	}
	
	public ArrayList<Jugador> getJugadores() {
		return jugadores;
	}
}
