package boletin_1;

import java.util.Scanner;

public class Ejercicio5 {

	public static void main(String[] args) {
//		5. Pedir un n�mero e indicar si es positivo o negativo.

		Scanner sc = new Scanner(System.in);
		double a;
		System.out.println("Introduce un n�mero y te dir� si es positivo o negativo");
		a = sc.nextDouble();
		System.out.println(a==0?"El n�mero es 0":a>0?"El n�mero es positivo":"El n�mero es negativo");
		sc.close();
	}

}
