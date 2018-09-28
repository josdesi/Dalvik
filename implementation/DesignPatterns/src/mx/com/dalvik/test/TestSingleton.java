package mx.com.dalvik.test;

import mx.com.dalvik.creational.Singleton;

public class TestSingleton {
	
	
	public static void main(String[] args) {
		
		// Mecanismo clasico de instanciación está prohibido
		// Singleton s1 = new Singleton();
		
		Singleton s1 = Singleton.getInstance();
		
		System.out.println( "s1: "+ s1.getInfo() );
		
		Singleton s2 = Singleton.getInstance();
		System.out.println( "s2: "+ s2.getInfo() );
		
		s2.setInfo("New info");
		
		System.out.println( "s2: "+ s2.getInfo() );
		System.out.println( "s1: "+ s1.getInfo() );
	}
}
