package mx.com.dalvik.designpatterns.abstractfactory;

public abstract class FabricaVehiculo {
	
	public abstract Automovil createAutomovil( String modelo, String color, int potencia, double espacio );
	public abstract Avion createAvion( String modelo, String color, int potencia );
}
