package mx.com.dalvik;

import mx.com.dalvik.model.HarmlessRansomNote;

public class Test {

	public static void main(String[] args) {
		
		boolean res = new HarmlessRansomNote().test(
				"in text the magazine", 
				"this is magazine text in the magazine");
		System.out.println( res );
	}

}
