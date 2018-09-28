package mx.com.dalvik.doo;

import java.util.Collection;

public class Pintor {
	
	public void pinta( Collection <Figura> figuras ){
		
		for( Figura figura: figuras ) {
			if( figura instanceof Cuadrado ) {
				pinta( (Cuadrado) figura);
			}
			else if ( figura instanceof Circulo) {
				pinta( (Circulo) figura);
			}
			else if ( figura instanceof Triangulo) {
				pinta( (Triangulo) figura);
			}
		}
	}

	private void pinta(Circulo figura) {
		System.out.println("Circulo.pinta... ");	
	}

	private void pinta(Cuadrado figura) {
		System.out.println("Cuadrado.pinta... ");
	}
	
	private void pinta(Triangulo figura) {
		System.out.println("Triangulo.pinta... ");
	}
	
}

class Figura {}
class Cuadrado extends Figura {}
class Circulo extends Figura {}
class Triangulo extends Figura {}
