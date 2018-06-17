package com.mocks;

import java.util.ArrayList;

import com.enumeradores.NombreCarta;
import com.enumeradores.PaloCarta;
import com.exepciones.MesaLlenaException;
import com.exepciones.ValorCartaInvalidoException;
import com.negocios.Carta;
import com.negocios.Jugador;
import com.negocios.Mesa;

public class MockMesa21GananComodinTodos extends Mesa {

	int capacidadJugadores;
	
	public MockMesa21GananComodinTodos(){
		super();
		this.capacidadJugadores = 4;
		
		for(byte i = 0; i < capacidadJugadores; i++)
		{
			try {
				
				this.agregarJugador(new Jugador(""));
				
			} catch (MesaLlenaException e) {
				e.printStackTrace();
			}
		}
		Jugador jugador = null;
		int contador = 0;
		ArrayList<Jugador> jugadores = this.getJugadores();	
		try
		{
			jugador = jugadores.get(contador++);
				
			jugador.recibirCarta(new Carta(NombreCarta.SIETE,    PaloCarta.ESCUDOS,   NombreCarta.getValor(NombreCarta.SIETE)));
			jugador.recibirCarta(new Carta(NombreCarta.NUEVE, PaloCarta.FLORES, NombreCarta.getValor(NombreCarta.NUEVE)));
				
			jugador = jugadores.get(contador++);
			
			jugador.recibirCarta(new Carta(NombreCarta.NUEVE,    PaloCarta.ESCUDOS,   NombreCarta.getValor(NombreCarta.NUEVE)));
			jugador.recibirCarta(new Carta(NombreCarta.SIETE,    PaloCarta.ESCUDOS,   NombreCarta.getValor(NombreCarta.SIETE)));
			
			jugador = jugadores.get(contador++);
			
			jugador.recibirCarta(new Carta(NombreCarta.SIETE,    PaloCarta.ESCUDOS,   NombreCarta.getValor(NombreCarta.SIETE)));
			jugador.recibirCarta(new Carta(NombreCarta.NUEVE, PaloCarta.FLORES, NombreCarta.getValor(NombreCarta.NUEVE)));
				
			jugador = jugadores.get(contador++);
			
			jugador.recibirCarta(new Carta(NombreCarta.NUEVE,    PaloCarta.ESCUDOS,   NombreCarta.getValor(NombreCarta.NUEVE)));
			jugador.recibirCarta(new Carta(NombreCarta.SIETE,    PaloCarta.ESCUDOS,   NombreCarta.getValor(NombreCarta.SIETE)));

				
		} catch (ValorCartaInvalidoException e) {
			e.printStackTrace();
		}
	}
}
