package boletin_1;

import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
//		3. Pedir el radio de una circunferencia y calcular su longitud.L=2*PI*r.
				Scanner sc=new Scanner(System.in);
				double r;
				System.out.println("Introduce el radio del c�rculo y te dir� su per�metro");
				r=sc.nextDouble();
				if(r>0) {
					System.out.println("El �rea del c�rculo es : " + (Math.PI*2*r));
				}else {
					System.out.println("El dato introducido es err�neo");
					}
				sc.close();
	}

}
