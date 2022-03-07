package boletin_1;

import java.util.Scanner;

public class Ejercicio19 {

	public static void main(String[] args) {
//		19. Pedir dos fechas y mostrar el número de días que hay de diferencia. Suponiendo todos los
//		meses de 30 días.
		
		int dia1,dia2,mes1,mes2,anho1,anho2,total;
		total=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduce la primera fecha en este orden dd-mm-aaaa");
		dia1=sc.nextInt();
		mes1=sc.nextInt();
		anho1=sc.nextInt();
		System.out.println("Introduce la segunda fecha en este orden dd-mm-aaaa");
		dia2=sc.nextInt();
		mes2=sc.nextInt();
		anho2=sc.nextInt();
		
//		Como los meses tienen 30 días el año tiene 360 días
		total+=Math.abs(anho1-anho2)*360;
		total+=Math.abs(mes1-mes2)*30;
		total+=Math.abs(dia1-dia2);
		
		System.out.println(total);
		sc.close();
	}


}
