package com.pruebas;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import org.junit.Test;

import com.mocks.MockMesaRon;
import com.negocios.Jugador;
import com.negocios.Mesa;
import com.negocios.Naipe;

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
	
	@Test
	public void probarRepartidorDejaNaipe()
	{
		Mesa mesa = new MockMesaRon(4);
		assertEquals(Naipe.class, mesa.getDeck().getClass());
	}
	
	@Test
	public void probarJugarTurnoRon()
	{
		Mesa mesa = new MockMesaRon(4);
		ArrayList<Jugador> jugadores = mesa.getJugadores();
		
		mesa.jugarTurnoRon();
		
		for(Jugador jugador : jugadores)
		{
			assertEquals(7, jugador.getMano().size());
		}
	}
}
