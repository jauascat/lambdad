package com.capalogica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;

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
	
	public void darManoCambio(ArrayList<Carta> mano)
	{
		mano.clear();
		mano.add(naipe.tomarCartaDelNaipe());
		mano.add(naipe.tomarCartaDelNaipe());
		mano.add(naipe.tomarCartaDelNaipe());
		mano.add(naipe.tomarCartaDelNaipe());
	}
	
	public void cortarSiTipoCartaEsTipo(ListIterator<Carta> iterador, Carta carta, NombreCarta tipo)
	{
		if(carta.getNombreCarta() == tipo)
		{
			iterador.remove();
		}
	}
}
