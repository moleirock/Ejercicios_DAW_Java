package boletin_1;

import java.util.Scanner;

public class Ejercicio11 {

	public static void main(String[] args) {
//		11. Pedir un n�mero entre 0 y 9.999 y decir cuantas cifras tiene.
		Scanner sc = new Scanner(System.in);
		int num, cont;
		cont = 0;
		System.out.println("Introduce un n�mero y te dir� su longitud");
		num = sc.nextInt();
		if (num < 0) {
			num = -1 * num;
		} else if (num == 0) {
			System.out.println("El n�mero tiene 1 d�gito");
		}
		while (num > 0) {
			num = num / 10;
			cont++;
		}
		System.out.println("El n�mero tiene " + cont + " d�gitios");
		sc.close();
	}
}
