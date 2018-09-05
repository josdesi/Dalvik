package mx.com.dalvik;

import mx.com.dalvik.model.dice.IDiceSimulator;

import java.text.NumberFormat;

import mx.com.dalvik.model.GaussianElimination;
import mx.com.dalvik.model.dice.DiceSimulatorOptimized;
import mx.com.dalvik.model.dice.DiceSimulatorSimple;
import mx.com.dalvik.model.dice.Logger;

public class Test {

	
	public static void main(String[] args) {
		double [][] matrix = {	{1,1},
								{0.035,0.05}};
		double [] vector = {24000,930};
		
		
		
		
		GaussianElimination gauss = new GaussianElimination();
		double [] solve = gauss.solve(matrix, vector);
		
		System.out.println("\n\nVector solution:");
		for( int i = 0; i< solve.length; i++ )
			System.out.println( solve[ i ] );
		
	}
	
	
	public static void mainNumberPrecision(String[] args) {
		
		double num = 10;
		double sum = 0;
		
		for( int i = 0; i< 100; i++ )
			sum += 0.1;
	
		System.out.println( num == sum );
		System.out.println( sum );
		
		double epsilon = 0.0000000001;
		
		if( Math.abs( sum - num ) < epsilon )
			System.out.println("They are equal");
		else
			System.out.println("Not equal");
		
	}
	
	
	public static void mainNumberFormat(String[] args) {
		
		// IEEE 754
		double num = 0.8;
		double num2 = 0.4;
		double res = num + num2;
		
		System.out.println( res );
		
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(3);
		System.out.println("res: "+ nf.format( res ));
		
	}
	
	
	
	public static void mainDiceSimulator(String[] args) {
		
		IDiceSimulator dice = new DiceSimulatorOptimized();
		
		dice.showFaces( dice.simulate( 100000 ), new Logger() {

			@Override
			public void print(Integer i, String face) {
				
				System.out.println( "Face( "+(i+1)+" ): " + face);
			}
			
		});

	}

}
