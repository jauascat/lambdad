package com.pruebas;

import org.junit.Test;
import static org.junit.Assert.*;

import com.capalogica.Naipe;
import com.capalogica.Repartidor;

public class RepartidorTest {

	@Test
	public void probarSiHayNaipe()
	{
		Repartidor repartidor = new Repartidor();
		assertEquals(Naipe.class, repartidor.getNaipe().getClass());
	}
}
