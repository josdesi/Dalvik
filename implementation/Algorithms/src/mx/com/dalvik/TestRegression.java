package mx.com.dalvik;

import mx.com.dalvik.model.GaussianElimination;

public class TestRegression {
	
	public static void main(String[] args) {
		
		
		double[][] points = {{1,56.5},{5,113},{20,181}};
		int N = points.length;
		
		double[][] coefficients = new double[ N ][ N ];
		double [] vectorfx = new double[ N ];
		
		double x, fx;
		
		x = points[ 0 ][ 0 ];
		fx = points[ 0 ][ 1 ];
		vectorfx[ 0 ] = fx;
		coefficients[ 0 ][ 0 ] = Math.pow(x,0);
		coefficients[ 0 ][ 1 ] = Math.pow(x,1);
		coefficients[ 0 ][ 2 ] = Math.pow(x,2);
		
		
		x = points[ 1 ][ 0 ];
		fx = points[ 1 ][ 1 ];		
		vectorfx[ 1 ] = fx;
		coefficients[ 1 ][ 0 ] = Math.pow(x,0);
		coefficients[ 1 ][ 1 ] = Math.pow(x,1);
		coefficients[ 1 ][ 2 ] = Math.pow(x,2);
		
		
		x = points[ 2 ][ 0 ];
		fx = points[ 2 ][ 1 ];		
		vectorfx[ 2 ] = fx;
		coefficients[ 2 ][ 0 ] = Math.pow(x,0);
		coefficients[ 2 ][ 1 ] = Math.pow(x,1);
		coefficients[ 2 ][ 2 ] = Math.pow(x,2);
		
		
		System.out.println();
		int NN = coefficients.length;
		for( int i = 0; i< NN; i++ ) {
			for( int j =0; j < NN; j++ ) {
				System.out.print( coefficients[i][j]+" " );
			}
			System.out.println();
		}
		
		System.out.println();
		
		System.out.print( "vectorFx: ");
		for( int i = 0; i< NN; i++ ) {
			System.out.print( vectorfx[ i ]+" ");
		}
		
		
		
		System.out.println();
		System.out.println("===============================");
		System.out.println("Gauss Elimination:");
		
		GaussianElimination gauss = new GaussianElimination();
		double [] solve = gauss.solve(coefficients, vectorfx);
		
		System.out.println("\n\nVector solution:");
		for( int i = 0; i< solve.length; i++ )
			System.out.println( solve[ i ] );
		
	}
}
