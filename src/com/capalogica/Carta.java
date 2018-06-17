package com.capalogica;

public class Carta {

	private NombreCarta nombre;
	private PaloCarta palo;
	private int valor;

	public Carta(NombreCarta pnombre,
				 PaloCarta ppalo,
				 int pvalor)
						 throws ExceptionValorCartaInvalido {
		
		if(pvalor < 1 || pvalor > 10) 
			
			throw new ExceptionValorCartaInvalido(String.valueOf(pvalor));
		
		nombre = pnombre;
		palo = ppalo;
		valor = pvalor;
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

	public NombreCarta getNombreCarta() {
		return nombre;
	}

	public PaloCarta getPaloCarta() {
		return palo;
	}

	public int getValor() {
		return valor;
	}

}
