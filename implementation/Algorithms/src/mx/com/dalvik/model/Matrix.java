package mx.com.dalvik.model;

public class Matrix {
	
	
	public double [][] multiply( double [][] m1, double [][] m2){
		
		int N = m1.length;
		double [][] result = new double[ N ][ N ];
		
		// O(n^3)
		for( int i = 0; i < N; i++ ) {
			for(  int j = 0; j < N; j++ ) {
				for( int k = 0; k < N; k++ ) {
					result[ i ][ j ] += m1[ i ][ k ] * m2[ k ][ j ];
				}
			}
		}
		
		return result;
	}
	
	
	public double [] multiplyMatrixVector( double [][] matrix, double [] vector ) {
		
		double [] res = new double[ vector.length ];
		
		for( int i = 0; i< matrix.length; i++ ) {
			for( int j = 0; j< vector.length; j++ ) {
				res[ i ] += matrix[ i ][ j ] * vector[ j ];
			}
		}
		
		return res;
	}
	
	
	public void showVector( double [] vector ) {
		for( int i = 0; i < vector.length; i++ )
			System.out.println( vector[ i ] );
	}
	
	public void showMatrix( double [][] m ) {
		
		int N = m.length;
		
		System.out.println();
		for(int i = 0; i< N; i++ ) {
			for( int j = 0; j< N; j++ ) {
				System.out.print( m[ i ][ j ]+ " ");
			}
			System.out.println();
		}
	}
}
