package mx.com.dalvik.model;

import java.util.HashMap;
import java.util.Map;

public class HarmlessRansomNote {
	
	/**
	 * 
	 * Execution:
	 * 		boolean res = new HarmlessRansomNote().test(
	 * 			" in text the magazine ",
	 * 			"this is magazine text in the magazine");
	 * 
	 * @param note
	 * @param magazine
	 * @return boolean
	 */
	public boolean test( String note, String magazine ) {
		
		
		Map<String, Integer> noteOccurence = getOccurences( note );
		Map<String, Integer> magazineOccurence = getOccurences( magazine );
		
		for( String key : noteOccurence.keySet() ) {
			// Si no contiene la palabra actual
			if(! magazineOccurence.containsKey(key) )
				return false;
			
			int needed = noteOccurence.get(key);
			// Si la cantidad de palabras esperadas es menor
			if( magazineOccurence.get(key) < needed )
				return false;
		}
		
		return true;
	}
	
	private Map<String, Integer> getOccurences( String str ){
		
		Map<String, Integer> occurences = new HashMap<String, Integer>();
		str = str.trim();
		
		for( String word : str.split(" ")) {
			
			
			// Si no contiene la palabra
			if( !occurences.containsKey( word ) )
				// Agregar la palabra, conteo = 1
				occurences.put( word, 1 );
			else
				// Actualiza el conteo
				occurences.put(word, occurences.get(word) + 1 );
		}
		System.out.println( occurences );
		return occurences;
	}
	
}
