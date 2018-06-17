package com.pruebas;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.Map;

import org.junit.Test;

import com.negocios.Jugador;

public class JugadorTest {

	@Test
	public void probarNombreExiste() {
		
		Jugador jugador = new Jugador("");
		assertEquals(String.class, jugador.getNombre().getClass());
	}
	
	@Test
	public void probarManoVaciaAlInicio()
	{
		Jugador jugador = new Jugador("");
		assertEquals(0, jugador.getMano().size());
	}
	
	@Test
	public void probarManoPuedeTenerNCartas() {
		
		Jugador jugador = new Jugador("");
		Class claseMano = jugador.getMano().getClass();
		
		if(!Collection.class.isAssignableFrom(claseMano) && !Map.class.isAssignableFrom(claseMano))
		{
			fail("Mano del jugador no es una colección");
		}
	}
}
