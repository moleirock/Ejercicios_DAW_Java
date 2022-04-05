package practica2;

import practica2.Alimento.Niveles;

public class PruebaComprobaciones {

	public static void main(String[] args) {
		
		System.out.println(Comprobaciones.esSimetrico("ana"));
		System.out.println(Comprobaciones.esCapicua(232));
		System.out.println(Comprobaciones.esPrimo(-2));
		System.out.println(Comprobaciones.esAntiguo(2002));
		System.out.println(Comprobaciones.esPar(0));
		System.out.println(Comprobaciones.esTriangulo(3,1,4));
		System.out.println(Comprobaciones.estaIntervalo(2, 3, -1));
		System.out.println(Comprobaciones.esPositivo(2));
		System.out.println(Comprobaciones.esBisiesto(1800));

		
		
		
		
	}

}
