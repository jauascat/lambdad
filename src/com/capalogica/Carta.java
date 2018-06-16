package com.capalogica;

public class Carta {

	private NombreCarta nombre;
	private PaloCarta palo;
	private int valor;

	public Carta(NombreCarta pnombre,
				 PaloCarta ppalo,
				 int pvalor)
						 throws ValorCartaInvalidoException {
		nombre = pnombre;
		palo = ppalo;
		valor = pvalor;
		
		if(pvalor < 1 || pvalor > 10) 
			
			throw new ValorCartaInvalidoException(valor+" es un valor de carta invalido");
	}
	
	@Override
	public boolean equals(Object vector)
	{
		Carta comparado = (Carta) vector;
		
		if(this.getValor() == comparado.getValor())
			return true;
		
		else	
			return false;
	}

	public NombreCarta getNombre() {
		return nombre;
	}

	public PaloCarta getPalo() {
		return palo;
	}

	public int getValor() {
		return valor;
	}

}
