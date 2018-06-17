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
import com.mocks.MockMesa21CambioManoA;
import com.mocks.MockMesa21CambioManoB;
import com.mocks.MockMesa21Normal;
import com.negocios.Carta;
import com.negocios.Jugador;
import com.negocios.Mesa;
import com.negocios.Repartidor;

public class MesaTest21CambioMano {

	@Test
	public void probarCambioManoCambianTodos()
	{
		Mesa mockMesa = new MockMesa21CambioManoA();
		ArrayList<Jugador> jugadores = mockMesa.getJugadores();
		
		for(Jugador jugador : jugadores)
		{
			assertTrue(mockMesa.verificarCambio(jugador));
		}
		
		for(Jugador jugador : jugadores)
		{
			assertFalse(mockMesa.verificarCambio(jugador));
		}
	}
	
	@Test
	public void probarCambioManoTodosCasiPeroNo()
	{
		Mesa mockMesa = new MockMesa21CambioManoB();
		ArrayList<Jugador> jugadores = mockMesa.getJugadores();
		
		for(Jugador jugador : jugadores)
		{
			assertFalse(mockMesa.verificarCambio(jugador));
		}
	}
}
