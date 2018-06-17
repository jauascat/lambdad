package com.pruebas;

import com.capalogica.ExceptionMesaLlena;
import com.capalogica.Jugador;
import com.capalogica.Mesa;

public class MockMesaNormal extends Mesa {

	int capacidadJugadores;
	
	public MockMesaNormal(int capacidadJugadores) {
		super();
		this.capacidadJugadores = capacidadJugadores;
		
		for(byte i = 0; i < capacidadJugadores; i++)
		{
			try {
				
				this.agregarJugador(new Jugador(""));
				
			} catch (ExceptionMesaLlena e) {
				e.printStackTrace();
			}
		}
		this.EmpezarAJugar21();
	}
}
