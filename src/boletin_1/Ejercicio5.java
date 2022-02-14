package boletin_1;

import java.util.Scanner;

public class Ejercicio5 {

	public static void main(String[] args) {
//		5. Pedir un número e indicar si es positivo o negativo.

		Scanner sc = new Scanner(System.in);
		double a;
		System.out.println("Introduce un número y te diré si es positivo o negativo");
		a = sc.nextDouble();
		System.out.println(a==0?"El número es 0":a>0?"El número es positivo":"El número es negativo");
		sc.close();
	}

}
