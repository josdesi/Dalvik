package mx.com.dalvik.designpatterns.abstractfactory;

public abstract class Avion {
	
	 protected String modelo;
	 protected String color;
	 protected int potencia;
	 
	 
	public Avion(String modelo, String color, int potencia) {
		super();
		this.modelo = modelo;
		this.color = color;
		this.potencia = potencia;
	}
	 
	public abstract void mostrarCaracteristicas();
}
