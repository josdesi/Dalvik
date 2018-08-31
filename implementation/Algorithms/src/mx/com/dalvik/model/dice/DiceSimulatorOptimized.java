package mx.com.dalvik.model.dice;

public class DiceSimulatorOptimized extends DiceSimulator implements IDiceSimulator {


	@Override
	public int[] simulate(int N) {
		
		int [] faces = {0,0,0,0,0,0};
		int min = 1, max = 7, rnd;
		
		// Ejecuta los lanzamientos
		for(int i = 0; i<N; i++ ) {
			rnd = (int) Math.floor( Math.random()*( max - min ) + min );
			faces[ rnd - 1 ]++;
		}
		
		return faces;
	}



}
