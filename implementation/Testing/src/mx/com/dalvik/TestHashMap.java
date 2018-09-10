package mx.com.dalvik;

import java.util.HashMap;
import java.util.Map;

public class TestHashMap {
	
	public void initHash() {
		
		Map<String, String> hashMap = new HashMap<String, String>();
		
		hashMap.put("nombre", "Roberto");
		hashMap.put("edad", "22");
		hashMap.put("escolaridad", "Lic. Inf. Admin.");
		
		
		String data ="";
		data += hashMap.get("nombre");
		data += "\n";
		data += hashMap.get("edad");
		data += "\n";
		data += hashMap.get("escolaridad");
		data += "\n";
		
		
		
//		System.out.println( data );
		
		
		
		Map<String, Vehiculo> lista = new HashMap<String, Vehiculo>();
		
		lista.put("S056", new Vehiculo("Chevrolet","Verde") );
		lista.put("S085", new Vehiculo("Ford","Gris") );
		lista.put("S015", new Vehiculo("Nissan","Rojo") );
		lista.put("S041", new Vehiculo("Suzuki","Amarillo") );
		
		System.out.println( lista.get("S085").getMarca() );
		Vehiculo v = lista.get("S015");
		System.out.println( v );
		System.out.println();
		
		
		for( String clave : lista.keySet() ) {
			System.out.println( lista.get( clave ) );
		}
		
		
		
		
	}
	
	class Vehiculo {
		
		private String marca;
		private String color;
		
		
		public Vehiculo() {
			
		}
		
		
		public Vehiculo(String marca, String color) {
			super();
			this.marca = marca;
			this.color = color;
		}
		
		
		public String getMarca() {
			return marca;
		}
		
		public void setMarca(String marca) {
			this.marca = marca;
		}
		
		public String getColor() {
			return color;
		}
		
		public void setColor(String color) {
			this.color = color;
		}
		
		@Override
		public String toString() {
			return "Vehiculo [marca=" + marca + ", color=" + color + "]";
		}
		
		
		
	}
	
	public static void main(String[] args) {
		new TestHashMap().initHash();
	}
}
