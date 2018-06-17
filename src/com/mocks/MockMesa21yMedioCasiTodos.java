package com.mocks;

import java.util.ArrayList;

import com.enumeradores.NombreCarta;
import com.enumeradores.PaloCarta;
import com.exepciones.MesaLlenaException;
import com.exepciones.ValorCartaInvalidoException;
import com.negocios.Carta;
import com.negocios.Jugador;
import com.negocios.Mesa;

public class MockMesa21yMedioCasiTodos extends Mesa {

	int capacidadJugadores;
	
	public MockMesa21yMedioCasiTodos(){
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
				
			jugador.recibirCarta(new Carta(NombreCarta.DIEZ,    PaloCarta.ESCUDOS,   NombreCarta.getValor(NombreCarta.DIEZ)));
			jugador.recibirCarta(new Carta(NombreCarta.DOS, PaloCarta.FLORES, NombreCarta.getValor(NombreCarta.DOS)));
			jugador.recibirCarta(new Carta(NombreCarta.NUEVE, PaloCarta.ESTRELLAS, NombreCarta.getValor(NombreCarta.NUEVE)));
				
			jugador = jugadores.get(contador++);
			
			jugador.recibirCarta(new Carta(NombreCarta.JOTA,    PaloCarta.ESCUDOS,   NombreCarta.getValor(NombreCarta.JOTA)));
			jugador.recibirCarta(new Carta(NombreCarta.DOS,    PaloCarta.ESCUDOS,   NombreCarta.getValor(NombreCarta.DOS)));
			jugador.recibirCarta(new Carta(NombreCarta.DIEZ, PaloCarta.ESTRELLAS, NombreCarta.getValor(NombreCarta.DIEZ)));
			
			jugador = jugadores.get(contador++);
			
			jugador.recibirCarta(new Carta(NombreCarta.DOS,    PaloCarta.FLORES,   NombreCarta.getValor(NombreCarta.DOS)));
			jugador.recibirCarta(new Carta(NombreCarta.DOS, PaloCarta.ESTRELLAS, NombreCarta.getValor(NombreCarta.DOS)));
			jugador.recibirCarta(new Carta(NombreCarta.CUATRO, PaloCarta.FLORES, NombreCarta.getValor(NombreCarta.CUATRO)));
				
			jugador = jugadores.get(contador++);
			
			jugador.recibirCarta(new Carta(NombreCarta.CINCO,    PaloCarta.ESCUDOS,   NombreCarta.getValor(NombreCarta.CINCO)));
			jugador.recibirCarta(new Carta(NombreCarta.DIEZ, PaloCarta.GOTAS, NombreCarta.getValor(NombreCarta.DIEZ)));
			jugador.recibirCarta(new Carta(NombreCarta.DIEZ, PaloCarta.ESTRELLAS, NombreCarta.getValor(NombreCarta.DIEZ)));

				
		} catch (ValorCartaInvalidoException e) {
			e.printStackTrace();
		}
	}
}
