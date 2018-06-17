package com.negocios;

import com.enumeradores.NombreCarta;
import com.enumeradores.PaloCarta;
import com.exepciones.ValorCartaInvalidoException;

public class Carta {

	private NombreCarta nombre;
	private PaloCarta palo;
	private int valor;

	public Carta(NombreCarta pnombre,
				 PaloCarta ppalo,
				 int pvalor)
						 throws ValorCartaInvalidoException {
		
		if(pvalor < 1 || pvalor > 10) 
			
			throw new ValorCartaInvalidoException(String.valueOf(pvalor));
		
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
