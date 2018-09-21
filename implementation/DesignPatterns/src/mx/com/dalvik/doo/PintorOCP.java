package mx.com.dalvik.doo;

import java.util.Collection;

public class PintorOCP {
	
	public void pinta( Collection<Figura> figuras ) {
		for( Figura figura: figuras) {
			figura.pinta();
		}
	}
}

interface Figura{
	void pinta();
}

class Triangulo implements Figura{

	@Override
	public void pinta() {
		System.out.println("Triangulo.pinta... ");
		
	}
	
}

class Cuadrado implements Figura {

	@Override
	public void pinta() {
		System.out.println("Cuadrado.pinta... ");
		
	}
	
}
class Circulo implements Figura {

	@Override
	public void pinta() {
		System.out.println("Circulo.pinta... ");
		
	}
	
}
