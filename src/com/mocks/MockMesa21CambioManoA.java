package com.mocks;

import com.enumeradores.NombreCarta;
import com.enumeradores.PaloCarta;
import com.exepciones.MesaLlenaException;
import com.exepciones.ValorCartaInvalidoException;
import com.negocios.Carta;
import com.negocios.Jugador;
import com.negocios.Mesa;

public class MockMesa21CambioManoA extends Mesa {

	int capacidadJugadores;
	
	public MockMesa21CambioManoA(){
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
		for(Jugador jugador : this.getJugadores())
		{
			try {
				
				jugador.recibirCarta(new Carta(NombreCarta.KA,    PaloCarta.ESCUDOS,   NombreCarta.getValor(NombreCarta.KA)));
				jugador.recibirCarta(new Carta(NombreCarta.QUINA, PaloCarta.ESTRELLAS, NombreCarta.getValor(NombreCarta.QUINA)));
				jugador.recibirCarta(new Carta(NombreCarta.JOTA,  PaloCarta.FLORES,    NombreCarta.getValor(NombreCarta.JOTA)));
				jugador.recibirCarta(new Carta(NombreCarta.TRES,  PaloCarta.GOTAS,     NombreCarta.getValor(NombreCarta.TRES)));
				
			} catch (ValorCartaInvalidoException e) {
				e.printStackTrace();
			}
			
		}
	}
}
