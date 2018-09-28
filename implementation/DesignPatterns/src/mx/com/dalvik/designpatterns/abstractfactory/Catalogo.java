package mx.com.dalvik.designpatterns.abstractfactory;

import java.util.Scanner;

public class Catalogo {
	
	public static void main(String[] args) {
		
		int nAutos = 3;
		int nAviones = 2;
		
		
		// Fabricas
		FabricaVehiculo fabrica;
		Automovil[] autos = new Automovil[ nAutos ];
		Avion[] aviones = new Avion[ nAviones ];
		
		
		
		// Menu
		System.out.print("Vehiculos electricos (1) o gasolina(2): ");
		Scanner reader = new Scanner( System.in );
		String eleccion = reader.next();
		if( eleccion.equals("1") )
			fabrica = new FabricaVehiculoElectrico();
		else
			fabrica = new FabricaVehiculoGasolina();
		
		
		
		
		// Creacion de vehiculos
		for( int i = 0; i< nAutos; i++ )
			autos[ i ] = fabrica.createAutomovil("estandar", "amarillo", 7, 3.2*(i+1) );
		
		for( int i = 0; i< nAviones; i++ )
			aviones[ i ] = fabrica.createAvion("comercial", "plata", 4*(i+1) );
		
		
		
		
		// Imprimir caracteristicas
		for( Automovil auto: autos )
			auto.mostrarCaracteristicas();
		
		for( Avion avion: aviones )
			avion.mostrarCaracteristicas();
		
	}
}
