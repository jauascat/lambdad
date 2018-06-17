package com.pruebas;

import com.capalogica.Carta;
import com.capalogica.ExceptionMesaLlena;
import com.capalogica.ExceptionValorCartaInvalido;
import com.capalogica.Jugador;
import com.capalogica.Mesa;
import com.capalogica.NombreCarta;
import com.capalogica.PaloCarta;

public class MockMesaCambioManoA extends Mesa {

	int capacidadJugadores;
	
	public MockMesaCambioManoA(){
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
		for(Jugador jugador : this.getJugadores())
		{
			try {
				
				jugador.recibirCarta(new Carta(NombreCarta.KA,    PaloCarta.ESCUDOS,   NombreCarta.getValor(NombreCarta.KA)));
				jugador.recibirCarta(new Carta(NombreCarta.QUINA, PaloCarta.ESTRELLAS, NombreCarta.getValor(NombreCarta.QUINA)));
				jugador.recibirCarta(new Carta(NombreCarta.JOTA,  PaloCarta.FLORES,    NombreCarta.getValor(NombreCarta.JOTA)));
				jugador.recibirCarta(new Carta(NombreCarta.TRES,  PaloCarta.GOTAS,     NombreCarta.getValor(NombreCarta.TRES)));
				
			} catch (ExceptionValorCartaInvalido e) {
				e.printStackTrace();
			}
			
		}
	}
}
