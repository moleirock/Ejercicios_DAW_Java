package boletin_1;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
//		2. Pedir el radio de un c�rculo y calcular su �rea. A=PI*r^2
		Scanner sc=new Scanner(System.in);
		double r;
		System.out.println("Introduce el radio del c�rculo y te dir� su �rea");
		r=sc.nextDouble();
		if(r>0) {
			System.out.println("El �rea del c�rculo es : " + (Math.PI*Math.pow(r,2)));
		}else {
			System.out.println("El dato introducido es err�neo");
			}
		sc.close();
	}
	
}
