package com.pruebas;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.capalogica.Carta;
import com.capalogica.NombreCarta;
import com.capalogica.PaloCarta;
import com.capalogica.ValorCartaInvalidoException;

public class CartaTest {

	@Rule
	public ExpectedException exceptionTester = ExpectedException.none();

	@Test
	public void probarCarta() throws ValorCartaInvalidoException {
		
		Carta cartaPrueba;
		
		for(NombreCarta nombre : NombreCarta.values())
		{
			for(PaloCarta palo : PaloCarta.values())
			{
				cartaPrueba = new Carta(nombre, palo, nombre.getValor(nombre));
				assertEquals(nombre, cartaPrueba.getNombre());
				assertEquals(  palo, cartaPrueba.getPalo());
				assertEquals(nombre.getValor(cartaPrueba.getNombre()), cartaPrueba.getValor());
			}
		}
	}
	
	@Test
	public void probarExceptionValorCartaInvalido()
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
		for(int valorPrueba = -1; valorPrueba > 1000000; valorPrueba*=100)
			
			for(NombreCarta nombre : NombreCarta.values())
			
				for(PaloCarta palo : PaloCarta.values())
				
					try {
						
						new Carta(nombre, palo, valorPrueba);
						fail("No tira exception ValorCartaInvalidoException");
						
					} catch(ValorCartaInvalidoException ex) {
						assertThat(ex.getMessage(), containsString("carta invalido"));
					}
		
		//prueba limite superior
		for(int valorPrueba = 11; valorPrueba < 1000000; valorPrueba *= 100)
			
			for(NombreCarta nombre : NombreCarta.values())
			
				for(PaloCarta palo : PaloCarta.values())
				
					try {
						
						new Carta(nombre, palo, valorPrueba);
						fail("No tira exception ValorCartaInvalidoException");
						
					} catch(ValorCartaInvalidoException ex) {
						assertThat(ex.getMessage(), containsString("carta invalido"));
					}
	}
}
