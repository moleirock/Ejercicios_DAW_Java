package boletin_3;
import java.util.*;
public class Ejercicio_6 {

	public static void main(String[] args) {
//		6. Realizar un programa que nos pida un n�mero n, y nos diga cuantos n�meros hay entre 1 y n
//		que son primos. 
		Scanner sc=new Scanner(System.in);
		int num,limite,cont;
		System.out.println("Introduce un n�mero y te dir� cuantos primos hay entre 1 y ese n�mero ");
		cont=2;
		
		limite=sc.nextInt();
		while(limite<1) {
			System.out.println("El n�mero deber ser mayor de 1, prueba otra vez.");
			limite=sc.nextInt();
		}
		if(limite==2) {
			System.out.println("Hay 1 n�mero primo entre 1 y 2");
		}else if(limite==3) {
			System.out.println("Hay 2 n�mero primo entre 1 y 3");
		}
		for(int i=4;i<=limite;i++) {
			num=2;
			
			while(num<i) {
				
				if(i%num==0) {
					break;
				}else if(num==i-1) {
					cont++;
				}
				num++;
			}
		}
		
		System.out.println("Hay "+cont+ " n�meros primos entre 1 y "+ limite);
		
		sc.close();
	}

}
