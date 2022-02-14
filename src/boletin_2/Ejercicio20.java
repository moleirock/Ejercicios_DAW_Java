package boletin_2;
import java.util.*;
public class Ejercicio20 {

	public static void main(String[] args) {
//		20. Pedir un número N, introducir N sueldos, y mostrar el sueldo máximo.
		Scanner sc=new Scanner(System.in);
		double sueldo,max;
		System.out.println("Introduce los sueldos y te diré el máximo, cuando quieras terminar escribe un 0 ");
		sueldo=sc.nextDouble();
		max=sueldo;
		while(sueldo!=0) {
		while(sueldo<0) {
			System.out.println("El sueldo debe ser positivo");
			sueldo=sc.nextDouble();
		}
		if(sueldo>max) {
			max=sueldo;
		}
		sueldo=sc.nextDouble();
		}
		System.out.println("El sueldo máximo es " + max);
		
		sc.close();
	}

}
