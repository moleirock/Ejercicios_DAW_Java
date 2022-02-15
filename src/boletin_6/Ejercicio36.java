package boletin_6;

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

	private int coordenadaY;
	private int coordenadaX;

	private int difY = 1;
	private int difX = 1;

	Ejercicio36() {

	}

	public boolean getJaque(int[][] array) {
		tablero = array;

		/* Encontrar al rey */
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (tablero[i][j] == -5) {
					coordenadaY = i;
					coordenadaX = j;
					break;
				}
			}
		}

//		Dirección al lado blanco recto
		for (int i = coordenadaY - 1; i >= 0; i--) {
//			Si se encuentra con una figura que no hace jaque
			if (tablero[i][coordenadaX] < 0 || tablero[i][coordenadaX] == PB || tablero[i][coordenadaX] == CB
					|| tablero[i][coordenadaX] == AB || tablero[i][coordenadaX] == RB) {
				break;
			} else if (tablero[i][coordenadaX] == TB || tablero[i][coordenadaX] == DB) {
				return jaque = true;
			}
		}
//		Dirección al lado negro recto
		for (int i = coordenadaY + 1; i <= 7; i++) {
//			Si se encuentra con una figura que no hace jaque
			if (tablero[i][coordenadaX] < 0 || tablero[i][coordenadaX] == PB || tablero[i][coordenadaX] == CB
					|| tablero[i][coordenadaX] == AB || tablero[i][coordenadaX] == RB) {
				break;
			} else if (tablero[i][coordenadaX] == TB || tablero[i][coordenadaX] == DB) {
				return jaque = true;
			}
		}

//		Dirección a izquierda recto
		for (int i = coordenadaX - 1; i >= 0; i--) {
//			Si se encuentra con una figura que no hace jaque
			if (tablero[coordenadaY][i] < 0 || tablero[coordenadaY][i] == PB || tablero[coordenadaY][i] == CB
					|| tablero[coordenadaY][i] == AB || tablero[coordenadaY][i] == RB) {
				break;
			} else if (tablero[coordenadaY][i] == TB || tablero[coordenadaY][i] == DB) {
				return jaque = true;
			}
		}
//		Dirección derecha
		for (int i = coordenadaX + 1; i <= 7; i++) {
//			Si se encuentra con una figura que no hace jaque
			if (tablero[coordenadaY][i] < 0 || tablero[coordenadaY][i] == PB || tablero[coordenadaY][i] == CB
					|| tablero[coordenadaY][i] == AB || tablero[coordenadaY][i] == RB) {
				break;
			} else if (tablero[coordenadaY][i] == TB || tablero[coordenadaY][i] == DB) {
				return jaque = true;
			}
		}

//		diagonal derecha hacia lado blanco
		for (int i = coordenadaY - 1; i >= 0; i--) {
			if ((coordenadaX + difX) <= 7) {
				if (tablero[i][coordenadaX + difX] < 0 || tablero[i][coordenadaX + difX] == TB
						|| tablero[i][coordenadaX + difX] == CB || tablero[i][coordenadaX + difX] == RB) {
					break;
				} else if (tablero[i][coordenadaX + difX] == AB || tablero[i][coordenadaX + difX] == DB
						|| (tablero[i][coordenadaX + difX] == PB && difX < 2)) {
					return jaque = true;
				}
				difX++;
			}
		}
		difX = 1;

//		diagonal izquierda hacia lado blanco
		for (int i = coordenadaY - 1; i >= 0; i--) {
			if ((coordenadaX - difX) >= 0) {
				if (tablero[i][coordenadaX - difX] < 0 || tablero[i][coordenadaX - difX] == TB
						|| tablero[i][coordenadaX - difX] == CB || tablero[i][coordenadaX - difX] == RB) {
					break;
				} else if (tablero[i][coordenadaX - difX] == AB || tablero[i][coordenadaX - difX] == DB
						|| (tablero[i][coordenadaX - difX] == PB && difX < 2)) {
					return jaque = true;
				}
				difX++;
			}
		}
		difX = 1;

//		diagonal derecha hacia lado negro
		for (int i = coordenadaY + 1; i <= 7; i++) {
			if ((coordenadaX + difX) <= 7) {
				if (tablero[i][coordenadaX + difX] < 0 || tablero[i][coordenadaX + difX] == TB
						|| tablero[i][coordenadaX + difX] == CB || tablero[i][coordenadaX + difX] == RB
						|| (tablero[i][coordenadaX + difX] == PB)) {
					break;
				} else if (tablero[i][coordenadaX + difX] == AB || tablero[i][coordenadaX + difX] == DB) {
					return jaque = true;
				}
				difX++;
			}
		}
		difX = 1;

//		diagonal izquierda hacia lado negro
		for (int i = coordenadaY + 1; i <= 7; i++) {
			if ((coordenadaX - difX) >= 0) {
				if (tablero[i][coordenadaX - difX] < 0 || tablero[i][coordenadaX - difX] == TB
						|| tablero[i][coordenadaX - difX] == CB || tablero[i][coordenadaX - difX] == RB
						|| tablero[i][coordenadaX - difX] == PB) {
					break;
				} else if (tablero[i][coordenadaX - difX] == AB || tablero[i][coordenadaX - difX] == DB) {
					return jaque = true;
				}
				difX++;
			}
		}
		difX = 1;

//		saltos caballo
		
		if (	   coordenadaY - 2 >= 0 && coordenadaX - 1 >= 0 && tablero[coordenadaY - 2][coordenadaX - 1] == CB
				|| coordenadaY - 2 >= 0 && coordenadaX + 1 <= 7 && tablero[coordenadaY - 2][coordenadaX + 1] == CB
				|| coordenadaY - 1 >= 0 && coordenadaX - 2 >= 0 && tablero[coordenadaY - 1][coordenadaX - 2] == CB
				|| coordenadaY + 1 <= 7 && coordenadaX - 2 >= 0 && tablero[coordenadaY + 1][coordenadaX - 2] == CB
				|| coordenadaY + 2 <= 7 && coordenadaX - 1 >= 0 && tablero[coordenadaY + 2][coordenadaX - 1] == CB
				|| coordenadaY + 2 <= 7 && coordenadaX + 1 <= 7 && tablero[coordenadaY + 2][coordenadaX + 1] == CB
				|| coordenadaY + 1 <= 7 && coordenadaX + 2 <= 7 && tablero[coordenadaY + 1][coordenadaX + 2] == CB
				|| coordenadaY - 1 >= 0 && coordenadaX + 2 <= 7 && tablero[coordenadaY - 1][coordenadaX + 2] == CB) {

			return jaque = true;
		}
		
		return jaque;
	}
	
	
	public static void main(String args[]) {
		Ejercicio36 juego=new Ejercicio36();
		
		int[][] tablero=new int[8][8];
		for (int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				tablero [i][j]=0;
			}
		}
		tablero[0][1]=-5;
		tablero[7][1]=2;
		
		System.out.println(juego.getJaque(tablero));
		
	}

}
