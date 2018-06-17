package com.pruebas;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import org.junit.Test;

import com.mocks.MockMesaRon;
import com.negocios.Jugador;
import com.negocios.Mesa;

public class MesaTestRon {
	
	@Test
	public void probarInicioRon()
	{
		Mesa mesa = new MockMesaRon(4);
		int capacidadJugadores = 4;
		int cartasRepartidas = 7;
		
		ArrayList<Jugador> jugadoresActivos = mesa.getJugadores();
		//revisa que todos los jugadores tengan 2 cartas
		for(Jugador jugador : jugadoresActivos)
		{
			assertEquals(cartasRepartidas, jugador.getMano().size());
		}
	}
}
