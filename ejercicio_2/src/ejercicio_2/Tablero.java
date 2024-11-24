package ejercicio_2;

import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class Tablero {

	static Random random = new Random();

	private static int nJugadores = 1;
	private static int nPepitas = nJugadores * 3;
	private static int nMinas = nJugadores / 2;
	private ConcurrentHashMap<Posicion, Tipo> diccionarioPosiciones;

	public Tablero(int nJugadores) {
		super();
		this.nJugadores = nJugadores;
		diccionarioPosiciones = new ConcurrentHashMap<Posicion, Tipo>();
	}

	public boolean intentarMover(Posicion pos) {

		if (diccionarioPosiciones.get(pos).equals(Tipo.VOID)) {
			return true;
		} else {
			return false;
		}

	}

	public ConcurrentHashMap crearMapa() {

		int x = 15;
		int y = 15;
		int[][] mapa = new int[x][y];

		for (int xx = 0; xx < mapa.length; xx++) {
			for (int yy = 0; yy < mapa[xx].length; yy++) {// Creacion del mapa

				diccionarioPosiciones.put(new Posicion(xx, yy), Tipo.VOID);

			}
		}
		System.out.println(diccionarioPosiciones);
		Posicion posAux;
		for (int i = 0; i < nPepitas; i++) {
			int aleatorioXPepita = random.nextInt(mapa.length);// Posicion aleatorio para la x
			int aleatorioYPepita = random.nextInt(mapa.length);// posicion aleatorio para la y
			posAux = new Posicion(aleatorioXPepita, aleatorioYPepita);

			if (diccionarioPosiciones.containsKey(posAux)) {
				if (diccionarioPosiciones.get(posAux).compareTo(Tipo.VOID) == 0) {

					diccionarioPosiciones.remove(posAux, Tipo.VOID);// quitas del hashmap el vacio
					diccionarioPosiciones.put(posAux, Tipo.PEPITA);// añades al hashmap

				} else {// si intenta entrar en una casilla que no esta vacia se le suma 1 al numero de
						// pepitas para "rehacer" el intento
					i--;
				}
			}

		}

		for (int i = 0; i < nMinas; i++) {
			int aleatorioXMina = random.nextInt(mapa.length);// Posicion aleatorio para la x
			int aleatorioYMina = random.nextInt(mapa.length);// posicion aleatorio para la y
			posAux = new Posicion(aleatorioXMina, aleatorioYMina);
			System.out.println("For de minas");
			if (diccionarioPosiciones.get(posAux) == Tipo.VOID) {// Entra en el if solo si el hueco que estamos
																	// comprobando esta vacio

				diccionarioPosiciones.remove(posAux, Tipo.VOID);// quitas del hashmap el vacio
				diccionarioPosiciones.put(posAux, Tipo.MINA);// añades al hashmap

			} else {// si intenta entrar en una casilla que no esta vacia se le suma 1 al numero de
					// minas para "rehacer" el intento
				i--;
			}

		}
		imprimirMapa(nJugadores);
		return diccionarioPosiciones;

	}

	public void imprimirMapa(int nJugadores) {

		int x = 15;
		int y = 15;
		int[][] mapa = new int[x][y];
		int k = 0;

		for (int xx = 0; xx < mapa.length; xx++) {
			for (int yy = 0; yy < mapa[xx].length; yy++) {// Creacion del mapa

				Posicion posAux = new Posicion(xx, yy);

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

	}

}
