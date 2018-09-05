package mx.com.dalvik;

public class Test {

	public static void main(String[] args) {
		
//		System.out.println("Exam");
		
		
		
		
//		for( int k = 0; k< 10; k++ ) {
//			System.out.print( k+"," );
//		}
//		 0,1,...,9,
		
		
		
		
		
		
		
		
		
//		for( int k = 1; k<= 10; k++ ) {
//			System.out.print( k+"," );
//		}
//		 1,...,10,
		
		
		
		
		
		
		
//		int num = 0;
//		for( int j = 5, k = 0; k<10; k++ ) {
//			// num = num + j;
//			// num = num + 5;
//			num += j;
//		}
//		// 50
//		System.out.println( "num: " + num );
		
		
		
//		int num = 0;
//		for( int j = 5, k= 0; k <= 4; k+=2 ) {
//			
//			// num += j --> num = num + j
//			// num = num + num + j;
//			// num = num + num + 5;
//			num += num + j;
//		}
//		// 10
//		// 30
//		System.out.println("num: "+( num - 5 ) );
	
		// ¿Cuál es la salida?
		// ¿Cuál es la variable que no cambia?
		// ¿Cuál es la variable que controla al ciclo?
		// ¿Cuántas veces se ejecuta el ciclo?
		// ¿Hay operaciones/instrucciones para expandir?
		
//		double sum = 0;
//		for( double d = 0; d < 10; sum += sum + d ) {
//			d += 0.1;
//			
//			// sum = sum + sum + d
//		}
//		// 102.3
//		// num: 5.070602400912918E29
//		System.out.println("num: "+sum );
		
		int ears = new Rabbit().countPlus( 3 );
		System.out.println( ears );
		
	}

}
