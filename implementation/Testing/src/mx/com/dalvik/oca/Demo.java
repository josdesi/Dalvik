package mx.com.dalvik.oca;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Demo {
	
	
	public static void main(String[] args) {
		
		int x = 1;
		while( checkAndIncrement( x ) ) {
			System.out.println( x );
		}
	}
	
	
	
	
	private static boolean checkAndIncrement( int x ) {
		
		if( x < 5 ) {
			x++;
			return true;
			
		} else
			return false;
		
	}




	public static void ______main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("A");
		list.add("D");
		
		List<String> list2 = new ArrayList<>();
		list2.add("B");
		list2.add("C");
		
		list.addAll(0, list2 );
		
		// A,D,B,C
		System.out.println( list );
	}
	
	public static void ___main(String[] args) {
		
		LocalDate newYear = LocalDate.of( 2018, 1, 1);
		LocalDate christmas = LocalDate.of( 2018, 12, 25);
		
		boolean flag1 = newYear.isAfter(christmas);
		boolean flag2 = newYear.isBefore(christmas);
		
		System.out.println( flag1 +":"+ flag2 );
		
	}
	
	public static void __main(String[] args) {
		
		String str = "java";
		StringBuilder sb = new StringBuilder("java");
		
		System.out.println( str.equals( sb.toString() ) +":" + sb.equals(str) );
		
		// false:true
	}
	
	public static void _main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		// List<String> list = new List<String>();
		
		
		//List<>
		//List<String> [R]
		//ArrayList<String>[R]
		//ArrayList<>
		
		
		System.out.println("...");
	}
}
