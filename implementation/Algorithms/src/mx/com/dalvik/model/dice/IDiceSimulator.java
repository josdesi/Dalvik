package mx.com.dalvik.model.dice;

public interface IDiceSimulator {
	
	public int[] simulate( int N );
	public void showFaces(int[] faces, Logger logger);
}
