package mx.com.dalvik.designpatterns.abstractfactory;

public class AutomovilElectrico extends Automovil {

	public AutomovilElectrico(String modelo, String color, int potencia, double espacio) {
		
		super(modelo, color, potencia, espacio);
		
	}

	@Override
	public void mostrarCaracteristicas() {
		System.out.println("AutomovilElectrico modelo=" + modelo + ", color=" + color + ", potencia=" + potencia + ", espacio=" + espacio );
		
	}

}
