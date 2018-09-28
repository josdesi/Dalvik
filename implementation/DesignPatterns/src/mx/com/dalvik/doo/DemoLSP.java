package mx.com.dalvik.doo;

import java.sql.Timestamp;
import java.util.Date;

public class DemoLSP {
	
	public static void main(String[] args) {
		
		Date date = new Date();
		Timestamp ts = new Timestamp( date.getTime() );
		
		System.out.println( date.equals(ts) );
		System.out.println( ts.equals(date) );
		
		System.out.println("...");
	}
	
	
	public static void _main(String[] args) {
		 
		
		
		
		// No se cumple LSP
		 Integer [] array = { 1,2,3,4,5 };
		 Object [] arrayObjects = array;
		 
		 arrayObjects[0] = "Hola";
		 
		 System.out.println("...");
	}
	
	
}
