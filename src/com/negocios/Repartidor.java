package com.negocios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;

import com.enumeradores.NombreCarta;

public class Repartidor {

	Naipe naipe;
	
	public Repartidor() {
		naipe = new Naipe();
		this.barajarNaipe();
	}
	
	public void darCarta(Jugador jugadorRecipiente)
	{
		jugadorRecipiente.recibirCarta(naipe.tomarCartaDelNaipe());
	}
	
	public Naipe getNaipe()
	{
		return naipe;
	}
	
	public void barajarNaipe()
	{
		Collections.shuffle(naipe.getCartas());
	}
	
	public void darCambioMano21(ArrayList<Carta> mano)
	{
		mano.clear();
		mano.add(naipe.tomarCartaDelNaipe());
		mano.add(naipe.tomarCartaDelNaipe());
		mano.add(naipe.tomarCartaDelNaipe());
		mano.add(naipe.tomarCartaDelNaipe());
	}
	
	public void saltearCartas(ArrayList<Jugador> jugadores, int cantidadCartas)
	{
		for(int i = 1; i <= cantidadCartas; i++)
			
			for(Jugador jugador : jugadores)
			
				this.darCarta(jugador);
	}
}
