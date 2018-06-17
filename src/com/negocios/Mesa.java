package com.negocios;

import java.util.ArrayList;
import java.util.ListIterator;

import com.enumeradores.NombreCarta;
import com.enumeradores.PaloCarta;
import com.exepciones.MesaLlenaException;
import com.exepciones.ValorCartaInvalidoException;

public class Mesa {

	private Naipe deck;
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
	
	public void reset()
	{
		repartidor = new Repartidor();
		jugadores = new ArrayList<>();
		deck = null;
	}

	public void EmpezarAJugar21()
	{
		repartidor.saltearCartas(jugadores, 2);
	}

	public ArrayList<Jugador> verificarGanadores21()
	{
		int mayorPuntaje = 0;
		int puntaje = 0;
		ArrayList<Jugador> ganadores = new ArrayList<>();
		
		for(Jugador jugador : jugadores)
		{
			puntaje = this.calcularPuntaje21(jugador);
			if(puntaje <= 21)
			{
				System.out.println("puntaje: "+puntaje);
				System.out.println("mayorPuntaje: "+mayorPuntaje);
				if(puntaje > mayorPuntaje)
				{
					ganadores = new ArrayList<>();
					ganadores.add(jugador);
					mayorPuntaje = puntaje;
				}
				else
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
		boolean validacion = Manos.isMerecedorCambioMano21(mano);
		if(validacion)
		{
			repartidor.darCambioMano21(mano);
		}
		return validacion;
	}
	
	public int calcularPuntaje21(Jugador jugador)
	{
		ArrayList<Carta> mano = jugador.getMano();
		int tamannoExcepcion = 2;
		
		if(mano.size() == tamannoExcepcion)
		{
			if(Manos.is21yMedio(mano))	return 21;
			else
			
				return Manos.contarPuntos21Normal(mano);
		}
		else
		
			return Manos.contarPuntos21Normal(mano);
	}
	
	public void empezarPartidaDeRon()
	{
		repartidor.saltearCartas(jugadores, 7);
		deck = repartidor.getNaipe();
	}
	
	public void jugarTurnoRon()
	{
		for(Jugador jugador : jugadores)
		{
			jugador.seDeshaceDeCarta();
			tomarCartaDelDeckRon(jugador);
		}
	}
	
	public void tomarCartaDelDeckRon(Jugador jugador)
	{
		jugador.recibirCarta(deck.tomarCartaDelNaipe());
	}
		
	public Repartidor getRepartidor() {
		return repartidor;
	}
	
	public ArrayList<Jugador> getJugadores() {
		return jugadores;
	}
	
	public Naipe getDeck()
	{
		return deck;
	}
}
