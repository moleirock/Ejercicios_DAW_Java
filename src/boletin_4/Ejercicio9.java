package boletin_4;

import java.util.Scanner;

public class Ejercicio9 {

	public static void main(String[] args) {
//		9. Crear un programa que lea por teclado una tabla de 10 números enteros y la desplace una
//		posición hacia abajo (el último pasa a ser el primero).

		Scanner sc = new Scanner(System.in);
		int[] array = new int[10];
		int aux;
				
		for (int i = 0; i < array.length; i++) {
			array[i] = sc.nextInt();
		}
		
		aux=array[9];
		array[9]=array[0];
		array[0]=aux;
		
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		sc.close();
	}

}
