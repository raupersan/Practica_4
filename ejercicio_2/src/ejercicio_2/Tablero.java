package ejercicio_2;

import java.util.HashMap;
import java.util.Random;

public class Tablero {

	static Random random = new Random();

	private static int nJugadores = 1;
	private static int nPepitas = nJugadores*3;
	private static int nMinas = nJugadores/2;
	private static HashMap<Posicion, Tipo> diccionarioPosiciones;

	public Tablero(int nJugadores) {
		super();
		this.nJugadores = nJugadores;
	}

	public static boolean intentarMover(){
		
		return false;
	}

	public static HashMap crearMapa() {

		
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
			int aleatorioXPepita = random.nextInt(mapa.length);//Posicion aleatorio para la x
			int aleatorioYPepita = random.nextInt(mapa.length);//posicion aleatorio para la y
			
			
			if (diccionarioPosiciones.get(posAux) == Tipo.VOID) {
			
			diccionarioPosiciones.remove(posAux = new Posicion(aleatorioXPepita, aleatorioYPepita), Tipo.VOID);//quitas del hashmap  el vacio
			diccionarioPosiciones.put(posAux = new Posicion(aleatorioXPepita, aleatorioYPepita), Tipo.PEPITA);//añades al hashmap
			
			}else {//si intenta entrar en una casilla que no esta vacia se le suma 1 al numero de pepitas para "rehacer" el intento
				nPepitas++;
			}
			
		}
		
		for (int i = 0; i < nMinas; i++) {
			int aleatorioXMina = random.nextInt(mapa.length);//Posicion aleatorio para la x
			int aleatorioYMina = random.nextInt(mapa.length);//posicion aleatorio para la y
			
			
			if (diccionarioPosiciones.get(posAux) == Tipo.VOID) {//Entra en el if solo si el hueco que estamos comprobando esta vacio
			
			diccionarioPosiciones.remove(posAux = new Posicion(aleatorioXMina, aleatorioYMina), Tipo.VOID);//quitas del hashmap  el vacio
			diccionarioPosiciones.put(posAux = new Posicion(aleatorioXMina, aleatorioYMina), Tipo.MINA);//añades al hashmap
			
			}else {//si intenta entrar en una casilla que no esta vacia se le suma 1 al numero de minas para "rehacer" el intento
				nMinas++;
			}
			
		}
		imprimirMapa(nJugadores);
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
