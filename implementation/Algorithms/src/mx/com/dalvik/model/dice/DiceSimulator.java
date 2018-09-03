package mx.com.dalvik.model.dice;

public class DiceSimulator {
	
	public void showFaces(int[] faces, Logger logger) {
		for(int i = 0; i< faces.length; i++ )
			logger.print( i, ""+faces[ i ]+"");
		
	}

}
