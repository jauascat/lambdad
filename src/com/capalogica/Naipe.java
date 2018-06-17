package com.capalogica;

import java.util.ArrayList;
import java.util.Collections;

public class Naipe {

	private ArrayList<Carta> cartas;
	
	public Naipe() {
		
		cartas = new ArrayList<>();
		
		for(PaloCarta palo : PaloCarta.values())
			for(NombreCarta nombre : NombreCarta.values())

				try {
					cartas.add(new Carta(nombre, palo, NombreCarta.getValor(nombre)));
				} catch (ValorCartaInvalidoException e) {
					e.printStackTrace();
				}
	}
	
	public void barajarse()
	{
		Collections.shuffle(cartas);
	}
	
	public ArrayList<Carta> getCartas()
	{
		return cartas;
	}
}
