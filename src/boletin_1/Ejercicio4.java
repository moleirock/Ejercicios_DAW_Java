package boletin_1;

import java.util.*;

public class Ejercicio4 {

	public static void main(String[] args) {
//		4. Pedir dos números y decir si son iguales o no
		Scanner sc = new Scanner(System.in);
		double a, b;
		System.out.println("Introduce dos números y te diré si son iguales");
		a = sc.nextDouble();
		b = sc.nextDouble();
		System.out.println(a == b ? "Son iguales" : "No son iguales");
		sc.close();
	}

}
