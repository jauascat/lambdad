package com.pruebas;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Test;

import com.capalogica.Jugador;
import com.capalogica.Mesa;
import com.capalogica.ExceptionMesaLlena;
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
		Mesa mesa = new Mesa();
		int capacidadJugadores = 4;
		int cartasRepartidas = 2;
		
		for(byte i = 0; i < capacidadJugadores; i++)
		{
			try {
				
				mesa.agregarJugador(new Jugador(""));
				
			} catch (ExceptionMesaLlena e) {
				e.printStackTrace();
			}
		}
		mesa.EmpezarAJugar21();
		
		ArrayList<Jugador> jugadoresActivos = mesa.getJugadores();
		for(Jugador jugador : jugadoresActivos)
		{
			assertEquals(cartasRepartidas, jugador.getMano().size());
		}
		
		assertEquals(52-(cartasRepartidas * capacidadJugadores), mesa.getRepartidor().getNaipe().getCartas().size());
	}
	
	@Test
	public void probarGanadorDe21()
	{
		//juega 100 partidas de un turno
		for(byte m = 0; m < 100; m++)
		{
			Mesa mesa = new Mesa();
			ArrayList<Jugador> ganadores = new ArrayList<>();
			int capacidadJugadores = 4;
			int cartasRepartidas = 2;
			ArrayList<Jugador> jugadoresActivos = mesa.getJugadores();
			int puntajeMayor = 0;
			int puntajeJugador = 0;
			int puntajeComparador = 0;

			//prepara mesa
			for(byte i = 0; i < capacidadJugadores; i++)
			{
				try {
					
					mesa.agregarJugador(new Jugador(""));
					
				} catch (ExceptionMesaLlena e) {
					e.printStackTrace();
				}
			}
			mesa.EmpezarAJugar21();
			
			//calcula ganadores con dos cartas
			ganadores = mesa.verificarGanadores21();
			
			//verifica que siempre haya al menos un ganador
			assertTrue(ganadores.size() > 0);
			
			//recalcula nota mas alta potencial
			for(Jugador jugador : jugadoresActivos)
			{
				puntajeJugador = jugador.verPuntaje21();
				
				if(puntajeJugador <= 21)
					
					if(puntajeJugador > puntajeMayor)
						
							puntajeMayor = puntajeJugador;
			}
			
			//verifica que ningun ganador potencial haya sido superado por un jugador no escogido
			for(Jugador jugadorGanador : ganadores)
			{
				if(jugadorGanador.verPuntaje21() < puntajeMayor)
				{
					fail("no se encontro el ganador correcto");
				}
			}
			
			//verifica si el empate es valido
			if(ganadores.size() > 1)
			{
				puntajeJugador = ganadores.get(0).verPuntaje21();
				for(Jugador jugadorGanador : ganadores)
				{
					if(puntajeJugador != jugadorGanador.verPuntaje21())
					{
						fail("Jugadores empatados tienen puntajes distintos");
					}
				}
			}
		}
	}
}
