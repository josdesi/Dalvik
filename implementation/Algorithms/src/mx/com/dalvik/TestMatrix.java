package mx.com.dalvik;

import mx.com.dalvik.model.Matrix;

public class TestMatrix {
	
	public static void main(String[] args) {
		double [][] matrix = {{1,2},{3,4}};
		double [] vector = {1,2};
		
		Matrix matrixTest = new Matrix();
		
		double[] res = matrixTest.multiplyMatrixVector(matrix, vector);
		matrixTest.showVector( res );
	}
	
	public static void mainMatrix(String[] args) {
		
		double [][] m1 = {{1,2},{3,4}};
		double [][] m2 = {{1,2},{2,1}};
		
		
		Matrix matrix = new Matrix();
		
		double [][] res = matrix.multiply(m1, m2);
		matrix.showMatrix( res );
		
//		int a = 1;
//		a = a+1;	
//		a++;
		
		// matrix.showMatrix( matrix.multiply(m1, m2) );
		
		
	}
	
	public static void mainBigONotation (String[] args) {
		// ...
	}
	
	public static void mainWrapper(String[] args) {
		// Wrapper		
				System.out.println( Float.SIZE );
				System.out.println( Double.SIZE );
	}
}
