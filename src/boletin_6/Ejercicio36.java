package boletin_6;

import java.util.*;

//36. DUF que toma una tabla bidimensional de enteros, representando un tablero de ajedrez.
//Disponemos de las constantes PB (peón blanco), TN (torre negra), etc. (P, T, C, A, R, D). Dicho
//módulo debe devolver un valor booleano, que indique si el rey negro está amenazado.
public class Ejercicio36 {
	/* Figuras y valores */
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
	private int[][] tablero = new int[8][8];

//  Coordenadas del rey negro
	private int coordenadaY;
	private int coordenadaX;

	private int difY = 1;
	private int difX = 1;
	private int difXN = 1;

	Ejercicio36() {

	}

	public boolean getJaque(int[][] array) {
		tablero = array;

		/* Encontrar al rey */
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (tablero[i][j] == RN) {
					coordenadaY = i;
					coordenadaX = j;
					break;
				}
			}
		}

//		Dirección al lado blanco línea recta (se evalúa que la casilla este dentro del tablero)
		for (int i = coordenadaY - 1; i >= 0; i--) {
//			Si se encuentra con una figura que no hace jaque
			if (tablero[i][coordenadaX] < 0 || tablero[i][coordenadaX] == PB || tablero[i][coordenadaX] == CB
					|| tablero[i][coordenadaX] == AB || tablero[i][coordenadaX] == RB) {
				break;
//				Si se encuentra con una figura que hace jaque
			} else if (tablero[i][coordenadaX] == TB || tablero[i][coordenadaX] == DB) {
				return jaque = true;
			}
		}
//		Dirección al lado negro línea recta (se evalúa que la casilla este dentro del tablero)
		for (int i = coordenadaY + 1; i <= 7; i++) {
//			Si se encuentra con una figura que no hace jaque
			if (tablero[i][coordenadaX] < 0 || tablero[i][coordenadaX] == PB || tablero[i][coordenadaX] == CB
					|| tablero[i][coordenadaX] == AB || tablero[i][coordenadaX] == RB) {
				break;
//				Si se encuentra con una figura que hace jaque
			} else if (tablero[i][coordenadaX] == TB || tablero[i][coordenadaX] == DB) {
				return jaque = true;
			}
		}

//		Dirección a izquierda línea recta (se evalúa que la casilla este dentro del tablero)
		for (int i = coordenadaX - 1; i >= 0; i--) {
//			Si se encuentra con una figura que no hace jaque
			if (tablero[coordenadaY][i] < 0 || tablero[coordenadaY][i] == PB || tablero[coordenadaY][i] == CB
					|| tablero[coordenadaY][i] == AB || tablero[coordenadaY][i] == RB) {
				break;
//				Si se encuentra con una figura que hace jaque
			} else if (tablero[coordenadaY][i] == TB || tablero[coordenadaY][i] == DB) {
				return jaque = true;
			}
		}
//		Dirección derecha línea recta (se evalúa que la casilla este dentro del tablero)
		for (int i = coordenadaX + 1; i <= 7; i++) {
//			Si se encuentra con una figura que no hace jaque
			if (tablero[coordenadaY][i] < 0 || tablero[coordenadaY][i] == PB || tablero[coordenadaY][i] == CB
					|| tablero[coordenadaY][i] == AB || tablero[coordenadaY][i] == RB) {
				break;
//				Si se encuentra con una figura que hace jaque
			} else if (tablero[coordenadaY][i] == TB || tablero[coordenadaY][i] == DB) {
				return jaque = true;
			}
		}

//		diagonal derecha hacia lado blanco (se evalúa que la casilla este dentro del tablero)
		for (int i = coordenadaY - 1; i >= 0; i--) {
			if ((coordenadaX + difX) <= 7) {
//				Si se encuentra con una figura que no hace jaque
				if (tablero[i][coordenadaX + difX] < 0 || tablero[i][coordenadaX + difX] == TB
						|| tablero[i][coordenadaX + difX] == CB || tablero[i][coordenadaX + difX] == RB) {
					break;
//					Si se encuentra con una figura que hace jaque
				} else if (tablero[i][coordenadaX + difX] == AB || tablero[i][coordenadaX + difX] == DB
						|| (tablero[i][coordenadaX + difX] == PB && difX < 2)) {
					return jaque = true;
				}
				difX++;
			}
		}
		difX = 1;

//		diagonal izquierda hacia lado blanco (se evalúa que la casilla este dentro del tablero)
		for (int i = coordenadaY - 1; i >= 0; i--) {
			if ((coordenadaX - difX) >= 0) {
//				Si se encuentra con una figura que no hace jaque
				if (tablero[i][coordenadaX - difX] < 0 || tablero[i][coordenadaX - difX] == TB
						|| tablero[i][coordenadaX - difX] == CB || tablero[i][coordenadaX - difX] == RB) {
					break;
//					Si se encuentra con una figura que hace jaque
				} else if (tablero[i][coordenadaX - difX] == AB || tablero[i][coordenadaX - difX] == DB
						|| (tablero[i][coordenadaX - difX] == PB && difX < 2)) {
					return jaque = true;
				}
				difX++;
			}
		}
		difX = 1;

//		diagonal derecha hacia lado negro (se evalúa que la casilla este dentro del tablero)
		for (int i = coordenadaY + 1; i <= 7; i++) {
			if ((coordenadaX + difX) <= 7) {
//				Si se encuentra con una figura que no hace jaque
				if (tablero[i][coordenadaX + difX] < 0 || tablero[i][coordenadaX + difX] == TB
						|| tablero[i][coordenadaX + difX] == CB || tablero[i][coordenadaX + difX] == RB
						|| (tablero[i][coordenadaX + difX] == PB)) {
					break;
//					Si se encuentra con una figura que hace jaque
				} else if (tablero[i][coordenadaX + difX] == AB || tablero[i][coordenadaX + difX] == DB) {
					return jaque = true;
				}
				difX++;
			}
		}
		difX = 1;

//		diagonal izquierda hacia lado negro (se evalúa que la casilla este dentro del tablero)
		for (int i = coordenadaY + 1; i <= 7; i++) {
			if ((coordenadaX - difX) >= 0) {
//				Si se encuentra con una figura que no hace jaque
				if (tablero[i][coordenadaX - difX] < 0 || tablero[i][coordenadaX - difX] == TB
						|| tablero[i][coordenadaX - difX] == CB || tablero[i][coordenadaX - difX] == RB
						|| tablero[i][coordenadaX - difX] == PB) {
					break;
//					Si se encuentra con una figura que hace jaque
				} else if (tablero[i][coordenadaX - difX] == AB || tablero[i][coordenadaX - difX] == DB) {
					return jaque = true;
				}
				difX++;
			}
		}
		difX = 1;

//		Saltos del caballo
		for (int i = -2; i <= 2; i++) {

//			Se toma i como incremento de la coordenadaY y se calcula la coordenadaX en funcíon de los valores que puede tomar
			difY = coordenadaY + i;
//			Ecuación de la circunferencia(semicircunferencia) se declarán dos variables para cada mitad de la circunferencia(r^2=5).
			difX = (int) ((Math.sqrt(5 - Math.pow((difY - coordenadaY), 2))) + coordenadaX);
			difXN = (int) (-(Math.sqrt(5 - Math.pow((difY - coordenadaY), 2))) + coordenadaX);

//			cada condicion representa una mitad de la circunferencia( se evalúa que la casilla este dentro del tablero)
			if (i < 0 && (difY >= 0 && difXN >= 0 && tablero[difY][difXN] == CB
					|| difY >= 0 && difX <= 7 && tablero[difY][difX] == CB)) {
				return jaque = true;

			}
			if (i > 0 && (difY <= 7 && difXN >= 0 && tablero[difY][difXN] == CB
					|| difY <= 7 && difX <= 7 && tablero[difY][difX] == CB)) {
				return jaque = true;

			}
		}

		return jaque;
	}

	public static void main(String args[]) {
		Ejercicio36 juego = new Ejercicio36();
		Scanner sc = new Scanner(System.in);
		int y = 1;
		int x = 1;
		String confirmacion = "sí";
		int[][] tablero = new int[8][8];
		System.out.println("---------------------------------------------------------------------------------------");
		System.out.println("\t\t\t¿Está en jaque nuestro amado rey negro?");
		System.out.println("---------------------------------------------------------------------------------------");
		System.out.println("Coloca las figuras en nuestro tablero virtual, para ello debes de indicar las coordenadas\n"
				+ "donde están colocadas y que figura está colocada en dicha coordenada.\n\n"
				+ "Para ello toma como origen de coordenadas(0,0) la casilla dónde coloca el jugador blanco,al principio \n"
				+ "de la partida, su torre del lado derecho.\n\n"
				+ "Indícame con valores de que figura se trata, ayúdate de esta tabla para identificar la \n"
				+ "figura. ¡No te olvides de incluir al rey negro!\n\n" + "Peón Blanco = 1\n" + "Torre Blanca = 2\n"
				+ "Caballo Blanco = 3\n" + "Alfil Blanco = 4\r\n" + "Rey Blanco = 5\n" + "Dama Blanca = 6\n"
				+ "Peón Negro = -1\n" + "Torre Negra = -2\n" + "Caballo Negro = -3\n" + "Alfil Negro = -4\n"
				+ "Rey Negro = -5\n"
				+ "Dama Negra = -6\n---------------------------------------------------------------------------------------");

		while (confirmacion.equalsIgnoreCase("sí")) {
			System.out.println("Introduce la coordenada 'Y' y la coordenada 'X', en ese orden.");
			y = sc.nextInt();
			x = sc.nextInt();

			while (y < 0 || y > 7 || x < 0 || x > 7) {
				System.out.println(
						"Recuerda que las coordenadas tienen que ser números enteros entra 0 y 7, introduclos de\nnuevo en el mismo orden");
				y = sc.nextInt();
				x = sc.nextInt();
			}
			System.out.println("Introduce el valor de la figura que está en esta coordenada");
			tablero[y][x] = sc.nextInt();
			while (tablero[y][x] < -6 || tablero[y][x] > 6) {
				System.out.println("No es un valor válido, introducelo de nuevo");
				tablero[y][x] = sc.nextInt();
			}
			System.out.println("\nEl tablero queda así.\n");
			System.out.println("---------------------------------\n\t    Lado Blanco\n---------------------------------");
			for (int i = 0; i < 8; i++) {
				System.out.print("| ");
				for (int j = 0; j < 8; j++) {
					System.out.print(tablero[i][j] + " | ");
				}

				System.out.println("\n---------------------------------");
			}
	System.out.println("\t    Lado Negro\n---------------------------------\n");
			System.out.println("¿Quieres añadir una nueva figura? Responde sí o no.");
			confirmacion = sc.next();
			while (!confirmacion.equalsIgnoreCase("sí") && !confirmacion.equalsIgnoreCase("no")) {
				System.out.println("Responde sí o no.");
				confirmacion = sc.next();
			}
		}
		

		System.out.println(juego.getJaque(tablero) ? "¡Nuestro rey está amenazado, haz algo para evitar el jaque!"
				: "¡Nuestro rey está seguro, larga vida al rey!");
		sc.close();
	}

}
