package mx.com.dalvik;

public class Rabbit {
	
	public int count( int n ) {
//		return 2*n;
		// n = n+2
		return n+=2;
	}
	
	// No usar multiplicación
	// No usar ciclos
	// Recursividad
	public int countPlus( int n ) {
		
		// Condición para detenerse
		if( n < 1 )
			return 0;
		
		else
			// Siguiente iteración
			return countPlus( n - 1 ) + 2;
	}
}
