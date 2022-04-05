package practica2;

public class Alimento {
	private String nombre;
	private double lipidos;
	private double hidratos;
	private double proteinas;
	private boolean vegano;
	String vitaminas;
	String minerales;
	enum Niveles{
		ALTO("A"),MEDIO("M"),BAJO("B");
		private String abreviatura;
		private Niveles(String abreviatura) {
			this.abreviatura=abreviatura;
		}
		}
	
	
	public Alimento(String nombre,double lipidos,double hidratos,double proteinas,boolean vegano,Niveles vitaminas,Niveles minerales) {
		this.nombre=nombre;
		this.lipidos=lipidos;
		this.hidratos=hidratos;
		this.proteinas=proteinas;
		this.vegano=vegano;
		this.vitaminas=vitaminas.name();
		this.minerales=minerales.name();
		
	}
	public Alimento(String nombre) {
		this.nombre=nombre;
	}
	
	public boolean esDietetico() {
		if(lipidos<20 && minerales!="BAJO") return true;
		return false;
	}
	
	public void muestrAlimento() {
		System.out.println("El nombre del alimento es: " + nombre);
		System.out.println("Contiene un " + lipidos + " % de lipidos.");
		System.out.println("Contiene un " + hidratos + " % de hidratos.");
		System.out.println("Contiene un " + proteinas + " % de proteinas.");
		System.out.println(vegano?"Es vegano.":"No es vegano.");
		System.out.println("Tiene un nivel " + vitaminas + " de vitaminas.");
		System.out.println("Tiene un nivel " + minerales + " de minerales.");
	}
	
	public double calculaContenidoEnegertico() {
		return (lipidos*9.4/100)+(hidratos*4.1/100)+(proteinas*5.3/100);
	}
	
	public boolean recomendadoDeportistas() {
		if(proteinas>=10 && proteinas<=15 && lipidos>=30 && lipidos <=35 && hidratos>=55 && hidratos<=65) return true;
		return false;
	}
	
}
