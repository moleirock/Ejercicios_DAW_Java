package boletin_6;

import boletin_6.Ejercicio36;

public class Ejercicio37 {
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
	private boolean jaqueMate = true;
	private int[][] tablero = new int[8][8];
	private int[][] tableroCambiado = new int[8][8];

	private int[] atacante = new int[3];
	Ejercicio37 figura = new Ejercicio37();

//  Coordenadas del rey negro
	private int coordenadaY;
	private int coordenadaX;

	private int difY = 1;
	private int difX = 1;
	private int difXN = 1;

	private Ejercicio36 jaque = new Ejercicio36();

	Ejercicio37() {

	}
// considerar que se pueden comer figuras blancas
	public boolean getJaqueMate(int[][] array) {
		tablero = array;
		tableroCambiado = array;

//		Comprobamos primero si está en jaque
		if (jaque.getJaque(tablero)) {

//			Guardar figura y posicíon del atacante, [figura,y,x]
			atacante = figura.getJaqueFigura(array);

//		Encontrar al rey
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (tablero[i][j] == RN) {
						coordenadaY = i;
						coordenadaX = j;
						break;
					}
				}
			}


			for (int i = -1; i <= 1; i++) {
				for (int j = -1; j <= 1; j++) {
					if (coordenadaY + i >= 0 && coordenadaX + j >= 0 && coordenadaY + i <= 7 && coordenadaX + j <= 7
							&& tablero[coordenadaY + i][coordenadaX + j] >= 0) {

						tableroCambiado[coordenadaY][coordenadaX] = 0;
						tableroCambiado[coordenadaY + i][coordenadaX + j] = -5;

						if (!jaque.getJaque(tableroCambiado)) {
							return jaqueMate = false;

						}
						tableroCambiado = tablero;

					}
				}
			}

		}
		return jaqueMate;

	}

//	Obtener atacante------------------------------------------------------------------------------

	public int[] getJaqueFigura(int[][] array) {
		tablero = array;
		if (jaque.getJaque(tablero)) {
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

					atacante[0] = tablero[i][coordenadaX];
					atacante[1] = i;
					atacante[2] = coordenadaX;
					return atacante;
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
					atacante[0] = tablero[i][coordenadaX];
					atacante[1] = i;
					atacante[2] = coordenadaX;
					return atacante;
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
					atacante[0] = tablero[coordenadaY][i];
					atacante[1] = coordenadaY;
					atacante[2] = i;
					return atacante;
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
					atacante[0] = tablero[coordenadaY][i];
					atacante[1] = coordenadaY;
					atacante[2] = i;
					return atacante;
				}
			}

//		diagonal derecha hacia lado blanco (se evalúa que la casilla este dentro del tablero)
			for (int i = coordenadaY - 1; i >= 0; i--) {
				if ((coordenadaX + difX) <= 7) {
//				Si se encuentra con una figura que no hace jaque
					if (tablero[i][coordenadaX + difX] < 0 || tablero[i][coordenadaX + difX] == TB
							|| tablero[i][coordenadaX + difX] == CB || tablero[i][coordenadaX + difX] == RB
							|| (tablero[i][coordenadaX + difX] == PB && difX > 2)) {
						break;
//					Si se encuentra con una figura que hace jaque
					} else if (tablero[i][coordenadaX + difX] == AB || tablero[i][coordenadaX + difX] == DB
							|| (tablero[i][coordenadaX + difX] == PB && difX < 2)) {
						atacante[0] = tablero[i][coordenadaX + difX];
						atacante[1] = i;
						atacante[2] = coordenadaX + difX;
						return atacante;
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
							|| tablero[i][coordenadaX - difX] == CB || tablero[i][coordenadaX - difX] == RB
							|| (tablero[i][coordenadaX - difX] == PB && difX > 2)) {
						break;
//					Si se encuentra con una figura que hace jaque
					} else if (tablero[i][coordenadaX - difX] == AB || tablero[i][coordenadaX - difX] == DB
							|| (tablero[i][coordenadaX - difX] == PB && difX < 2)) {
						atacante[0] = tablero[i][coordenadaX - difX];
						atacante[1] = i;
						atacante[2] = coordenadaX - difX;
						return atacante;
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
							|| tablero[i][coordenadaX + difX] == PB) {
						break;
//					Si se encuentra con una figura que hace jaque
					} else if (tablero[i][coordenadaX + difX] == AB || tablero[i][coordenadaX + difX] == DB) {
						atacante[0] = tablero[i][coordenadaX + difX];
						atacante[1] = i;
						atacante[2] = coordenadaX + difX;
						return atacante;
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
						atacante[0] = tablero[i][coordenadaX - difX];
						atacante[1] = i;
						atacante[2] = coordenadaX - difX;
						return atacante;
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
					if (tablero[difY][difX] == CB) {

						atacante[0] = tablero[difY][difX];
						atacante[1] = difY;
						atacante[2] = difX;
						return atacante;
					} else {
						atacante[0] = tablero[difY][difXN];
						atacante[1] = difY;
						atacante[2] = difXN;
						return atacante;
					}

				}
				if (i > 0 && (difY <= 7 && difXN >= 0 && tablero[difY][difXN] == CB
						|| difY <= 7 && difX <= 7 && tablero[difY][difX] == CB)) {

					if (tablero[difY][difX] == CB) {
						atacante[0] = tablero[difY][difX];
						atacante[1] = difY;
						atacante[2] = difX;
						return atacante;
					} else {
						atacante[0] = tablero[difY][difXN];
						atacante[1] = difY;
						atacante[2] = difXN;
						return atacante;
					}

				}
			}
		}
		return atacante;
	}

}
