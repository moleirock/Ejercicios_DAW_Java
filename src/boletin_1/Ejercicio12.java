package boletin_1;

import java.util.Scanner;

public class Ejercicio12 {

	public static void main(String[] args) {
//		12. Pedir un número entre 0 y 9.999 y mostrarlo con las cifras al revés.
		Scanner sc = new Scanner(System.in);
		int num;
		System.out.println("Introduce un número y te lo mostraré al revés");
		num = sc.nextInt();
		while(num!=0) {
			System.out.print(num%10);
			num/=10;
		}
		sc.close();
	}

}
