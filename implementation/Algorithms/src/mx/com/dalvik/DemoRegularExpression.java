package mx.com.dalvik;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DemoRegularExpression {
	
	
	public static void main(String[] args) {
		
		String input = "www.?regular.com";
		
		// Comprobar que no comience con un punto o @
		Pattern pattern = Pattern.compile("^.|^@");
		Matcher matcher  = pattern.matcher( input );
		
		if( matcher.find() )
			System.out.println("No debe empezar con un punto o @");
		
		// No empezar por www
		pattern = Pattern.compile("^www.");
		matcher  = pattern.matcher( input );
		
		if( matcher.find() )
			System.out.println("No debe empezar con www.");
		
		
		// Debe tener un @
		pattern = Pattern.compile("@");
		matcher  = pattern.matcher( input );
		
		if( !matcher.find() )
			System.out.println("La cadena no tiene @");
	}
	
	public static void _main(String[] args) {
		
		String str = "aybexampleaaaabexampleabexampleb";
		// String regex = "a*b";
		// String regex = "a+b";
		// String regex = "a?b";
		//String regex = "a{3}";
		//String regex = "a{1,3}";
		// String regex = "ab$";
		String regex = "a.b";
		Pattern patron = Pattern.compile( regex );
		Matcher matcher = patron.matcher( str );
		
		String res =  matcher.replaceAll("-");
	
		System.out.println( res );
		
	}
}
