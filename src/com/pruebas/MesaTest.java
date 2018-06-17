package com.pruebas;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Test;

import com.capalogica.Carta;
import com.capalogica.ExceptionMesaLlena;
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
				
			} catch(ExceptionMesaLlena ex) {
				fail("No acepta cantidad de jugadres legal");
			}
		}
	
		//fuera de capacidad
		try {
			
			mesa.agregarJugador(new Jugador(""));
			fail("No lanza error cuando se agrega cantidad ilegal de jugadores");
			
		} catch(ExceptionMesaLlena ex) {
			assertThat(ex.getMessage(), containsString("demasiados jugadores"));
		}
	}

	@Test
	public void probarInicioDe21()
	{
		Mesa mesa = new MockMesaNormal(4);
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
			Mesa mockMesa = new MockMesaNormal(4);
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
	public void pruebaCambioManoCambianTodos()
	{
		Mesa mockMesa = new MockMesaCambioManoA();
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
	public void pruebaCambioManoTodosCasiPeroNo()
	{
		Mesa mockMesa = new MockMesaCambioManoB();
		ArrayList<Jugador> jugadores = mockMesa.getJugadores();
		
		for(Jugador jugador : jugadores)
		{
			assertFalse(mockMesa.verificarCambio(jugador));
		}
	}
}
