package com.pruebas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Test;

import com.mocks.MockMesa21yMedioTodos;
import com.mocks.MockMesa21CambioManoA;
import com.mocks.MockMesa21CambioManoB;
import com.mocks.MockMesa21GananComodinCasiTodos;
import com.mocks.MockMesa21GananComodinTodos;
import com.mocks.MockMesa21Normal;
import com.mocks.MockMesa21yMedioCasiTodos;
import com.negocios.Jugador;
import com.negocios.Manos;
import com.negocios.Mesa;

public class MesaTest21 {
	
	@Test
	public void probarInicioDe21()
	{
		Mesa mesa = new MockMesa21Normal(4);
		int capacidadJugadores = 4;
		int cartasRepartidas = 2;
		
		ArrayList<Jugador> jugadoresActivos = mesa.getJugadores();
		//revisa que todos los jugadores tengan 2 cartas
		for(Jugador jugador : jugadoresActivos)
		{
			assertEquals(cartasRepartidas, jugador.getMano().size());
		}
	}
	
	@Test
	public void probarGanadorDe21()
	{
		//juega 100 partidas de solo un turno
		for(byte m = 0; m < 100; m++)
		{
			Mesa mockMesa = new MockMesa21Normal(4);
			ArrayList<Jugador> ganadores;
			ArrayList<Jugador> jugadoresActivos;
			int puntajeMayor;
			int puntajeJugador;

			//calcula ganadores con dos cartas (juego corto)
			ganadores = mockMesa.verificarGanadores21();
			
			//verifica que siempre haya al menos un ganador
			assertTrue(ganadores.size() > 0);
			
			//recalcula nota mas alta potencial
			jugadoresActivos = mockMesa.getJugadores();
			puntajeMayor = 0;
			for(Jugador jugador : jugadoresActivos)
			{
				puntajeJugador = mockMesa.calcularPuntaje21(jugador);
				
				if(puntajeJugador <= 21)
					
					if(puntajeJugador > puntajeMayor)
						
							puntajeMayor = puntajeJugador;
			}
			
			//verifica que ningun ganador potencial haya sido superado por un jugador no escogido
			ganadores = new ArrayList<>();
			for(Jugador jugadorGanador : ganadores)
			{
				if(mockMesa.calcularPuntaje21(jugadorGanador) < puntajeMayor)
				{
					fail("no se encontro el ganador correcto");
				}
			}
			
			//verifica si el empate es valido
			if(ganadores.size() > 1)
			{
				puntajeJugador = mockMesa.calcularPuntaje21(ganadores.get(0));
				for(Jugador jugadorGanador : ganadores)
				{
					if(puntajeJugador != mockMesa.calcularPuntaje21(jugadorGanador))
					{
						fail("Jugadores empatados tienen puntajes distintos");
					}
				}
			}
		}
	}
	
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
	
	@Test
	public void probarGananLaMitad21yMedio()
	{
		Mesa mockMesa = new MockMesa21yMedioTodos();
		ArrayList<Jugador> ganadores = mockMesa.verificarGanadores21();
		assertEquals(2, ganadores.size());
	}
	
	@Test
	public void probarCasiGananTodos21yMedioPeroNo()
	{
		Mesa mockMesa = new MockMesa21yMedioCasiTodos();
		ArrayList<Jugador> jugadores = mockMesa.getJugadores();
		
		for(Jugador jugador : jugadores)
		{
			assertFalse(Manos.is21yMedio(jugador.getMano()));
		}
	}
	
	@Test
	public void probarGananComodinTodos()
	{
		Mesa mockMesa = new MockMesa21GananComodinTodos();
		ArrayList<Jugador> jugadores = mockMesa.getJugadores();
		
		for(Jugador jugador : jugadores)
		{
			assertTrue(Manos.isComodin21(jugador.getMano()));
		}
	}
	
	@Test
	public void probarGananComodinCasiTodosPeroNo()
	{
		Mesa mockMesa = new MockMesa21GananComodinCasiTodos();
		ArrayList<Jugador> jugadores = mockMesa.getJugadores();
		
		for(Jugador jugador : jugadores)
		{
			assertFalse(Manos.isComodin21(jugador.getMano()));
		}
	}
}
