package boletin_1;

import java.util.Scanner;

public class Ejercicio13 {

	public static void main(String[] args) {
//		13. Pedir un número entre 0 y 9.999, decir si es capicúa.
		Scanner sc = new Scanner(System.in);
		int num,control,inverso;
		inverso=0;
		System.out.println("Introduce un número y te drié si es capicúa");
		num = sc.nextInt();
		if(num<0) {
			num*=-1;
		}
		control=num;
		
		while(num!=0) {
			inverso=inverso*10+(num%10);
			num/=10;
		}
		if(control==inverso) {
			System.out.println("Es capicúa");
		}else {
			System.out.println("No es capicúa");
		}
		sc.close();
	}

}
