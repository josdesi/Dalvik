package mx.com.dalvik.designpatterns.abstractfactory;

public class FabricaVehiculoGasolina extends FabricaVehiculo {

	@Override
	public Automovil createAutomovil(String modelo, String color, int potencia, double espacio) {
		// TODO Auto-generated method stub
		return new AutomovilGasolina( modelo, color, potencia, espacio );
	}

	@Override
	public Avion createAvion(String modelo, String color, int potencia) {
		// TODO Auto-generated method stub
		return new AvionGasolina( modelo, color, potencia );
	}

}
