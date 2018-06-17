package com.pruebas;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.capalogica.Jugador;
import com.capalogica.Mesa;
import com.capalogica.Repartidor;

public class MesaTest {

	@Test
	public void probarRepartidorExistencia()
	{
		Mesa mesa = new Mesa();
		assertEquals(Repartidor.class, mesa.getRepartidor().getClass());
	}
	
	@Test
	public void probarCapacidadJugadores()
	{
		Mesa mesa = new Mesa();
		Jugador[] jugadoresActivo = mesa.getJugadores();
		assertEquals(4, jugadoresActivo.length);
	}
	
	@Test
	public void probarMesaVaciaAlInicio()
	{
		Mesa mesa = new Mesa();
		Jugador[] jugadoresActivo = mesa.getJugadores();
		
		for(int i=0; i < jugadoresActivo.length; i++)
		{
			assertEquals(null, jugadoresActivo[i]);
		}
	}
}
