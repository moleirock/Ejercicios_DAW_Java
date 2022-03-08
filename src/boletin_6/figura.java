package boletin_6;

public class figura {
//	  Figuras y valores  
	private static final int PB = 1;
	private static final int TB = 2;
	private static final int CB = 3;
	private static final int AB = 4;
	private static final int RB = 5;
	private static final int DB = 6;
	private static final int PN = -1;
	private static final int TN = -2;
	private static final int CN = -3;
	private static final int AN = -4;
	private static final int RN = -5;
	private static final int DN = -6;

	public static String convierteFigura(int num) {
		switch (num) {
		case PB:
			return "\u2659";
		case TB:
			return "\u2656";
		case CB:
			return "\u2658";

		case AB:
			return "\u2657";

		case RB:
			return "\u2654";

		case DB:
			return "\u2655";

		case PN:
			return "\u265F";

		case TN:
			return "\u265C";

		case CN:
			return "\u265E";

		case AN:
			return "\u265D";

		case RN:
			return "\u265A";

		case DN:
			return "\u265B";

		default:
			return " ";
		}
	}

}
