package com.pruebas;

import java.util.ArrayList;

import com.capalogica.Carta;
import com.capalogica.ExceptionMesaLlena;
import com.capalogica.ExceptionValorCartaInvalido;
import com.capalogica.Jugador;
import com.capalogica.Mesa;
import com.capalogica.NombreCarta;
import com.capalogica.PaloCarta;

public class MockMesaCambioManoB extends Mesa {

	int capacidadJugadores;
	
	public MockMesaCambioManoB(){
		super();
		this.capacidadJugadores = 4;
		
		for(byte i = 0; i < capacidadJugadores; i++)
		{
			try {
				
				this.agregarJugador(new Jugador(""));
				
			} catch (ExceptionMesaLlena e) {
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
				
		} catch (ExceptionValorCartaInvalido e) {
			e.printStackTrace();
		}
	}
}

