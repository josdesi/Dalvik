package mx.com.dalvik;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DemoRegularExpression {
	
	public static void main(String[] args) {
		
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
