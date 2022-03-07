package boletin_4;

import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
//		4. Dibuja un cuadrado de n elementos de lado utilizando *.
		
		int n;
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Introduce el lado del cuadrado");
		n=sc.nextInt();
		while(n<1) {
			System.out.println("El lado tiene que ser mayor que 0");
			n=sc.nextInt();
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print("* ");
			}
			System.out.println("");
		}
		sc.close();
		
		
	}

}
