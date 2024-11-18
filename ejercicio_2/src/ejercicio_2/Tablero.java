package ejercicio_2;

import java.util.HashMap;
import java.util.Random;

public class Tablero {

	static Random random = new Random();

	private int nJugadores;
	private int nPepitas;
	private int nMinas;
	private static HashMap<Posicion, Tipo> diccionarioPosiciones;

	public Tablero(int nJugadores) {
		super();
		this.nJugadores = nJugadores;
	}

	public static void comprobarPosicion() {

	}

	public static HashMap<Posicion, Tipo> crearMapa(int nJugadores) {

		/*
		 * int[] posi; for (int i = 0; i < nJugadores/2; i++) { //posi[i]; }
		 */

		// HashMap<Posicion, Tipo> diccionarioPosiciones = new HashMap<>();

		int x = 15;
		int y = 15;
		int[][] mapa = new int[x][y];
		int k = 0;
		Posicion posAux = null;
		for (int xx = 0; xx < mapa.length; xx++) {
			for (int yy = 0; yy < mapa[xx].length; yy++) {// Creacion del mapa

				int aleatorioXPepita = random.nextInt(mapa.length);
				int aleatorioYPepita = random.nextInt(mapa.length);

				/*
				 * if (aleatorioXPepita == xx && aleatorioYPepita == xx) {
				 * diccionarioPosiciones.put(new Posicion(xx, yy), Tipo.PEPITA); }else {}
				 */
				diccionarioPosiciones.put(posAux = new Posicion(xx, yy), Tipo.VOID);

				if (diccionarioPosiciones.get(posAux) == Tipo.PEPITA) {
					System.out.print(" P ");
				} else if (diccionarioPosiciones.get(posAux) == Tipo.JUGADOR) {
					System.out.print(" J ");
				} else if (diccionarioPosiciones.get(posAux) == Tipo.MINA) {
					System.out.print(" M ");
				} else {
					System.out.print(" X ");
				}
			}
			System.out.println();

		}
		return diccionarioPosiciones;// HashMap que almacena todas las posiciones del array
	}

}
