package boletin_1;
import java.util.*;
public class Ejercicio14 {

	public static void main(String[] args) {
//		14. Pedir una nota de 0 a 10 y mostrarla de la forma: Insuficiente, Suficiente, Bien...
		Scanner sc=new Scanner(System.in);
		double nota;
		
		System.out.println("Introduce una nota de 0 a 10");
		nota=sc.nextDouble();
		
		while (nota<0 || nota>10) {
			System.out.println("Valor incorrecto");
			nota=sc.nextDouble();
		}
		
		if(nota<5) {
			System.out.println("Insuficiente");
		}else if(nota<6) {
			System.out.println("Suficiente");
		}else if(nota<7) {
			System.out.println("Bien");
		}else if(nota<9) {
			System.out.println("Notable");
		}else {
			System.out.println("Sobresaliente");
		}
		
		sc.close();
	}

}
