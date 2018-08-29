package mx.com.dalvik.model;

import java.util.Arrays;

public class BigONotation {
	public void test() {
		System.out.println("Big O Notation");
		System.out.println();
		
		int [] list = new int[] { 15, 20 ,32, 41, 100 };
		int n = list.length;
		
		// O(1)
		System.out.print("\nO(1):");
		System.out.print( list[ 2 ] );
		
		// O(n)
		System.out.print("\nO(n):");
		for( int i = 0; i< n; i++ )
			System.out.print( list[ i ]+"," );
		
		// O(n^2)
		System.out.print("\nO(n^2):");
		for( int i = 0; i< n; i++ )
			for( int j = 0; j< n; j++ )
				System.out.print( list[ i ] + list[ j ]+ "," );
		
		// O(n^3)
		System.out.print("\nO(n^3):");
		for( int i = 0; i< n; i++ )
			for( int j = 0; j< n; j++ )
				for( int k = 0; k< n; k++ )
					System.out.print( list[ i ] + list[ j ]+ "," );	
		
		// O(log n)
		System.out.print("\nO(log n): ");
		int num = Arrays.binarySearch( list, 100 );
		System.out.println( num );
		
		
		
	}
}
