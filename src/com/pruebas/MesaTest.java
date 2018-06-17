package com.pruebas;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Test;

import com.capalogica.Jugador;
import com.capalogica.Mesa;
import com.capalogica.MesaLlenaException;
import com.capalogica.Repartidor;

public class MesaTest {

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
		
		for(byte i=0; i < 4; i++)
		{
			try {
				
				mesa.agregarJugador(new Jugador(""));
				
			} catch(MesaLlenaException ex) {
				fail("No acepta cantidad de jugadres legal");
			}
		}
	
		try {
			
			mesa.agregarJugador(new Jugador(""));
			fail("No lanza error cuando se agrega cantidad ilegal de jugadores");
			
		} catch(MesaLlenaException ex) {
			assertThat(ex.getMessage(), containsString("demasiados jugadores"));
		}
	}

	@Test
	public void probarInicioDe21()
	{
		Mesa mesa = new Mesa();
		
		for(byte i = 0; i < 4; i++)
		{
			try {
				
				mesa.agregarJugador(new Jugador(""));
				
			} catch (MesaLlenaException e) {
				e.printStackTrace();
			}
		}
		mesa.EmpezarAJugar21();
		
		ArrayList<Jugador> jugadoresActivos = mesa.getJugadores();
		for(Jugador jugador : jugadoresActivos)
		{
			assertEquals(2, jugador.getMano().size());
		}
	}
}
