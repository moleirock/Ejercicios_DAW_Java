package boletin_2;
import java.util.*;
public class Ejercicio20 {

	public static void main(String[] args) {
//		20. Pedir un n�mero N, introducir N sueldos, y mostrar el sueldo m�ximo.
		Scanner sc=new Scanner(System.in);
		double sueldo,max;
		System.out.println("Introduce los sueldos y te dir� el m�ximo, cuando quieras terminar escribe un 0 ");
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
		System.out.println("El sueldo m�ximo es " + max);
		
		sc.close();
	}

}
