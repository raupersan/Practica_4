package ejercicio_2;

import java.util.HashMap;
import java.util.Random;

public class Tablero {

	static Random random = new Random();

	private static int nJugadores = 1;
	private static int nPepitas = nJugadores*3;
	private int nMinas;
	private static HashMap<Posicion, Tipo> diccionarioPosiciones;

	public Tablero(int nJugadores) {
		super();
		this.nJugadores = nJugadores;
	}

	public static boolean intentarMover(){
		
		return false;
	}

	public static HashMap creandoMapa() {

		
		int x = 15;
		int y = 15;
		int[][] mapa = new int[x][y];
		Posicion posAux = null;
		for (int xx = 0; xx < mapa.length; xx++) {
			for (int yy = 0; yy < mapa[xx].length; yy++) {// Creacion del mapa
				diccionarioPosiciones.put(posAux = new Posicion(xx, yy), Tipo.VOID);
			}
		}
		
		for (int i = 0; i < nPepitas; i++) {
			int aleatorioXPepita = random.nextInt(mapa.length);
			int aleatorioYPepita = random.nextInt(mapa.length);
			
			
			if (diccionarioPosiciones.get(posAux) == Tipo.VOID) {
			
			diccionarioPosiciones.remove(posAux = new Posicion(aleatorioXPepita, aleatorioYPepita), Tipo.VOID);
			diccionarioPosiciones.put(posAux = new Posicion(aleatorioXPepita, aleatorioYPepita), Tipo.PEPITA);
			
			}else {
				nPepitas++;
			}
			
		}
		
		return diccionarioPosiciones;

	}

	public static void imprimirMapa(int nJugadores) {

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
