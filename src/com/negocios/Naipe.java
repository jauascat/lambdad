package com.negocios;

import java.util.ArrayList;
import java.util.Collections;

import com.enumeradores.NombreCarta;
import com.enumeradores.PaloCarta;
import com.exepciones.ValorCartaInvalidoException;

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
	
	public Carta tomarCartaDelNaipe()
	{
		Carta cartaTomada = cartas.get(0);
		cartas.remove(0);
		
		return cartaTomada;
	}

	public ArrayList<Carta> getCartas()
	{
		return cartas;
	}
}
