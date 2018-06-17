package com.pruebas;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.negocios.Jugador;
import com.negocios.Naipe;
import com.negocios.Repartidor;

public class RepartidorTest {

	@Test
	public void probarSiHayNaipeAlInicio()
	{
		Repartidor repartidor = new Repartidor();
		assertEquals(Naipe.class, repartidor.getNaipe().getClass());
	}
	
	@Test
	public void probarRepartirCartaUnJugador()
	{
		Repartidor repartidor = new Repartidor();
		Jugador jugadorRecipiente = new Jugador("");
		
		for(int i = 0; i < 52; i++)
		{
			repartidor.darCarta(jugadorRecipiente);
			assertEquals(51 - i, repartidor.getNaipe().getCartas().size());
			assertEquals( i + 1, jugadorRecipiente.getMano().size());
		}
	}
}
