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


//  Coordenadas del rey negro
	private int coordenadaY;
	private int coordenadaX;

	private int difY = 1;
	private int difX = 1;
	private int difXN = 1;

	private Ejercicio36 jaque = new Ejercicio36();

	Ejercicio37() {

	}


	public boolean getJaqueMate(int[][] array) {
//		Declaración de variables
		int[] atacante = new int[3];
		int[][] tableroCambiado = new int[8][8];
		int[][] tablero = new int[8][8];
		boolean jaqueMate = true;
		tablero = array;
		tableroCambiado = array;
		
//		Comprobamos primero si está en jaque
		if (jaque.getJaque(tablero)) {
			
//			Guardar figura y posicíon del atacante, [figura,y,x]
			atacante = this.getJaqueFigura(array);

//			Encontrar al rey
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (tablero[i][j] == RN) {
						coordenadaY = i;
						coordenadaX = j;
						break;
					}
				}
			}

// 			Recorro las casillas adyacentes al rey. Evitar jaque por desplazamiento.
			for (int i = -1; i <= 1; i++) {
				for (int j = -1; j <= 1; j++) {
//					Si hay una casilla vacía o ocupada por una figura enemiga compruebo si desplazando el rey a esa casilla seguiría en jaque.
					if (coordenadaY + i >= 0 && coordenadaX + j >= 0 && coordenadaY + i <= 7 && coordenadaX + j <= 7
							&& tablero[coordenadaY + i][coordenadaX + j] >= 0) {
//						Apoyándome de una copia del tablero realizo el movimiento del rey y compruebo si hay jaque, si es así entonces no hay jaque mate.
						tableroCambiado[coordenadaY][coordenadaX] = 0;
						tableroCambiado[coordenadaY + i][coordenadaX + j] = -5;
						
						if (!jaque.getJaqueConRey(tableroCambiado)) {
							
							return jaqueMate = false;
							
						}
//						Reinicio el tableroCambiado para poder recrear más movimientos en las siguientes iteraciones.
						tableroCambiado[coordenadaY][coordenadaX] = -5;
						tableroCambiado[coordenadaY + i][coordenadaX + j] = 0;
//						tableroCambiado = tablero; Esta sentencia no reinicia el tablero, y no sé porque

					}
				}
			}
			
//			Sabiendo que figura hace jaque recorremos el array hasta encontarnos con ella y buscamos si alguna de nuestras figuras se puede mover a esta esas casillas para aevitar el jaque.
//			Si al menos una de las coordenadas es igual a las del atacante entonces el movimiento es en líneae recta.

//			Atacante situado encima en línea recta.
			if (coordenadaX == atacante[2] && coordenadaY > atacante[1]) {
				for (int i = coordenadaY - 1; i >= atacante[1]; i--) {
					
					if (this.getMovimiento(tablero, i, coordenadaX)) {
						return jaqueMate = false;
					}
				}

			}
//			Atacante situado debajo en línea recta.
			if (coordenadaX == atacante[2] && coordenadaY < atacante[1]) {
				for (int i = coordenadaY + 1; i <= atacante[1]; i++) {
					
					if (this.getMovimiento(tablero, i, coordenadaX)) {
						return jaqueMate = false;
					}
				}

			}
//			Atacante situado izquierda en línea recta.
			if (coordenadaY == atacante[1] && coordenadaX > atacante[2]) {
				
				for (int i = coordenadaX - 1; i >= atacante[2]; i--) {
					
					if (this.getMovimiento(tablero, coordenadaY, i)) {
						return jaqueMate = false;
					}
				}

			}
//			Atacante situado derecha en línea recta.
			if (coordenadaY == atacante[1] && coordenadaX < atacante[1]) {
				for (int i = coordenadaX + 1; i <= atacante[2]; i++) {

					if (this.getMovimiento(tablero, coordenadaY, i)) {
						return jaqueMate = false;
					}
				}

			}
//			Atacante situado en una diagonal derecha por encima del rey.
			if (coordenadaY > atacante[1] && coordenadaX < atacante[2]
					&& (atacante[0] == AB || atacante[0] == DB || atacante[0] == PB)) {
				for (int i = coordenadaY - 1; i >= atacante[1]; i--) {
					if (coordenadaX + difX <= 7 && this.getMovimiento(tablero, i, coordenadaX + difX)) {
						return jaqueMate = false;
					}
					difX++;
				}
			}
			difX = 1;
//			Atacante situado en una diagonal izquierda por encima del rey.
			if (coordenadaY > atacante[1] && coordenadaX > atacante[2]
					&& (atacante[0] == AB || atacante[0] == DB || atacante[0] == PB)) {
				for (int i = coordenadaY - 1; i >= atacante[1]; i--) {
					if (coordenadaX - difX >= 0 && this.getMovimiento(tablero, i, coordenadaX - difX)) {
						return jaqueMate = false;
					}
					difX++;
				}
			}
			difX = 1;
//			Atacante situado en una diagonal derecha por debajo del rey.
			if (coordenadaY < atacante[1] && coordenadaX < atacante[2] && (atacante[0] == AB || atacante[0] == DB)) {
				for (int i = coordenadaY + 1; i <= atacante[1]; i++) {
					if (coordenadaX + difX <= 7 && this.getMovimiento(tablero, i, coordenadaX + difX)) {
						return jaqueMate = false;
					}
					difX++;
				}
			}
			difX = 1;
//			Atacante situado en una diagonal izquierda por debajo del rey.
			if (coordenadaY < atacante[1] && coordenadaX > atacante[2] && (atacante[0] == AB || atacante[0] == DB)) {
				for (int i = coordenadaY + 1; i <= atacante[1]; i++) {
					if (coordenadaX - difX >= 0 && this.getMovimiento(tablero, i, coordenadaX - difX)) {
						return jaqueMate = false;
					}
					difX++;
				}
			}
			difX = 1;

			if (atacante[0] == CB && this.getMovimiento(tablero, atacante[1], atacante[2])) {
				return jaqueMate = false;
			}

			return jaqueMate;
		}
//		Devuelve jaqueMate=false ya que no entrá en la primara condiciíon del método, osea que no está en jaque
		return jaqueMate=false;
	}
//	Método para saber si una figura negra puede moverse a esa casilla------------------------------------------------

	public boolean getMovimiento(int[][] array, int Y, int X) {
		boolean movimiento = false;
		int[][] tableroCambiado = new int[8][8];
		int[][] tablero = new int[8][8];
		tablero = array;
		tableroCambiado = array;
		coordenadaY = Y;
		coordenadaX = X;
		
//		Dirección al lado blanco línea recta
		for (int i = coordenadaY - 1; i >= 0; i--) {
			
			if (tablero[i][coordenadaX] > 0 || (tablero[i][coordenadaX] == PN && difY > 1)
					|| tablero[i][coordenadaX] == CN || tablero[i][coordenadaX] == AN
					|| tablero[coordenadaY][i] == RN) {
				break;

			} else if (tablero[i][coordenadaX] == TN || tablero[i][coordenadaX] == DN
					|| tablero[i][coordenadaX] == PN) {
//				Compruebo si moviendo la figura incurrimos en otro jaque.
				tableroCambiado[coordenadaY][coordenadaX] = -1;
				tableroCambiado[i][coordenadaX] = 0;
				if (!jaque.getJaque(tableroCambiado)) {
					return movimiento = true;
				}
				tableroCambiado = tablero;
			}
			difY++;
		}
		difY = 1;
//		Dirección al lado negro línea recta.
		for (int i = coordenadaY + 1; i <= 7; i++) {
			if (tablero[i][coordenadaX] > 0 || (tablero[i][coordenadaX] == PN) || tablero[i][coordenadaX] == CN
					|| tablero[i][coordenadaX] == AN || tablero[coordenadaY][i] == RN) {
				break;
			} else if (tablero[i][coordenadaX] == TN || tablero[i][coordenadaX] == DN) {

				tableroCambiado[coordenadaY][coordenadaX] = -1;
				tableroCambiado[i][coordenadaX] = 0;
				if (!jaque.getJaqueConRey(tableroCambiado)) {	
					return movimiento = true;
				}
				tableroCambiado = tablero;
			}
		}

//		Dirección a izquierda línea recta.
		for (int i = coordenadaX - 1; i >= 0; i--) {
			if (tablero[coordenadaY][i] > 0 || tablero[coordenadaY][i] == PN || tablero[coordenadaY][i] == CN
					|| tablero[coordenadaY][i] == AN || tablero[coordenadaY][i] == RN) {
				break;
			} else if (tablero[coordenadaY][i] == TN || tablero[coordenadaY][i] == DN) {
				tableroCambiado[coordenadaY][coordenadaX] = -1;
				tableroCambiado[coordenadaY][i] = 0;
				if (!jaque.getJaque(tableroCambiado)) {
					return movimiento = true;
				}
				tableroCambiado = tablero;
			}
		}
//		Dirección derecha línea recta
		for (int i = coordenadaX + 1; i <= 7; i++) {
			if (tablero[coordenadaY][i] > 0 || tablero[coordenadaY][i] == PN || tablero[coordenadaY][i] == CN
					|| tablero[coordenadaY][i] == AN || tablero[coordenadaY][i] == RN) {
				break;
			} else if (tablero[coordenadaY][i] == TN || tablero[coordenadaY][i] == DN) {
				tableroCambiado[coordenadaY][coordenadaX] = -1;
				tableroCambiado[coordenadaY][i] = 0;
				if (!jaque.getJaque(tableroCambiado)) {
					return movimiento = true;
				}
				tableroCambiado = tablero;
			}
		}
//		Diagonal derecha hacia lado blanco 
		for (int i = coordenadaY - 1; i >= 0; i--) {
			if ((coordenadaX + difX) <= 7) {

				if (tablero[i][coordenadaX + difX] > 0 || tablero[i][coordenadaX + difX] == TN
						|| tablero[i][coordenadaX + difX] == CN || tablero[i][coordenadaX + difX] == RN
						|| tablero[i][coordenadaX + difX] == PN) {
					break;

				} else if (tablero[i][coordenadaX + difX] == AN || tablero[i][coordenadaX + difX] == DN) {
					tableroCambiado[coordenadaY][coordenadaX] = -1;
					tableroCambiado[i][coordenadaX + difX] = 0;
					if (!jaque.getJaque(tableroCambiado)) {
						return movimiento = true;
					}
					tableroCambiado = tablero;
				}
				difX++;
			}
		}
		difX = 1;
//		Diagonal izquierda hacia lado blanco.
		for (int i = coordenadaY - 1; i >= 0; i--) {
			if ((coordenadaX - difX) >= 0) {

				if (tablero[i][coordenadaX - difX] > 0 || tablero[i][coordenadaX - difX] == TN
						|| tablero[i][coordenadaX - difX] == CN || tablero[i][coordenadaX - difX] == RN
						|| tablero[i][coordenadaX - difX] == PN) {
					break;

				} else if (tablero[i][coordenadaX - difX] == AN || tablero[i][coordenadaX - difX] == DN) {
					tableroCambiado[coordenadaY][coordenadaX] = -1;
					tableroCambiado[i][coordenadaX - difX] = 0;
					if (!jaque.getJaque(tableroCambiado)) {
						return movimiento = true;
					}
					tableroCambiado = tablero;
				}
				difX++;
			}
		}
		difX = 1;

//		Diagonal derecha hacia lado negro.
		for (int i = coordenadaY + 1; i <= 7; i++) {
			if ((coordenadaX + difX) <= 7) {

				if (tablero[i][coordenadaX + difX] > 0 || tablero[i][coordenadaX + difX] == TN
						|| tablero[i][coordenadaX + difX] == CN || tablero[i][coordenadaX + difX] == RN
						|| (tablero[i][coordenadaX + difX] == PN && difX > 1)) {
					break;

				} else if (tablero[i][coordenadaX + difX] == AN || tablero[i][coordenadaX + difX] == DN
						|| (tablero[i][coordenadaX + difX] == PN && tablero[coordenadaY][coordenadaX] > 0)) {
					tableroCambiado[coordenadaY][coordenadaX] = -1;
					tableroCambiado[i][coordenadaX + difX] = 0;
					if (!jaque.getJaque(tableroCambiado)) {
						return movimiento = true;
					}
					tableroCambiado = tablero;
				}
				difX++;
			}
		}
		difX = 1;
//		Diagonal izquierda hacia lado negro.
		for (int i = coordenadaY + 1; i <= 7; i++) {
			if ((coordenadaX - difX) >= 0) {

				if (tablero[i][coordenadaX - difX] > 0 || tablero[i][coordenadaX - difX] == TN
						|| tablero[i][coordenadaX - difX] == CN || tablero[i][coordenadaX - difX] == RN
						|| tablero[i][coordenadaX - difX] == PN && difX > 1) {
					break;

				} else if (tablero[i][coordenadaX - difX] == AN || tablero[i][coordenadaX - difX] == DN
						|| (tablero[i][coordenadaX - difX] == PN && tablero[coordenadaY][coordenadaX] > 0)) {
					tableroCambiado[coordenadaY][coordenadaX] = -1;
					tableroCambiado[i][coordenadaX - difX] = 0;
					if (!jaque.getJaque(tableroCambiado)) {
						return movimiento = true;
					}
					tableroCambiado = tablero;
				}
				difX++;
			}
		}
		difX = 1;
//		Saltos del caballo
		for (int i = -2; i <= 2; i++) {

			difY = coordenadaY + i;

			difX = (int) ((Math.sqrt(5 - Math.pow(i, 2))) + coordenadaX);
			difXN = (int) (-(Math.sqrt(5 - Math.pow(i, 2))) + coordenadaX);

			if (i < 0 && (difY >= 0 && difXN >= 0 && tablero[difY][difXN] == CN
					|| difY >= 0 && difX <= 7 && tablero[difY][difX] == CN)) {
				if (tablero[difY][difX] == CN) {
					tableroCambiado[coordenadaY][coordenadaX] = -1;
					tableroCambiado[difY][difX] = 0;
					if (!jaque.getJaque(tableroCambiado)) {
						return movimiento = true;
					}
					tableroCambiado = tablero;
				} else {
					tableroCambiado[coordenadaY][coordenadaX] = -1;
					tableroCambiado[difY][difXN] = 0;
					if (!jaque.getJaque(tableroCambiado)) {
						return movimiento = true;
					}
					tableroCambiado = tablero;
				}

			}
			if (i > 0 && (difY <= 7 && difXN >= 0 && tablero[difY][difXN] == CN
					|| difY <= 7 && difX <= 7 && tablero[difY][difX] == CN)) {

				if (tablero[difY][difX] == CN) {
					tableroCambiado[coordenadaY][coordenadaX] = -1;
					tableroCambiado[difY][difX] = 0;
					if (!jaque.getJaque(tableroCambiado)) {
						return movimiento = true;
					}
					tableroCambiado = tablero;
				} else {
					tableroCambiado[coordenadaY][coordenadaX] = -1;
					tableroCambiado[difY][difXN] = 0;
					if (!jaque.getJaque(tableroCambiado)) {
						return movimiento = true;
					}
					tableroCambiado = tablero;
				}

			}
		}

		return movimiento;
	}
//	Obtener atacante----------------------------------sería mejor un método setter--------------------------------------------

	public int[] getJaqueFigura(int[][] array) {
//		Declaración de variables
		int[] atacante = new int[3];
		int[][] tablero = new int[8][8];
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

//		Diagonal derecha hacia lado blanco (se evalúa que la casilla este dentro del tablero)
			for (int i = coordenadaY - 1; i >= 0; i--) {
				if ((coordenadaX + difX) <= 7) {
//				Si se encuentra con una figura que no hace jaque
					if (tablero[i][coordenadaX + difX] < 0 || tablero[i][coordenadaX + difX] == TB
							|| tablero[i][coordenadaX + difX] == CB || tablero[i][coordenadaX + difX] == RB
							|| (tablero[i][coordenadaX + difX] == PB && difX > 1)) {
						break;
//					Si se encuentra con una figura que hace jaque
					} else if (tablero[i][coordenadaX + difX] == AB || tablero[i][coordenadaX + difX] == DB
							|| tablero[i][coordenadaX + difX] == PB) {
						atacante[0] = tablero[i][coordenadaX + difX];
						atacante[1] = i;
						atacante[2] = coordenadaX + difX;
						return atacante;
					}
					difX++;
				}
			}
			difX = 1;

//		Diagonal izquierda hacia lado blanco (se evalúa que la casilla este dentro del tablero)
			for (int i = coordenadaY - 1; i >= 0; i--) {
				if ((coordenadaX - difX) >= 0) {
//				Si se encuentra con una figura que no hace jaque
					if (tablero[i][coordenadaX - difX] < 0 || tablero[i][coordenadaX - difX] == TB
							|| tablero[i][coordenadaX - difX] == CB || tablero[i][coordenadaX - difX] == RB
							|| (tablero[i][coordenadaX - difX] == PB && difX > 1)) {
						break;
//					Si se encuentra con una figura que hace jaque
					} else if (tablero[i][coordenadaX - difX] == AB || tablero[i][coordenadaX - difX] == DB
							|| tablero[i][coordenadaX - difX] == PB) {
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
