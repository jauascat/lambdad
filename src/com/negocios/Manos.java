package com.negocios;

import java.util.ArrayList;
import java.util.ListIterator;

import com.enumeradores.NombreCarta;
import com.exepciones.ValorCartaInvalidoException;

public class Manos {
	
	public static boolean isMerecedorCambioMano21(ArrayList<Carta> mano)
	{
		ArrayList<NombreCarta> referentesComparacion = new ArrayList<>();
		
		referentesComparacion.add(NombreCarta.TRES);
		referentesComparacion.add(NombreCarta.JOTA);
		referentesComparacion.add(NombreCarta.QUINA);
		referentesComparacion.add(NombreCarta.KA);
		
		return isIguales(mano, referentesComparacion);
	}
	
	public static boolean is21yMedio(ArrayList<Carta> mano)
	{
		ArrayList<NombreCarta> referentesComparacion = new ArrayList<>();
		
		referentesComparacion.add(NombreCarta.DOS);
		referentesComparacion.add(NombreCarta.DIEZ);
		
		return isIguales(mano, referentesComparacion);
	}
	
	public static boolean isComodin21(ArrayList<Carta> mano)
	{
		ArrayList<NombreCarta> referentesComparacion = new ArrayList<>();
		
		referentesComparacion.add(NombreCarta.SIETE);
		referentesComparacion.add(NombreCarta.NUEVE);
		
		return isIguales(mano, referentesComparacion);
	}
	
	public static void cortarSiTipoCartaEsTipo(
			ListIterator<NombreCarta> nombreIterador,
			NombreCarta tipoCarta,
			ListIterator<Carta> cartaIterador,
			Carta carta)
	{
		if(carta.getNombreCarta() == tipoCarta)
		{
			nombreIterador.remove();
			cartaIterador.remove();
		}
	}

	public static boolean isIguales(ArrayList<Carta> mano, ArrayList<NombreCarta> referentesComparacion)
	{
		ArrayList<Carta> clonMano = new ArrayList<>();
		
		//clona la mano porque el analisis destruye la muestra
		for(Carta carta : mano)
		{
			try {
				clonMano.add(new Carta(carta.getNombreCarta(), carta.getPaloCarta(), carta.getValor()));
				
			} catch (ValorCartaInvalidoException e) {
				
				e.printStackTrace();
			}
		}
		
		//sale si niquiera tiene las mismas cartas que el referente
		if(mano.size() != referentesComparacion.size()) return false;
		else
		{
			//recorre la (clon)mano del jugador con recorrido de referentes anidado
			ListIterator<NombreCarta> nombreIterador = null;
			ListIterator<Carta> manoIterador = clonMano.listIterator();
			while(manoIterador.hasNext())
			{
				Carta carta = manoIterador.next();
				
				nombreIterador = referentesComparacion.listIterator();
				while(nombreIterador.hasNext())
				{
					NombreCarta nombreCarta = nombreIterador.next();
					Manos.cortarSiTipoCartaEsTipo(nombreIterador, nombreCarta, manoIterador, carta);
				}
			}
			//si quedaron elementos en manoIterador o en nombreIterador entonces las cartas no son iguales
			if(manoIterador.hasPrevious() || nombreIterador.hasPrevious()) return false;
			else return true;
		}
	}
	
	public static int contarPuntos21Normal(ArrayList<Carta> mano)
	{
		int puntaje = 0;
		for(Carta carta : mano)
		{
			puntaje += carta.getValor();
		}
		return puntaje;
	}

}
