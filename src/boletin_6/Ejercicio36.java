package boletin_6;

import boletin_6.Ejercicio37;
import java.util.*;

//36. DUF que toma una tabla bidimensional de enteros, representando un tablero de ajedrez.
//Disponemos de las constantes PB (pe�n blanco), TN (torre negra), etc. (P, T, C, A, R, D). Dicho
//m�dulo debe devolver un valor booleano, que indique si el rey negro est� amenazado.

public class Ejercicio36 {
//	  Figuras y valores  
	private final int PB = 1;
	private final int TB = 2;
	private final int CB = 3;
	private final int AB = 4;
	private final int RB = 5;
	private final int DB = 6;
	private final int PN = -1;
	private final int TN = -2;
	private final int CN = -3;
	private final int AN = -4;
	private final int RN = -5;
	private final int DN = -6;

	/* Variables de jugada */
	private boolean jaque = false;
	private int[][] tablero = new int[8][8]; //posible problema de encapsulamiento

//  Coordenadas del rey negro
	private int coordenadaY;
	private int coordenadaX;

// Diferenciales(contadores) para usar en los movimientos de las figuras, o como variables auxiliares.
	private int difY = 1;
	private int difX = 1;
	private int difXN = 1;

	Ejercicio36() {

	}

//	Comienzo del m�todo jaque, se base en evaluar si el rey est� amenazado, para ello se fija la coordenada 
//	donde est� situado el rey y desde ella se busca figuras rivales simulando su movimiento(el movimiento de las figuras rivales).
	public boolean getJaque(int[][] array) {
		tablero = array;

		/* Encontrar al rey y guardar coordenadas */
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (tablero[i][j] == RN) {
					coordenadaY = i;
					coordenadaX = j;
					break;
				}
			}
		}
		
//		Direcci�n al lado blanco l�nea recta (se eval�a que la casilla este dentro del tablero). Se recorre el array aumentando 
//		o disminuyendo una de sus coordenadas.
		for (int i = coordenadaY - 1; i >= 0; i--) {
//			Si se encuentra con una figura que no hace jaque interrumpe y pasa a la siguiente iteraci�n.
			if (tablero[i][coordenadaX] < 0 || tablero[i][coordenadaX] == PB || tablero[i][coordenadaX] == CB
					|| tablero[i][coordenadaX] == AB || tablero[i][coordenadaX] == RB) {
				break;
//				Si se encuentra con una figura que hace jaque, finaliza el m�todo y devuelve verdadero. En este caso sabemos que la 
//				torre blanca y la dama blanca son las �nicas figuras que pueden moverse en l�nea recta y hacer jaque.
			} else if (tablero[i][coordenadaX] == TB || tablero[i][coordenadaX] == DB) {
				return jaque = true;
			}
		}

//		Direcci�n al lado negro l�nea recta (se eval�a que la casilla este dentro del tablero).
		for (int i = coordenadaY + 1; i <= 7; i++) {
//			Si se encuentra con una figura que no hace jaque interrumpe y pasa a la siguiente iteraci�n.
			if (tablero[i][coordenadaX] < 0 || tablero[i][coordenadaX] == PB || tablero[i][coordenadaX] == CB
					|| tablero[i][coordenadaX] == AB || tablero[i][coordenadaX] == RB) {
				break;
//				Si se encuentra con una figura que hace jaque, finaliza el m�todo y devuelve verdadero. 
			} else if (tablero[i][coordenadaX] == TB || tablero[i][coordenadaX] == DB) {
				return jaque = true;
			}
		}
		
//		Direcci�n a izquierda l�nea recta (se eval�a que la casilla este dentro del tablero)
		for (int i = coordenadaX - 1; i >= 0; i--) {
//			Si se encuentra con una figura que no hace jaque interrumpe y pasa a la siguiente iteraci�n.
			if (tablero[coordenadaY][i] < 0 || tablero[coordenadaY][i] == PB || tablero[coordenadaY][i] == CB
					|| tablero[coordenadaY][i] == AB || tablero[coordenadaY][i] == RB) {
				break;
//				Si se encuentra con una figura que hace jaque, finaliza el m�todo y devuelve verdadero. 
			} else if (tablero[coordenadaY][i] == TB || tablero[coordenadaY][i] == DB) {
				return jaque = true;
			}
		}
//		Direcci�n derecha l�nea recta (se eval�a que la casilla este dentro del tablero)
		for (int i = coordenadaX + 1; i <= 7; i++) {
//			Si se encuentra con una figura que no hace jaque interrumpe y pasa a la siguiente iteraci�n.
			if (tablero[coordenadaY][i] < 0 || tablero[coordenadaY][i] == PB || tablero[coordenadaY][i] == CB
					|| tablero[coordenadaY][i] == AB || tablero[coordenadaY][i] == RB) {
				break;
//				Si se encuentra con una figura que hace jaque, finaliza el m�todo y devuelve verdadero. 
			} else if (tablero[coordenadaY][i] == TB || tablero[coordenadaY][i] == DB) {
				return jaque = true;
			}
		}

//		Diagonal derecha hacia lado blanco (se eval�a que la casilla este dentro del tablero). Se recorre el array aumentando 
//		o disminuyendo las dos coordenadas.
		for (int i = coordenadaY - 1; i >= 0; i--) {
			if ((coordenadaX + difX) <= 7) {
//			Si se encuentra con una figura que no hace jaque interrumpe y pasa a la siguiente iteraci�n.
				if (tablero[i][coordenadaX + difX] < 0 || tablero[i][coordenadaX + difX] == TB
						|| tablero[i][coordenadaX + difX] == CB || tablero[i][coordenadaX + difX] == RB
						|| (tablero[i][coordenadaX + difX] == PB && difX > 1)) {
					break;
//					Si se encuentra con una figura que hace jaque, finaliza el m�todo y devuelve verdadero. En este caso las 
//					figuras que hacen jaque son las que se mueven en diagonal, un caso especial es el pe�n que solo hace jaque si est� en una casilla adyacente en diagonal hacia el lado blanco.
				} else if (tablero[i][coordenadaX + difX] == AB || tablero[i][coordenadaX + difX] == DB
						|| tablero[i][coordenadaX + difX] == PB) {
					return jaque = true;
				}
				difX++;
			}
		}
		difX = 1;

//		Diagonal izquierda hacia lado blanco (se eval�a que la casilla este dentro del tablero).
		for (int i = coordenadaY - 1; i >= 0; i--) {
			if ((coordenadaX - difX) >= 0) {
//			Si se encuentra con una figura que no hace jaque interrumpe y pasa a la siguiente iteraci�n.
				if (tablero[i][coordenadaX - difX] < 0 || tablero[i][coordenadaX - difX] == TB
						|| tablero[i][coordenadaX - difX] == CB || tablero[i][coordenadaX - difX] == RB
						|| (tablero[i][coordenadaX - difX] == PB && difX > 1)) {
					break;
//					Si se encuentra con una figura que hace jaque, finaliza el m�todo y devuelve verdadero. 
				} else if (tablero[i][coordenadaX - difX] == AB || tablero[i][coordenadaX - difX] == DB
						|| tablero[i][coordenadaX - difX] == PB ) {
					return jaque = true;
				}
				difX++;
			}
		}
		difX = 1;

//		Diagonal derecha hacia lado negro (se eval�a que la casilla este dentro del tablero).
		for (int i = coordenadaY + 1; i <= 7; i++) {
			if ((coordenadaX + difX) <= 7) {
//			Si se encuentra con una figura que no hace jaque interrumpe y pasa a la siguiente iteraci�n.
				if (tablero[i][coordenadaX + difX] < 0 || tablero[i][coordenadaX + difX] == TB
						|| tablero[i][coordenadaX + difX] == CB || tablero[i][coordenadaX + difX] == RB
						|| tablero[i][coordenadaX + difX] == PB) {
					break;
//					Si se encuentra con una figura que hace jaque, finaliza el m�todo y devuelve verdadero. 
				} else if (tablero[i][coordenadaX + difX] == AB || tablero[i][coordenadaX + difX] == DB) {
					return jaque = true;
				}
				difX++;
			}
		}
		difX = 1;

//		Diagonal izquierda hacia lado negro (se eval�a que la casilla este dentro del tablero).
		for (int i = coordenadaY + 1; i <= 7; i++) {
			if ((coordenadaX - difX) >= 0) {
//			Si se encuentra con una figura que no hace jaque interrumpe y pasa a la siguiente iteraci�n.
				if (tablero[i][coordenadaX - difX] < 0 || tablero[i][coordenadaX - difX] == TB
						|| tablero[i][coordenadaX - difX] == CB || tablero[i][coordenadaX - difX] == RB
						|| tablero[i][coordenadaX - difX] == PB) {
					break;
//					Si se encuentra con una figura que hace jaque, finaliza el m�todo y devuelve verdadero. 
				} else if (tablero[i][coordenadaX - difX] == AB || tablero[i][coordenadaX - difX] == DB) {
					return jaque = true;
				}
				difX++;
			}
		}
		difX = 1;

//		Saltos del caballo. Se toma i como la diferencia que puede tener la coordenadaY a la hora de mover el caballo
//		(por ejemplo si la coordenadaY aumenta en 2, la coordenadaX aumenta o disminuye en 1).
		for (int i = -2; i <= 2; i++) {

//			Se toma i como incremento de la coordenadaY y se calcula la coordenadaX en func�on de los valores que puede tomar.
			difY = coordenadaY + i;

//			Ecuaci�n de la circunferencia(semicircunferencia)(pit�goras) se declar�n dos variables para cada mitad de la circunferencia. (radio^2=5)
//			En la ecuaci�n de la circunferencia hay que restar a la coordenada Y del punto la coordenada Y del centro de la circunferencia pero nosotros 
//			ya tenemos hecho ese calculo que es lo que nos da i(i=difY - coordenadaY).
			difX = (int) ((Math.sqrt(5 - Math.pow(i, 2))) + coordenadaX);
			difXN = (int) (-(Math.sqrt(5 - Math.pow(i, 2))) + coordenadaX);

//			Cada condicion representa una mitad de la circunferencia( se eval�a que la casilla este dentro del tablero).
			if (i < 0 && (difY >= 0 && difXN >= 0 && tablero[difY][difXN] == CB
					|| difY >= 0 && difX <= 7 && tablero[difY][difX] == CB)) {
				return jaque = true;

			}
			if (i > 0 && (difY <= 7 && difXN >= 0 && tablero[difY][difXN] == CB
					|| difY <= 7 && difX <= 7 && tablero[difY][difX] == CB)) {
				return jaque = true;

			}
		}

		return jaque=false;
	}

	public static void main(String args[]) {

//		Instancia
		Ejercicio36 juego = new Ejercicio36();

//		A�adiendo posici�n y figura que hace jaque, Instancio un objeto de la clase "Ejercicio37" para probar el m�todo de obtenci�n del  tipo y posici�n 
//		de lafigura que hace jaque (getJaqueFigura).
		Ejercicio37 mate = new Ejercicio37();
		int[] figuraAtacante = new int[3];

		Scanner sc = new Scanner(System.in);

		int y;
		int x;
		String confirmacion = "s";
		int[][] tablero = new int[8][8];
		
		
		

//		Texto con instrucci�nes para el desarrollo del juego.
		System.out.println("---------------------------------------------------------------------------------------");
		System.out.println("\t\t\t�Est� en jaque nuestro amado rey negro?");
		System.out.println("---------------------------------------------------------------------------------------");
		System.out.println("Coloca las figuras en nuestro tablero virtual, para ello debes de indicar las coordenadas\n"
				+ "donde est�n colocadas y que figura est� colocada en dicha coordenada.\n\n"
				+ "Para ello toma como origen de coordenadas(0,0) la casilla d�nde coloca el jugador blanco,al principio \n"
				+ "de la partida, su torre del lado derecho.\n\n"
				+ "Ind�came con valores de que figura se trata, ay�date de esta tabla para identificar la \n"
				+ "figura. �No te olvides de incluir al rey negro!\n\n" + "Pe�n Blanco = 1\n" + "Torre Blanca = 2\n"
				+ "Caballo Blanco = 3\n" + "Alfil Blanco = 4\r\n" + "Rey Blanco = 5\n" + "Dama Blanca = 6\n"
				+ "Pe�n Negro = -1\n" + "Torre Negra = -2\n" + "Caballo Negro = -3\n" + "Alfil Negro = -4\n"
				+ "Rey Negro = -5\n"
				+ "Dama Negra = -6\n---------------------------------------------------------------------------------------");

		while (confirmacion.equalsIgnoreCase("s")) {
			System.out.println("Introduce la coordenada 'Y' y la coordenada 'X', en ese orden.");
			y = sc.nextInt();
			x = sc.nextInt();

			while (y < 0 || y > 7 || x < 0 || x > 7) {
				System.out.println(
						"Recuerda que las coordenadas tienen que ser n�meros enteros entre 0 y 7, introduclos de\nnuevo en el mismo orden");
				y = sc.nextInt();
				x = sc.nextInt();
			}
			System.out.println("Introduce el valor de la figura que est� en esta coordenada");
			tablero[y][x] = sc.nextInt();

			while (tablero[y][x] < -6 || tablero[y][x] > 6) {
				System.out.println("No es un valor v�lido, introducelo de nuevo");
				tablero[y][x] = sc.nextInt();
			}

//			Imprimir tablero
			System.out.println("\nEl tablero queda as�.\n");
			System.out
					.println("---------------------------------\n\t    Lado Blanco\n---------------------------------");
			for (int i = 0; i < 8; i++) {
				System.out.print("| ");
				for (int j = 0; j < 8; j++) {
					System.out.print(tablero[i][j] + " | ");
				}

				System.out.println("\n---------------------------------");
			}
			System.out.println("\t    Lado Negro\n---------------------------------\n");

			System.out.println("�Quieres a�adir una nueva figura? Responde s�(S) o no(N).");
			confirmacion = sc.next();
			while (!confirmacion.equalsIgnoreCase("s") && !confirmacion.equalsIgnoreCase("n")) {
				System.out.println("Responde (S) o (N).");
				confirmacion = sc.next();
			}
		}

		figuraAtacante = mate.getJaqueFigura(tablero);
		System.out.println(juego.getJaque(tablero)
				? "�Nuestro rey est� amenazado, haz algo para evitar el jaque!" + "la figura es " + figuraAtacante[0]
						+ " y est� en la posici�n " + figuraAtacante[1] + "," + figuraAtacante[2]
				: "�Nuestro rey est� seguro, larga vida al rey!");
		
		
		
		
//		PROBANDO JAQUE MATE EJERCICIO 37
		
		System.out.println(mate.getJaqueMate(tablero));
		
		sc.close();
	}
//--------------------------------------------------------------------------------------------------------------------------
//	M�todo de jaque incluyendo la figura del rey como posible figura que hace jaque para usarla en el Ejercicio37. Se limpia 
//	el c�digo para que no sea tan extenso pero el m�todo es igual a getJaque(con una variaci�n).
	public boolean getJaqueConRey(int[][] array) {
		tablero = array;
		
		for (int i = 0; i <= 7; i++) {
			for (int j = 0; j <= 7; j++) {
				if (tablero[i][j] == RN) {
					coordenadaY = i;
					coordenadaX = j;
					break;
				}
			}
		}
		
		
//		Direcci�n al lado blanco l�nea recta
		for (int i = coordenadaY - 1; i >= 0; i--) {

			if (tablero[i][coordenadaX] < 0 || tablero[i][coordenadaX] == PB || tablero[i][coordenadaX] == CB
					|| tablero[i][coordenadaX] == AB || (tablero[i][coordenadaX] == RB && difX > 1)) {
				break;
			} else if (tablero[i][coordenadaX] == TB || tablero[i][coordenadaX] == DB
					|| tablero[i][coordenadaX] == RB) {
				
				return jaque = true;
			}
			difX++;
		}
		difX = 1;
//		Direcci�n al lado negro l�nea recta (se eval�a que la casilla este dentro del tablero).
		for (int i = coordenadaY + 1; i <= 7; i++) {

			if (tablero[i][coordenadaX] < 0 || tablero[i][coordenadaX] == PB || tablero[i][coordenadaX] == CB
					|| tablero[i][coordenadaX] == AB || (tablero[i][coordenadaX] == RB && difX > 1)) {
				break;
			} else if (tablero[i][coordenadaX] == TB || tablero[i][coordenadaX] == DB
					|| tablero[i][coordenadaX] == RB) {
				return jaque = true;
			}
			difX++;
		}
		difX = 1;

//		Direcci�n a izquierda l�nea recta (se eval�a que la casilla este dentro del tablero)
		for (int i = coordenadaX - 1; i >= 0; i--) {
			if (tablero[coordenadaY][i] < 0 || tablero[coordenadaY][i] == PB || tablero[coordenadaY][i] == CB
					|| tablero[coordenadaY][i] == AB || (tablero[coordenadaY][i] == RB && difX > 1)) {
				break;
			} else if (tablero[coordenadaY][i] == TB || tablero[coordenadaY][i] == DB
					|| tablero[coordenadaY][i] == RB) {
				
				return jaque = true;
			}
			difX++;
		}
		difX = 1;
//		Direcci�n derecha l�nea recta (se eval�a que la casilla este dentro del tablero)
		for (int i = coordenadaX + 1; i <= 7; i++) {
			if (tablero[coordenadaY][i] < 0 || tablero[coordenadaY][i] == PB || tablero[coordenadaY][i] == CB
					|| tablero[coordenadaY][i] == AB || (tablero[coordenadaY][i] == RB && difX > 1)) {
				break;
			} else if (tablero[coordenadaY][i] == TB || tablero[coordenadaY][i] == DB
					|| tablero[coordenadaY][i] == RB) {
				return jaque = true;
			}
			difX++;
		}
		difX = 1;
//		Diagonal derecha hacia lado blanco 
		for (int i = coordenadaY - 1; i >= 0; i--) {
			if ((coordenadaX + difX) <= 7) {
				if (tablero[i][coordenadaX + difX] < 0 || tablero[i][coordenadaX + difX] == TB
						|| tablero[i][coordenadaX + difX] == CB || (tablero[i][coordenadaX + difX] == RB && difX > 1)
						|| (tablero[i][coordenadaX + difX] == PB && difX > 1)) {
					break;
				} else if (tablero[i][coordenadaX + difX] == AB || tablero[i][coordenadaX + difX] == DB
						|| (tablero[i][coordenadaX + difX] == PB && difX < 2) || tablero[i][coordenadaX + difX] == RB) {
					return jaque = true;
				}
				difX++;
			}
		}
		difX = 1;

//		Diagonal izquierda hacia lado blanco
		for (int i = coordenadaY - 1; i >= 0; i--) {
			if ((coordenadaX - difX) >= 0) {
				if (tablero[i][coordenadaX - difX] < 0 || tablero[i][coordenadaX - difX] == TB
						|| tablero[i][coordenadaX - difX] == CB || (tablero[i][coordenadaX - difX] == RB && difX > 1)
						|| (tablero[i][coordenadaX - difX] == PB && difX > 1)) {
					break;
				} else if (tablero[i][coordenadaX - difX] == AB || tablero[i][coordenadaX - difX] == DB
						|| (tablero[i][coordenadaX - difX] == PB && difX < 2) || tablero[i][coordenadaX - difX] == RB) {
					return jaque = true;
				}
				difX++;
			}
		}
		difX = 1;
		
//		Diagonal derecha hacia lado negro (se eval�a que la casilla este dentro del tablero).
		for (int i = coordenadaY + 1; i <= 7; i++) {
			if ((coordenadaX + difX) <= 7) {
				if (tablero[i][coordenadaX + difX] < 0 || tablero[i][coordenadaX + difX] == TB
						|| tablero[i][coordenadaX + difX] == CB || (tablero[i][coordenadaX + difX] == RB && difX > 1)
						|| tablero[i][coordenadaX + difX] == PB) {
					break;
				} else if (tablero[i][coordenadaX + difX] == AB || tablero[i][coordenadaX + difX] == DB
						|| tablero[i][coordenadaX + difX] == RB) {
					return jaque = true;
				}
				difX++;
			}
		}
		difX = 1;
		
//		Diagonal izquierda hacia lado negro (se eval�a que la casilla este dentro del tablero).
		for (int i = coordenadaY + 1; i <= 7; i++) {
			if ((coordenadaX - difX) >= 0) {
				if (tablero[i][coordenadaX - difX] < 0 || tablero[i][coordenadaX - difX] == TB
						|| tablero[i][coordenadaX - difX] == CB || (tablero[i][coordenadaX - difX] == RB && difX > 1)
						|| tablero[i][coordenadaX - difX] == PB) {
					break;
				} else if (tablero[i][coordenadaX - difX] == AB || tablero[i][coordenadaX - difX] == DB
						|| tablero[i][coordenadaX - difX] == RB) {
					return jaque = true;
				}
				difX++;
			}
		}
		difX = 1;
		
//		Saltos del caballo. 
		for (int i = -2; i <= 2; i++) {
			
			difY = coordenadaY + i;

			difX = (int) ((Math.sqrt(5 - Math.pow(i, 2))) + coordenadaX);
			difXN = (int) (-(Math.sqrt(5 - Math.pow(i, 2))) + coordenadaX);

			if (i < 0 && (difY >= 0 && difXN >= 0 && tablero[difY][difXN] == CB
					|| difY >= 0 && difX <= 7 && tablero[difY][difX] == CB)) {
				return jaque = true;

			}
			if (i > 0 && (difY <= 7 && difXN >= 0 && tablero[difY][difXN] == CB
					|| difY <= 7 && difX <= 7 && tablero[difY][difX] == CB)) {
				return jaque = true;

			}
		}
		
		return jaque=false;
	}

}
