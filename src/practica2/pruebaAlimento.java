package practica2;

import practica2.Alimento.Niveles;

public class pruebaAlimento {

	public static void main(String[] args) {
		Alimento manzana = new Alimento("Manzana",30,60,10,true,Niveles.ALTO,Niveles.MEDIO);
		
		manzana.muestrAlimento();
		System.out.println(manzana.calculaContenidoEnegertico());
		System.out.println(manzana.esDietetico());
		System.out.println(manzana.recomendadoDeportistas());

	}

}
