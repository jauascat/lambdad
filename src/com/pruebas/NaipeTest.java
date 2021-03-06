package com.pruebas;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import static org.junit.Assert.*;

import org.junit.Test;

import com.enumeradores.PaloCarta;
import com.negocios.Carta;
import com.negocios.Naipe;

public class NaipeTest {

	@Test
	public void probarCantidadCartas() {
		
		Naipe naipe = new Naipe();
		assertEquals(52, naipe.getCartas().size());
	}
	
	@Test
	public void probarCuatroPalos() {
		
		Naipe naipe = new Naipe();
		ArrayList<Carta> cartas = naipe.getCartas();
		
		for(byte i = 0; i < cartas.size(); i++)
		{
			PaloCarta palo = cartas.get(i).getPaloCarta();
			assertEquals(PaloCarta.class, palo.getClass());
		}
	}
	
	@Test
	public void probarUnaCartaPorNaipe()
	{	
		Naipe naipe = new Naipe();
		ArrayList<Carta> cartas = naipe.getCartas();
		ArrayList<Carta> bufferCartas = new ArrayList<>();
		
		for(Carta carta : cartas)
		{			
			for(Carta cartaComparada : bufferCartas)
			{
				if(carta.getNombreCarta() == cartaComparada.getNombreCarta() && 
						carta.getPaloCarta() == cartaComparada.getPaloCarta())
					
					fail("Mas de un tipo de carta en el naipe");
				
				else
				
					bufferCartas.add(carta);
			}
		}
	}
}
