package com.capalogica;

import java.util.Collections;

public class Repartidor {

	Naipe naipe;
	
	public Repartidor() {
		naipe = new Naipe();
		naipe.barajarse();
	}
	
	public Naipe getNaipe()
	{
		return naipe;
	}
}
