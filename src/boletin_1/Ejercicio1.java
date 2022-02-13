package boletin_1;

import java.util.*;

public class Ejercicio1 {

	public static void main(String[] args) {

//		  1. Pedir los coeficientes de una ecuación se 2º grado, y muestre sus
//		  soluciones reales. Si no existen, debe indicarlo.
		Scanner sc = new Scanner(System.in);
		double a, b, c;

		System.out.println("Introduce los coeficientes de la ecuación en este orden a, b, y c");
		a = sc.nextDouble();
		b = sc.nextDouble();
		c = sc.nextDouble();

		
		
		
		if ((Math.pow(b, 2)-4*a*c)>=0 && a!=0) {
			System.out.println("Las dos soluciones son");
			System.out.println((-b + (Math.sqrt(Math.pow(b, 2) - 4 * a * c))) / (2 * a));
			System.out.println((-b - (Math.sqrt(Math.pow(b, 2) - 4 * a * c))) / (2 * a));
		}else {
			System.out.println("Las soluciones no son números reales o no se trata de una ecuación de segundo grado.");
		}
		
		sc.close();
		
		
		
		
		
		
		

//		if ((b == 0 && c > 0 && a > 0) || (b == 0 && c < 0 && a < 0) || a == 0 || (a==b && b==c) ||(b+c==0 && b<0)||(b+a==0 && b<0)) {
//			System.out.println("Las soluciones no son números reales o no se trata de una ecuación de segundo grado");
//		} else if ((b == 0 && c!=0)) {
//			System.out.println("Las soluciones son: ");
//			System.out.println(Math.sqrt(-c / a));
//			System.out.println(-1 * Math.sqrt(-c / a));
//		} else if (c == 0 && b != 0) {
//			System.out.println("Las soluciones son: \n0");
//			System.out.println(-b / a);
//		} else if (b == 0 && c == 0) {
//			System.out.println("Las solucion es: 0");
//		}else {
//			System.out.println("Las dos soluciones son");
//			System.out.println((-b + (Math.sqrt(Math.pow(b, 2) - 4 * a * c))) / (2 * a));
//			System.out.println((-b - (Math.sqrt(Math.pow(b, 2) - 4 * a * c))) / (2 * a));
//		}

	}

}
