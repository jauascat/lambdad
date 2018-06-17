package com.pruebas;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.capalogica.Carta;
import com.capalogica.NombreCarta;
import com.capalogica.PaloCarta;
import com.capalogica.ValorCartaInvalidoException;

public class CartaTest {

	@Test
	public void probarCarta() throws ValorCartaInvalidoException {
		
		Carta cartaPrueba;
		
		for(NombreCarta nombre : NombreCarta.values())
		{
			for(PaloCarta palo : PaloCarta.values())
			{
				cartaPrueba = new Carta(nombre, palo, NombreCarta.getValor(nombre));
				assertEquals(nombre, cartaPrueba.getNombre());
				assertEquals(  palo, cartaPrueba.getPalo());
				assertEquals(NombreCarta.getValor(cartaPrueba.getNombre()), cartaPrueba.getValor());
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
						fail("No tira exception ValorCartaInvalidoException");
						
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
	
//	@Test
//	public void probarEqualsDiferentes() throws ValorCartaInvalidoException
//	{
//		Carta carta1;
//		Carta carta2;
//
//		for(int i = 0; i < 10000; i++)
//		{
//			PaloCarta palo1 = obtenerPaloAleatorio();
//			PaloCarta palo2 = obtenerPaloAleatorio();
//			
//			NombreCarta nombre1 = obtenerNombreAleatorio();
//			NombreCarta nombre2 = obtenerNombreAleatorio();
//		
//			if(palo1 != palo2 && nombre1 != nombre2)
//			{
//				carta1 = new Carta(nombre1, palo1, NombreCarta.getValor(nombre1));
//				carta2 = new Carta(nombre2, palo2, NombreCarta.getValor(nombre2));
//				assertFalse(carta1.equals(carta2));
//			}
//	 	}
//	}
//	
//	public PaloCarta obtenerPaloAleatorio()
//	{
//		Random random = new Random();
//		int paloSeleccionado = random.nextInt(PaloCarta.class.getEnumConstants().length);
//		return PaloCarta.class.getEnumConstants()[paloSeleccionado];
//	}
//	
//	public NombreCarta obtenerNombreAleatorio()
//	{
//		Random random = new Random();
//		int nombreSeleccionado = random.nextInt(NombreCarta.class.getEnumConstants().length);
//		return NombreCarta.class.getEnumConstants()[nombreSeleccionado];
//	}
}
