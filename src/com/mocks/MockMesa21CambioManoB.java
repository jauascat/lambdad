package com.mocks;

import java.util.ArrayList;

import com.enumeradores.NombreCarta;
import com.enumeradores.PaloCarta;
import com.exepciones.MesaLlenaException;
import com.exepciones.ValorCartaInvalidoException;
import com.negocios.Carta;
import com.negocios.Jugador;
import com.negocios.Mesa;

public class MockMesa21CambioManoB extends Mesa {

	int capacidadJugadores;
	
	public MockMesa21CambioManoB(){
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
			
		jugador.recibirCarta(new Carta(NombreCarta.KA,    PaloCarta.ESCUDOS,   NombreCarta.getValor(NombreCarta.KA)));
		jugador.recibirCarta(new Carta(NombreCarta.QUINA, PaloCarta.ESTRELLAS, NombreCarta.getValor(NombreCarta.QUINA)));
		jugador.recibirCarta(new Carta(NombreCarta.JOTA,  PaloCarta.FLORES,    NombreCarta.getValor(NombreCarta.JOTA)));
		jugador.recibirCarta(new Carta(NombreCarta.AS,  PaloCarta.GOTAS,     NombreCarta.getValor(NombreCarta.AS)));
			
		jugador = jugadores.get(contador++);
		
		jugador.recibirCarta(new Carta(NombreCarta.KA,    PaloCarta.ESCUDOS,   NombreCarta.getValor(NombreCarta.KA)));
		jugador.recibirCarta(new Carta(NombreCarta.QUINA, PaloCarta.ESTRELLAS, NombreCarta.getValor(NombreCarta.QUINA)));
		jugador.recibirCarta(new Carta(NombreCarta.SEIS,  PaloCarta.FLORES,    NombreCarta.getValor(NombreCarta.SEIS)));
		jugador.recibirCarta(new Carta(NombreCarta.SIETE,  PaloCarta.GOTAS,     NombreCarta.getValor(NombreCarta.SIETE)));
		
		jugador = jugadores.get(contador++);
		
		jugador.recibirCarta(new Carta(NombreCarta.KA,    PaloCarta.ESCUDOS,   NombreCarta.getValor(NombreCarta.KA)));
		jugador.recibirCarta(new Carta(NombreCarta.AS, PaloCarta.ESTRELLAS, NombreCarta.getValor(NombreCarta.AS)));
		jugador.recibirCarta(new Carta(NombreCarta.SEIS,  PaloCarta.FLORES,    NombreCarta.getValor(NombreCarta.SEIS)));
		jugador.recibirCarta(new Carta(NombreCarta.SIETE,  PaloCarta.GOTAS,     NombreCarta.getValor(NombreCarta.SIETE)));
		
		jugador = jugadores.get(contador++);
		
		jugador.recibirCarta(new Carta(NombreCarta.CINCO,    PaloCarta.ESCUDOS,   NombreCarta.getValor(NombreCarta.CINCO)));
		jugador.recibirCarta(new Carta(NombreCarta.AS, PaloCarta.ESTRELLAS, NombreCarta.getValor(NombreCarta.AS)));
		jugador.recibirCarta(new Carta(NombreCarta.SEIS,  PaloCarta.FLORES,    NombreCarta.getValor(NombreCarta.SEIS)));
		jugador.recibirCarta(new Carta(NombreCarta.SIETE,  PaloCarta.GOTAS,     NombreCarta.getValor(NombreCarta.SIETE)));
				
		} catch (ValorCartaInvalidoException e) {
			e.printStackTrace();
		}
	}
}

