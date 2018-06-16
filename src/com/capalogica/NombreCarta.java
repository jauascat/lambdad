package com.capalogica;

public enum NombreCarta {

	UNO,
	DOS,
	TRES,
	CUATRO,
	CINCO,
	SEIS,
	SIETE,
	OCHO,
	NUEVE,
	DIEZ,
	JOTA,
	QUINA,
	KA,
	AS;
	
	public static int getValor(NombreCarta vector)
	{
		switch(vector)
		{
		case UNO: 		return 1;
		case DOS: 		return 2;
		case TRES: 		return 3;
		case CUATRO: 	return 4;
		case CINCO: 	return 5;
		case SEIS: 		return 6;
		case SIETE: 	return 7;
		case OCHO: 		return 8;
		case NUEVE: 	return 9;
		case DIEZ: 		return 10;
		case JOTA: 		return 10;
		case QUINA: 	return 10;
		case KA: 		return 10;
		case AS: 		return 10;
		default: 		return -1;
		}
	}
}
