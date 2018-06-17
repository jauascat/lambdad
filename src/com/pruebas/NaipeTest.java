package com.pruebas;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Objects;
import static org.junit.Assert.*;

import org.junit.Test;

import com.capalogica.Carta;
import com.capalogica.Naipe;
import com.capalogica.NombreCarta;
import com.capalogica.PaloCarta;
import com.capalogica.ValorCartaInvalidoException;

public class NaipeTest {

	@Test
	public void probarCantidadCartas() throws ValorCartaInvalidoException {
		
		Naipe naipe = new Naipe();;
		assertEquals(52, naipe.getCartas().size());
	}
	
	@Test
	public void probarCuatroPalos() throws ValorCartaInvalidoException {
		
		Naipe naipe = new Naipe();
		ArrayList<Carta> cartas = naipe.getCartas();
		
		for(byte i = 0; i < cartas.size(); i++)
		{
			PaloCarta palo = cartas.get(i).getPalo();
			assertEquals(PaloCarta.class, palo.getClass());
		}
	}
	
	@Test
	public void probarUnaCartaPorNaipe() throws ValorCartaInvalidoException
	{	
		Naipe naipe = new Naipe();
		ArrayList<Carta> cartas = naipe.getCartas();
		ArrayList<Carta> bufferCartas = new ArrayList<>();
		
		for(Carta carta : cartas)
		{			
			for(Carta cartaComparada : bufferCartas)
			{
				if(carta.getNombre() == cartaComparada.getNombre() && carta.getPalo() == cartaComparada.getPalo())
					
					fail("Mas de un tipo de carta en el naipe");
				
				else
				
					bufferCartas.add(carta);
			}
		}
	}
}
