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
		
		System.out.println("Cantidad Jugadores: "+jugadores.size());
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
				if(puntaje == mayorPuntaje)
				{
					ganadores.add(jugador);
				}
			}
		}
		System.out.println(mayorPuntaje);
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
				
			} catch (ValorCartaInvalidoException e) {
				
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
		int tamannoExcepcion = 2;
		int contador = 0;
		Carta carta1;
		Carta carta2;
		if(mano.size() == tamannoExcepcion)
		{
			carta1 = mano.get(contador++);
			carta2 = mano.get(contador++);
			
			if(Cartas.isNombreIguala21yMedio(carta1))
			{
				if(Cartas.isNombreIguala10(carta1))
				{
					if(Cartas.isNombreIguala2(carta2))
					{
						return 21;
					}
					else
					{
						return contarPuntos21Ordinariamente(mano, puntaje);
					}
				}
				else
				{
					if(Cartas.isNombreIguala10(carta2))
					{
						return 21;
					}
					else
					{
						return contarPuntos21Ordinariamente(mano, puntaje);
					}
				}
			}
			return contarPuntos21Ordinariamente(mano, puntaje);
		}
		else
		{
			return contarPuntos21Ordinariamente(mano, puntaje);
		}
		
	}
	
	public int contarPuntos21Ordinariamente(ArrayList<Carta> mano, int puntaje)
	{
		System.out.println(mano.size());
		for(Carta carta : mano)
		{
			puntaje += carta.getValor();
		}
		return puntaje;
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
			tomarCartaDelDeck(jugador);
		}
	}
	
	public void tomarCartaDelDeck(Jugador jugador)
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
