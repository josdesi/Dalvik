package mx.com.dalvik.designpatterns.abstractfactory;

public class AutomovilGasolina extends Automovil {

	public AutomovilGasolina( String modelo, String color, int potencia, double espacio) {
		super(modelo, color, potencia, espacio);
	}

	@Override
	public void mostrarCaracteristicas() {

		System.out.println("AutomovilGasolina modelo=" + modelo + ", color=" + color + ", potencia=" + potencia + ", espacio=" + espacio );
		
	}
	

}
