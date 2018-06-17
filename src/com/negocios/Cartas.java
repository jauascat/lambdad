package com.negocios;

import com.enumeradores.NombreCarta;

public class Cartas {

	public static boolean isIgualitasCartas(Carta carta1, Carta carta2)
	{
		if(carta1.getNombreCarta() == carta2.getNombreCarta() &&
				carta1.getPaloCarta() == carta2.getPaloCarta())
			return true;
		else
			return false;
	}
	
	public static boolean isNombreIgual(Carta carta1, Carta carta2)
	{
		if(carta1.getNombreCarta() == carta2.getNombreCarta())
			return true;
		else
			return false;
	}
	
	public static boolean isNombreIguala21yMedio(Carta carta)
	{
		if(carta.getNombreCarta() == NombreCarta.DIEZ ||
				carta.getNombreCarta() == NombreCarta.DOS)
			return true;
		else
			return false;
	}
	
	public static boolean isNombreIguala10(Carta carta)
	{
		if(carta.getNombreCarta() == NombreCarta.DIEZ)
			return true;
		else
			return false;
	}
	
	public static boolean isNombreIguala2(Carta carta)
	{
		if(carta.getNombreCarta() == NombreCarta.DOS)
			return true;
		else
			return false;
	}
	
}
