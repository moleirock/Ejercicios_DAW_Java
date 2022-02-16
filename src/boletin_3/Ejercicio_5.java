package boletin_3;

public class Ejercicio_5 {

	public static void main(String[] args) {
		
//		5. Necesitamos mostrar un contador con 5 dígitos (X-X-X-X-X), que muestre los números del 0-
//		0-0-0-0 al 9-9-9-9-9, con la particularidad que cada vez que aparezca un 3 lo sustituya por una
//		E.
		int num1,num2,num3,num4,num5;
		num1=0;
		num2=0;
		num3=0;
		num4=0;
		num5=0;
		while(num1+num2+num3+num4+num5<=45) {
			for(int i=0;i<10;i++) {
				
				if(num2==9&&num3==9&&num4==9&&num5>9) {
					num1++;
					num2=0;num3=0;num4=0;num5=0;
				}else if(num3==9&&num4==9&&num5>9) {
					num2++;
					num3=0;num4=0;num5=0;
				}else if(num4==9&&num5>9) {
					num3++;
					num4=0;num5=0;
				}else if(num5>9) {
					num4++;
					num5=0;
				}
				
				
				System.out.println((num1==3?"E":num1)+","+(num2==3?"E":num2)+","+(num3==3?"E":num3)+","+(num4==3?"E":num4)+","+(num5==3?"E":num5));
				num5++;
				
				
//				Parar la ejecución "x" segundos(milisegundos)
				try {
		            Thread.sleep(5);
		         } catch (Exception e) {
		            System.out.println(e);
		         }
				
			}
			
		}

	}

}
