package boletin_1;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
//		2. Pedir el radio de un círculo y calcular su área. A=PI*r^2
		Scanner sc=new Scanner(System.in);
		double r;
		System.out.println("Introduce el radio del círculo y te diré su área");
		r=sc.nextDouble();
		if(r>0) {
			System.out.println("El área del círculo es : " + (Math.PI*Math.pow(r,2)));
		}else {
			System.out.println("El dato introducido es erróneo");
			}
		sc.close();
	}
	
}
