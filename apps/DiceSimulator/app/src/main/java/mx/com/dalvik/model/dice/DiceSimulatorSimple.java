package mx.com.dalvik.model.dice;

public class DiceSimulatorSimple extends DiceSimulator implements IDiceSimulator{
	
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
	
	
}
