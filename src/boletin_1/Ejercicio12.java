package boletin_1;

import java.util.Scanner;

public class Ejercicio12 {

	public static void main(String[] args) {
//		12. Pedir un n�mero entre 0 y 9.999 y mostrarlo con las cifras al rev�s.
		Scanner sc = new Scanner(System.in);
		int num;
		System.out.println("Introduce un n�mero y te lo mostrar� al rev�s");
		num = sc.nextInt();
		while(num!=0) {
			System.out.print(num%10);
			num/=10;
		}
		sc.close();
	}

}
