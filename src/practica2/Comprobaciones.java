package practica2;

public class Comprobaciones {
	
	
	public static boolean esSimetrico(String chain) {
	String cadena=chain;
	if(cadena.length()==0){
		return false;
	}

	for(int i=0;i<cadena.length()/2;i++) {
		
		if(!(cadena.substring(i, i+1).equals(cadena.substring(cadena.length()-(i+1), cadena.length()-i)))){
			return false;
		}
	}
		
		return true;
	}
	
	public static boolean esCapicua(int numero) {
		String num=Integer.toString(numero);
		
		if(Comprobaciones.esSimetrico(num)) return true;
		
		return false;
	}
	
	public static boolean esPrimo(int numero) {	
		int num=(numero<0?numero*(-1):numero);	
		if(num<2) { 
			return false;
		}else if(num<4) {
			return true;
		}
		
		for (int i=2;i<=num/2;i++) {
			if(num%i==0) {
				return false;
			}
		}	
		return true;
	}
	
	public static boolean esAntiguo(int numero) {	
		if (numero<1900) return true;
		return false;
	}
	
	public static boolean esPar(int numero) {
		if(numero%2==0 && numero!=0) return true;
		return false;
	}
	
	public static boolean esTriangulo(double num1, double num2, double num3) {
		double hipotenusa=(num1>num2 && num1>num3)?num1:(num2>num3)?num2:num3;
		double cateto1=num1!=hipotenusa?num1:num2;
		double cateto2=num3!=hipotenusa?num3:num2;
		
		if(Math.pow(hipotenusa,2)==(Math.pow(cateto1, 2)+Math.pow(cateto2,2))) return true;
		return false;
	}
	
	public static boolean estaIntervalo(double numero, double principio,double fin) {
		
		if(fin>principio && numero<fin && numero>principio) {
			return true;
		}else if (fin<principio && numero >fin && numero<principio) {
			return true;
		}
		return false;
	}
	
	public static boolean esPositivo(int numero) {
		if(numero>=0) return true;
		return false;
	}
	
	public static boolean esBisiesto(int numero) {
		if(numero%4==0 &&(numero%100!=0 || numero%400==0)) return true;
		return false;
	}
	

}
