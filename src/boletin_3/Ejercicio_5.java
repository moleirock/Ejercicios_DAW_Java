package boletin_3;

public class Ejercicio_5 {

	public static void main(String[] args) {
		int num1,num2,num3,num4,num5;
		num1=0;
		num2=0;
		num3=0;
		num4=0;
		num5=0;
		while(num1!=10) {
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
				
				
				System.out.println(num1+","+num2+","+num3+","+num4+","+num5);
				num5++;
				
				try {
		            Thread.sleep(00);
		         } catch (Exception e) {
		            System.out.println(e);
		         }
				
			}
			
		}

	}

}
