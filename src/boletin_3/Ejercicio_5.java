package boletin_3;

public class Ejercicio_5 {

	public static void main(String[] args) {
		int num1,num2,num3,num4;
		num1=0;
		num2=0;
		num3=0;
		num4=0;
		while(num1<10) {
			for(int i=0;i<10;i++) {
				if(i==9) {
					num4++;
				}else if(num4>8) {
					num3++;
					num4=0;
				}else if(num3>8) {
					num2++;
					num3=0;
				}else if(num2>8) {
					num1++;
					num2=0;
				}
				System.out.println(num1+","+num2+","+num3+","+num4+","+i);
			}
		}

	}

}
