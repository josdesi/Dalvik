package mx.com.dalvik.designpatterns.abstractfactory;

public class AvionGasolina extends Avion {

	public AvionGasolina(String modelo, String color, int potencia) {
		super(modelo, color, potencia);
	}

	@Override
	public void mostrarCaracteristicas() {
		System.out.println( toString() );
		
	}

	@Override
	public String toString() {
		return "AvionGasolina [modelo=" + modelo + ", color=" + color + ", potencia=" + potencia + "]";
	}

}
