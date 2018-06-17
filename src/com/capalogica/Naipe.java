package com.capalogica;

import java.util.ArrayList;

public class Naipe {

	private ArrayList<Carta> cartas;
	
	public Naipe() throws ValorCartaInvalidoException {
		
		cartas = new ArrayList<>();
		
		for(PaloCarta palo : PaloCarta.values())
			for(NombreCarta nombre : NombreCarta.values())

				try {
					cartas.add(new Carta(nombre, palo, NombreCarta.getValor(nombre)));
				} catch (ValorCartaInvalidoException e) {
					e.printStackTrace();
				}
		
		
	}
	
	public ArrayList<Carta> getCartas()
	{
		return cartas;
	}
}
