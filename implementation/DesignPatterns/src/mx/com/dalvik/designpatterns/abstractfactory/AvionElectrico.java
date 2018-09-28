package mx.com.dalvik.designpatterns.abstractfactory;

public class AvionElectrico extends Avion {

	public AvionElectrico(String modelo, String color, int potencia) {
		super(modelo, color, potencia);
	}

	@Override
	public void mostrarCaracteristicas() {
		System.out.println( toString() );
		
	}

	@Override
	public String toString() {
		return "AvionElectrico [modelo=" + modelo + ", color=" + color + ", potencia=" + potencia + "]";
	}
	

}
