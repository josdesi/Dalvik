package mx.com.dalvik;

public class Rabbit {
	
	public int count( int n ) {
//		return 2*n;
		// n = n+2
		return n+=2;
	}
	
	// No usar multiplicaci�n
	// No usar ciclos
	// Recursividad
	public int countPlus( int n ) {
		
		// Condici�n para detenerse
		if( n < 1 )
			return 0;
		
		else
			// Siguiente iteraci�n
			return countPlus( n - 1 ) + 2;
	}
}
