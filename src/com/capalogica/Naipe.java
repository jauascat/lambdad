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
				} catch (ExceptionValorCartaInvalido e) {
					e.printStackTrace();
				}
	}
	
	public Carta tomarCartaDelNaipe()
	{
		Carta cartaTomada = cartas.get(0);
		cartas.remove(0);
		
		return cartaTomada;
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
