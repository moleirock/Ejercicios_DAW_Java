package boletin_6;

import java.util.*;

//36. DUF que toma una tabla bidimensional de enteros, representando un tablero de ajedrez.
//Disponemos de las constantes PB (peón blanco), TN (torre negra), etc. (P, T, C, A, R, D). Dicho
//módulo debe devolver un valor booleano, que indique si el rey negro está amenazado.

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


//  Coordenadas del rey negro
	private int coordenadaY;
	private int coordenadaX;

// Diferenciales(contadores) para usar en los movimientos de las figuras, o como variables auxiliares.
	private int difY = 1;
	private int difX = 1;
	private int difXN = 1;

	Ejercicio36() {

	}

//	Comienzo del método jaque, se base en evaluar si el rey está amenazado, para ello se fija la coordenada 
//	donde está situado el rey y desde ella se busca figuras rivales simulando su movimiento(el movimiento de las figuras rivales).
	public boolean getJaque(int[][] array) {
		boolean jaque = false;
		int[][] tablero = new int[8][8];
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
		
//		Dirección al lado blanco línea recta (se evalúa que la casilla este dentro del tablero). Se recorre el array aumentando 
//		o disminuyendo una de sus coordenadas.
		for (int i = coordenadaY - 1; i >= 0; i--) {
//			Si se encuentra con una figura que no hace jaque interrumpe y pasa a la siguiente iteración.
			if (tablero[i][coordenadaX] < 0 || tablero[i][coordenadaX] == PB || tablero[i][coordenadaX] == CB
					|| tablero[i][coordenadaX] == AB || tablero[i][coordenadaX] == RB) {
				break;
//				Si se encuentra con una figura que hace jaque, finaliza el método y devuelve verdadero. En este caso sabemos que la 
//				torre blanca y la dama blanca son las únicas figuras que pueden moverse en línea recta y hacer jaque.
			} else if (tablero[i][coordenadaX] == TB || tablero[i][coordenadaX] == DB) {
				return jaque = true;
			}
		}

//		Dirección al lado negro línea recta (se evalúa que la casilla este dentro del tablero).
		for (int i = coordenadaY + 1; i <= 7; i++) {
//			Si se encuentra con una figura que no hace jaque interrumpe y pasa a la siguiente iteración.
			if (tablero[i][coordenadaX] < 0 || tablero[i][coordenadaX] == PB || tablero[i][coordenadaX] == CB
					|| tablero[i][coordenadaX] == AB || tablero[i][coordenadaX] == RB) {
				break;
//				Si se encuentra con una figura que hace jaque, finaliza el método y devuelve verdadero. 
			} else if (tablero[i][coordenadaX] == TB || tablero[i][coordenadaX] == DB) {
				return jaque = true;
			}
		}
		
//		Dirección a izquierda línea recta (se evalúa que la casilla este dentro del tablero)
		for (int i = coordenadaX - 1; i >= 0; i--) {
//			Si se encuentra con una figura que no hace jaque interrumpe y pasa a la siguiente iteración.
			if (tablero[coordenadaY][i] < 0 || tablero[coordenadaY][i] == PB || tablero[coordenadaY][i] == CB
					|| tablero[coordenadaY][i] == AB || tablero[coordenadaY][i] == RB) {
				break;
//				Si se encuentra con una figura que hace jaque, finaliza el método y devuelve verdadero. 
			} else if (tablero[coordenadaY][i] == TB || tablero[coordenadaY][i] == DB) {
				return jaque = true;
			}
		}
//		Dirección derecha línea recta (se evalúa que la casilla este dentro del tablero)
		for (int i = coordenadaX + 1; i <= 7; i++) {
//			Si se encuentra con una figura que no hace jaque interrumpe y pasa a la siguiente iteración.
			if (tablero[coordenadaY][i] < 0 || tablero[coordenadaY][i] == PB || tablero[coordenadaY][i] == CB
					|| tablero[coordenadaY][i] == AB || tablero[coordenadaY][i] == RB) {
				break;
//				Si se encuentra con una figura que hace jaque, finaliza el método y devuelve verdadero. 
			} else if (tablero[coordenadaY][i] == TB || tablero[coordenadaY][i] == DB) {
				return jaque = true;
			}
		}

//		Diagonal derecha hacia lado blanco (se evalúa que la casilla este dentro del tablero). Se recorre el array aumentando 
//		o disminuyendo las dos coordenadas.
		for (int i = coordenadaY - 1; i >= 0; i--) {
			if ((coordenadaX + difX) <= 7) {
//			Si se encuentra con una figura que no hace jaque interrumpe y pasa a la siguiente iteración.
				if (tablero[i][coordenadaX + difX] < 0 || tablero[i][coordenadaX + difX] == TB
						|| tablero[i][coordenadaX + difX] == CB || tablero[i][coordenadaX + difX] == RB
						|| (tablero[i][coordenadaX + difX] == PB && difX > 1)) {
					break;
//					Si se encuentra con una figura que hace jaque, finaliza el método y devuelve verdadero. En este caso las 
//					figuras que hacen jaque son las que se mueven en diagonal, un caso especial es el peón que solo hace jaque si está en una casilla adyacente en diagonal hacia el lado blanco.
				} else if (tablero[i][coordenadaX + difX] == AB || tablero[i][coordenadaX + difX] == DB
						|| tablero[i][coordenadaX + difX] == PB) {
					return jaque = true;
				}
				difX++;
			}
		}
		difX = 1;

//		Diagonal izquierda hacia lado blanco (se evalúa que la casilla este dentro del tablero).
		for (int i = coordenadaY - 1; i >= 0; i--) {
			if ((coordenadaX - difX) >= 0) {
//			Si se encuentra con una figura que no hace jaque interrumpe y pasa a la siguiente iteración.
				if (tablero[i][coordenadaX - difX] < 0 || tablero[i][coordenadaX - difX] == TB
						|| tablero[i][coordenadaX - difX] == CB || tablero[i][coordenadaX - difX] == RB
						|| (tablero[i][coordenadaX - difX] == PB && difX > 1)) {
					break;
//					Si se encuentra con una figura que hace jaque, finaliza el método y devuelve verdadero. 
				} else if (tablero[i][coordenadaX - difX] == AB || tablero[i][coordenadaX - difX] == DB
						|| tablero[i][coordenadaX - difX] == PB ) {
					return jaque = true;
				}
				difX++;
			}
		}
		difX = 1;

//		Diagonal derecha hacia lado negro (se evalúa que la casilla este dentro del tablero).
		for (int i = coordenadaY + 1; i <= 7; i++) {
			if ((coordenadaX + difX) <= 7) {
//			Si se encuentra con una figura que no hace jaque interrumpe y pasa a la siguiente iteración.
				if (tablero[i][coordenadaX + difX] < 0 || tablero[i][coordenadaX + difX] == TB
						|| tablero[i][coordenadaX + difX] == CB || tablero[i][coordenadaX + difX] == RB
						|| tablero[i][coordenadaX + difX] == PB) {
					break;
//					Si se encuentra con una figura que hace jaque, finaliza el método y devuelve verdadero. 
				} else if (tablero[i][coordenadaX + difX] == AB || tablero[i][coordenadaX + difX] == DB) {
					return jaque = true;
				}
				difX++;
			}
		}
		difX = 1;

//		Diagonal izquierda hacia lado negro (se evalúa que la casilla este dentro del tablero).
		for (int i = coordenadaY + 1; i <= 7; i++) {
			if ((coordenadaX - difX) >= 0) {
//			Si se encuentra con una figura que no hace jaque interrumpe y pasa a la siguiente iteración.
				if (tablero[i][coordenadaX - difX] < 0 || tablero[i][coordenadaX - difX] == TB
						|| tablero[i][coordenadaX - difX] == CB || tablero[i][coordenadaX - difX] == RB
						|| tablero[i][coordenadaX - difX] == PB) {
					break;
//					Si se encuentra con una figura que hace jaque, finaliza el método y devuelve verdadero. 
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

//			Se toma i como incremento de la coordenadaY y se calcula la coordenadaX en funcíon de los valores que puede tomar.
			difY = coordenadaY + i;

//			Ecuación de la circunferencia(semicircunferencia)(pitágoras) se declarán dos variables para cada mitad de la circunferencia. (radio^2=5)
//			En la ecuación de la circunferencia hay que restar a la coordenada Y del punto la coordenada Y del centro de la circunferencia pero nosotros 
//			ya tenemos hecho ese calculo que es lo que nos da i(i=difY - coordenadaY).
			difX = (int) ((Math.sqrt(5 - Math.pow(i, 2))) + coordenadaX);
			difXN = (int) (-(Math.sqrt(5 - Math.pow(i, 2))) + coordenadaX);

//			Cada condicion representa una mitad de la circunferencia( se evalúa que la casilla este dentro del tablero).
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

//		Instancia
		Ejercicio36 juego = new Ejercicio36();

//		Añadiendo posición y figura que hace jaque, Instancio un objeto de la clase "Ejercicio37" para probar el método de obtención del  tipo y posición 
//		de lafigura que hace jaque (getJaqueFigura).
		Ejercicio37 mate = new Ejercicio37();
		int[] figuraAtacante = new int[3];

		Scanner sc = new Scanner(System.in);

		int y;
		int x;
		String confirmacion = "s";
		int[][] tablero = new int[8][8];
		
		

//		Texto con instrucciónes para el desarrollo del juego.
		
		System.out.println("---------------------------------------------------------------------------------------");
		System.out.println("\t\t\t¿Está en jaque nuestro amado rey negro? ");
		System.out.println("---------------------------------------------------------------------------------------");
		System.out.println("Coloca las figuras en nuestro tablero virtual, para ello debes de indicar las coordenadas\n"
				+ "donde están colocadas y que figura está colocada en dicha coordenada.\n\n"
				+ "Para ello toma como origen de coordenadas(0,0) la casilla dónde coloca el jugador blanco,al principio \n"
				+ "de la partida, su torre del lado derecho.\n\n"
				+ "Indícame con valores de que figura se trata, ayúdate de esta tabla para identificar la \n"
				+ "figura. ¡No te olvides de incluir al rey negro!\n\n" + "Peón Blanco = 1 \u2659\n" + "Torre Blanca = 2 \u2656\n"
				+ "Caballo Blanco = 3 \u2658\n" + "Alfil Blanco = 4 \u2657\r\n" + "Rey Blanco = 5 \u2654 \n" + "Dama Blanca = 6 \u2655\n"
				+ "Peón Negro = -1 \u265F\n" + "Torre Negra = -2 \u265C\n" + "Caballo Negro = -3 \u265E\n" + "Alfil Negro = -4 \u265D\n"
				+ "Rey Negro = -5 \u265A\n"
				+ "Dama Negra = -6 \u265B\n---------------------------------------------------------------------------------------");

//		Pruebas estáticas, comentar antes la inserción de datos por teclado
//		tablero[7][6]=-5;
//		tablero[7][7]=-1;
//		tablero[4][3]=4;
//		tablero[7][5]=-1;
//		tablero[6][2]=2;
//		tablero[7][2]=2;
//		tablero[3][4]=-2;
		
		
		while (confirmacion.equalsIgnoreCase("s")) {
			System.out.println("Introduce la coordenada 'Y' y la coordenada 'X', en ese orden.");
			y = sc.nextInt();
			x = sc.nextInt();					
			while (y < 0 || y > 7 || x < 0 || x > 7) {
				System.out.println(
						"Recuerda que las coordenadas tienen que ser números enteros entre 0 y 7, introduclos de\nnuevo en el mismo orden");
				y = sc.nextInt();
				x = sc.nextInt();
			}
			System.out.println("Introduce el valor de la figura que está en esta coordenada");
			tablero[y][x] = sc.nextInt();

			while (tablero[y][x] < -6 || tablero[y][x] > 6) {
				System.out.println("No es un valor válido, introducelo de nuevo");
				tablero[y][x] = sc.nextInt();
			}

//			Imprimir tablero
			System.out.println("\nEl tablero queda así.\n");
			System.out
					.println("---------------------------------\n\t    Lado Blanco\n---------------------------------");
			for (int i = 0; i < 8; i++) {
				System.out.print("| ");
				for (int j = 0; j < 8; j++) {
					System.out.print(figura.convierteFigura(tablero[i][j])+" | ");
				}

				System.out.println("\n---------------------------------");
			}
			System.out.println("\t    Lado Negro\n---------------------------------\n");

			System.out.println("¿Quieres añadir una nueva figura? Responde sí(S) o no(N).");
			confirmacion = sc.next();
			while (!confirmacion.equalsIgnoreCase("s") && !confirmacion.equalsIgnoreCase("n")) {
				System.out.println("Responde (S) o (N).");
				confirmacion = sc.next();
			}
	     }

		figuraAtacante = mate.getJaqueFigura(tablero);
		System.out.println(juego.getJaque(tablero)
				? "¡Nuestro rey está amenazado, haz algo para evitar el jaque!" + "la figura es " + figura.convierteFigura(figuraAtacante[0])
						+ " y está en la posición " + figuraAtacante[1] + "," + figuraAtacante[2]
				: "¡Nuestro rey está seguro, larga vida al rey!");
		
		
		
		
//		PROBANDO JAQUE MATE EJERCICIO 37
		System.out.println(mate.getJaqueMate(tablero)?"Es jaque mate, fin de la partida":"El jaque NO es mate, aún hay esperanza ");
		
		sc.close();
	}

//--------------------------------------------------------------------------------------------------------------------------
//	Método de jaque incluyendo la figura del rey como posible figura que hace jaque para usarla en el Ejercicio37. Se limpia 
//	el código para que no sea tan extenso pero el método es igual a getJaque(con una variación).
	public boolean getJaqueConRey(int[][] array) {
		boolean jaque = false;
		int[][] tablero = new int[8][8];
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
		
		
//		Dirección al lado blanco línea recta
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
//		Dirección al lado negro línea recta (se evalúa que la casilla este dentro del tablero).
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

//		Dirección a izquierda línea recta (se evalúa que la casilla este dentro del tablero)
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
//		Dirección derecha línea recta (se evalúa que la casilla este dentro del tablero)
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
		
//		Diagonal derecha hacia lado negro (se evalúa que la casilla este dentro del tablero).
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
		
//		Diagonal izquierda hacia lado negro (se evalúa que la casilla este dentro del tablero).
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
		
		return jaque;
	}

//	--------------------------------------------------------------------------------------------------------------------
//	Método para traducir los códigos de las figuras en caracteres unicode
}
