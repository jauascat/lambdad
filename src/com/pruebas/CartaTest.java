package com.pruebas;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.enumeradores.NombreCarta;
import com.enumeradores.PaloCarta;
import com.exepciones.ValorCartaInvalidoException;
import com.negocios.Carta;

public class CartaTest {

	@Test
	public void probarCarta() throws ValorCartaInvalidoException {
		
		Carta cartaPrueba;
		
		for(NombreCarta nombre : NombreCarta.values())
		{
			for(PaloCarta palo : PaloCarta.values())
			{
				cartaPrueba = new Carta(nombre, palo, NombreCarta.getValor(nombre));
				assertEquals(nombre, cartaPrueba.getNombreCarta());
				assertEquals(  palo, cartaPrueba.getPaloCarta());
				assertEquals(NombreCarta.getValor(cartaPrueba.getNombreCarta()), cartaPrueba.getValor());
			}
		}
	}
	
	@Test
	public void probarValorCartaInvalido()
	{		
		//prueba valor cero
		for(NombreCarta nombre : NombreCarta.values())
			
			for(PaloCarta palo : PaloCarta.values())
			
				try {
					
					new Carta(nombre, palo, 0); //aqui pone el valor cero
					fail("No tira exception ValorCartaInvalidoException");
					
				} catch(ValorCartaInvalidoException ex) {
					assertThat(ex.getMessage(), containsString("carta invalido"));
				}
		
		//prueba limite inferior
		for(int valorPrueba = -1; valorPrueba > 100000000; valorPrueba*=10)
			
			for(NombreCarta nombre : NombreCarta.values())
			
				for(PaloCarta palo : PaloCarta.values())
				
					try {
						
						new Carta(nombre, palo, valorPrueba);
						fail("No lanza exception ValorCartaInvalidoException");
						
					} catch(ValorCartaInvalidoException ex) {
						assertThat(ex.getMessage(), containsString("carta invalido"));
					}
		
		//prueba limite superior
		for(int valorPrueba = 11; valorPrueba < 100000000; valorPrueba *= 10)
			
			for(NombreCarta nombre : NombreCarta.values())
			
				for(PaloCarta palo : PaloCarta.values())
				
					try {
						
						new Carta(nombre, palo, valorPrueba);
						fail("No tira exception ValorCartaInvalidoException");
						
					} catch(ValorCartaInvalidoException ex) {
						assertThat(ex.getMessage(), containsString("carta invalido"));
					}
	}
	
	@Test
	public void probarEqualsIguales() throws ValorCartaInvalidoException
	{
		Carta carta1;
		Carta carta2;
		
		for(NombreCarta nombre : NombreCarta.values())
			
			for(PaloCarta palo : PaloCarta.values())
			{
				carta1 = new Carta(nombre, palo, NombreCarta.getValor(nombre));
				carta2 = new Carta(nombre, palo, NombreCarta.getValor(nombre));
				assertTrue(carta1.equals(carta2));
			}
		
		carta1 = new Carta(NombreCarta.AS, PaloCarta.ESCUDOS, NombreCarta.getValor(NombreCarta.AS));
		carta2 = new Carta(NombreCarta.AS, PaloCarta.GOTAS, NombreCarta.getValor(NombreCarta.AS));

		assertTrue(carta1.equals(carta2));
		
		carta1 = new Carta(NombreCarta.DIEZ, PaloCarta.ESCUDOS, NombreCarta.getValor(NombreCarta.DIEZ));
		carta2 = new Carta(NombreCarta.KA, PaloCarta.GOTAS, NombreCarta.getValor(NombreCarta.KA));

		assertTrue(carta1.equals(carta2));
		
		carta1 = new Carta(NombreCarta.JOTA, PaloCarta.ESCUDOS, NombreCarta.getValor(NombreCarta.JOTA));
		carta2 = new Carta(NombreCarta.KA, PaloCarta.GOTAS, NombreCarta.getValor(NombreCarta.KA));

		assertTrue(carta1.equals(carta2));
		
		carta1 = new Carta(NombreCarta.QUINA, PaloCarta.ESCUDOS, NombreCarta.getValor(NombreCarta.QUINA));
		carta2 = new Carta(NombreCarta.KA, PaloCarta.GOTAS, NombreCarta.getValor(NombreCarta.KA));

		assertTrue(carta1.equals(carta2));
	}
	
	@Test
	public void probarEqualsDiferentesSencillo() throws ValorCartaInvalidoException
	{
		Carta cartaUno;
		Carta cartaDos;

		cartaUno = new Carta(NombreCarta.DOS, PaloCarta.ESCUDOS, NombreCarta.getValor(NombreCarta.DOS));
		cartaDos = new Carta(NombreCarta.AS, PaloCarta.GOTAS, NombreCarta.getValor(NombreCarta.AS));

		assertFalse(cartaUno.equals(cartaDos));

		cartaUno = new Carta(NombreCarta.KA, PaloCarta.FLORES, NombreCarta.getValor(NombreCarta.KA));
		cartaDos = new Carta(NombreCarta.NUEVE, PaloCarta.FLORES, NombreCarta.getValor(NombreCarta.NUEVE));
		
		assertFalse(cartaUno.equals(cartaDos));
		
		cartaUno = new Carta(NombreCarta.TRES, PaloCarta.FLORES, NombreCarta.getValor(NombreCarta.TRES));
		cartaDos = new Carta(NombreCarta.DIEZ, PaloCarta.FLORES, NombreCarta.getValor(NombreCarta.DIEZ));
		
		assertFalse(cartaUno.equals(cartaDos));
	}
}
