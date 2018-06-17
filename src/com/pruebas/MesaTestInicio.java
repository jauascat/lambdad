package com.pruebas;

import static org.hamcrest.CoreMatchers.containsString;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Test;

import com.exepciones.MesaLlenaException;
import com.mocks.MockMesa21yMedioTodos;
import com.mocks.MockMesaRon;
import com.mocks.MockMesa21CambioManoA;
import com.mocks.MockMesa21CambioManoB;
import com.mocks.MockMesa21Normal;
import com.negocios.Carta;
import com.negocios.Jugador;
import com.negocios.Mesa;
import com.negocios.Repartidor;

public class MesaTestInicio {

	@Test
	public void probarRepartidorExistencia()
	{
		Mesa mesa = new Mesa();
		assertEquals(Repartidor.class, mesa.getRepartidor().getClass());
	}
	
	@Test
	public void probarMesaVaciaAlInicio()
	{
		Mesa mesa = new Mesa();
		assertEquals(0, mesa.getJugadores().size());
	}
	
	@Test
	public void probarAgregarJugador()
	{
		Mesa mesa = new Mesa();
		int capacidadJugadores = 4;
		
		//dentro de capacidad
		for(byte i=0; i < capacidadJugadores; i++)
		{
			try {
				
				mesa.agregarJugador(new Jugador(""));
				
			} catch(MesaLlenaException ex) {
				fail("No acepta cantidad de jugadres legal");
			}
		}
	
		//fuera de capacidad
		try {
			
			mesa.agregarJugador(new Jugador(""));
			fail("No lanza error cuando se agrega cantidad ilegal de jugadores");
			
		} catch(MesaLlenaException ex) {
			assertThat(ex.getMessage(), containsString("demasiados jugadores"));
		}
	}
	
	@Test
	public void probarReset21()
	{
		Mesa mesa = new MockMesa21Normal(4);
		
		mesa.reset();
		
		assertEquals(null, mesa.getDeck());
		assertEquals(Repartidor.class, mesa.getRepartidor().getClass());
		assertEquals(0, mesa.getJugadores().size());
		
	}
	
	@Test
	public void probarResetRon()
	{
		Mesa mesa = new MockMesaRon(4);
		
		mesa.reset();
		
		assertEquals(null, mesa.getDeck());
		assertEquals(Repartidor.class, mesa.getRepartidor().getClass());
		assertEquals(0, mesa.getJugadores().size());
	}
}
