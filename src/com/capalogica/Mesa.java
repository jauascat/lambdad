package com.capalogica;

import java.util.ArrayList;
import java.util.ListIterator;

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
			puntaje = this.calcularPuntaje21(jugador);
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
	
	//el retorno de esta funcion confirma si se efectuo el cambio
	public boolean verificarCambio(Jugador jugador)
	{
		ArrayList<Carta> mano = jugador.getMano();
		ArrayList<Carta> clonMano = new ArrayList<>();
		boolean validacion = false;
		
		//clona la mano porque el analisis destruye la muestra
		for(Carta carta : mano)
		{
			try {
				clonMano.add(new Carta(carta.getNombreCarta(), carta.getPaloCarta(), carta.getValor()));
				
			} catch (ExceptionValorCartaInvalido e) {
				
				e.printStackTrace();
			}
		}
		
		//sale si niquiera tiene 4 cartas
		if(mano.size() != 4)
			return false;
		else
		{
			//recorre la (clon)mano del jugador
			ListIterator<Carta> manoIterador = clonMano.listIterator();
			while(manoIterador.hasNext()) {
				
				Carta carta = manoIterador.next();
				repartidor.cortarSiTipoCartaEsTipo(manoIterador, carta, NombreCarta.QUINA);
				repartidor.cortarSiTipoCartaEsTipo(manoIterador, carta, NombreCarta.JOTA);
				repartidor.cortarSiTipoCartaEsTipo(manoIterador, carta, NombreCarta.KA);
				repartidor.cortarSiTipoCartaEsTipo(manoIterador, carta, NombreCarta.TRES);
			}
			//si quedaron elementos entonces hay previous => las cartas no son correctas
			if(manoIterador.hasPrevious())
			{
				Carta carta = manoIterador.previous();
				return false;
			}
				
			else {
				//de otra manera es porque las 4 cartas, J,Q,K,3 eran las unicas en la mano
				//=> las cartas son correctas => repartidor da mano de cambio
				repartidor.darManoCambio(mano);
				return true;
			}
		}
	}
	
	public int calcularPuntaje21(Jugador jugador)
	{
		ArrayList<Carta> mano = jugador.getMano();
		int puntaje = 0;
		for(Carta carta : mano)
		{
			puntaje += carta.getValor();
		}
		return puntaje;
	}
	
	public Repartidor getRepartidor() {
		return repartidor;
	}
	
	public ArrayList<Jugador> getJugadores() {
		return jugadores;
	}
}
