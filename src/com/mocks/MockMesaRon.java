package com.mocks;

import com.exepciones.MesaLlenaException;
import com.negocios.Jugador;
import com.negocios.Mesa;

public class MockMesaRon extends Mesa {

	int capacidadJugadores;
	
	public MockMesaRon(int capacidadJugadores) {
		super();
		this.capacidadJugadores = capacidadJugadores;
		
		for(byte i = 0; i < capacidadJugadores; i++)
		{
			try {
				
				this.agregarJugador(new Jugador(""));
				
			} catch (MesaLlenaException e) {
				e.printStackTrace();
			}
		}
		this.empezarPartidaDeRon();
	}
}
