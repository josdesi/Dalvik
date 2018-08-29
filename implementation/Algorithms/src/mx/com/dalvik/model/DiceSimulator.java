package mx.com.dalvik.model;

public class DiceSimulator {
	
	public int[] simulate( int N ) {
		
		int [] faces = {0,0,0,0,0,0};
		int min = 1, max = 6, rnd;
		
		// Ejecuta los lanzamientos
		for(int i = 0; i<N; i++ ) {
			rnd = (int) Math.round( Math.random()*( max - min ) + min );
			faces[ rnd - 1 ]++;
		}
		
		return faces;
	}
	
	// Extender clase DiceSimulator
	public int[] optimizedSimulate( int N ) {
		int [] faces = {0,0,0,0,0,0};
		
		// ...
		
		return faces;
	}
	
	public void showFaces( int [] faces ) {
		for(int i = 0; i< faces.length; i++ )
			System.out.println( "Face( "+(i+1)+" ): " + faces[ i ] );
	}
}
