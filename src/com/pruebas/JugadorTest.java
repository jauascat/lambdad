package com.pruebas;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.Map;

import org.junit.Test;

import com.capalogica.Jugador;

public class JugadorTest {
	
	final String NOMBREPRUEBA = "";

	@Test
	public void probarNombreExiste() {
		Jugador jugador = new Jugador(NOMBREPRUEBA);
		assertEquals(String.class, jugador.getNombre().getClass());
	}
	
	@Test
	public void probarManoPuedeTenerNCartas() {
		
		Jugador jugador = new Jugador(NOMBREPRUEBA);
		Class claseMano = jugador.getMano().getClass();
		
		if(!Collection.class.isAssignableFrom(claseMano) && !Map.class.isAssignableFrom(claseMano))
		{
			fail("Mano del jugador no es una colleccion");
		}
	}
}
