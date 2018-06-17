package com.capalogica;

public class Repartidor {

	Naipe naipe;
	
	public Repartidor() {
		naipe = new Naipe();
		naipe.barajarse();
	}
	
	public void darCarta(Jugador jugadorRecipiente)
	{
		jugadorRecipiente.recibirCarta(naipe.tomarCartaDelNaipe());
	}
	
	public Naipe getNaipe()
	{
		return naipe;
	}
}
