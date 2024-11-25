package ejercicio_2;

import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class Tablero {

	static Random random = new Random();

	private int tamañoTablero = 15;
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

		int x = tamañoTablero;
		int y = tamañoTablero;
		int[][] mapa = new int[x][y];
		Posicion aux2;

		System.out.println(diccionarioPosiciones);
		Posicion posAux;
		
		for (int i = 0; i < nPepitas; i++) {
			
			int aleatorioXPepita = random.nextInt(tamañoTablero);// Posicion aleatorio para la x
			int aleatorioYPepita = random.nextInt(tamañoTablero);// posicion aleatorio para la y
			posAux = new Posicion(aleatorioXPepita, aleatorioYPepita);

/**/			if (diccionarioPosiciones.containsKey(posAux)) {
				 System.out.println("Posición ya existe en el diccionario: " + posAux);
				if (Tipo.VOID.equals(diccionarioPosiciones.get(posAux))) {
				
					diccionarioPosiciones.put(posAux, Tipo.PEPITA);//Remplazas el valor vacio por una pepita
				} else {// si intenta entrar en una casilla que no esta vacia se le suma 1 al numero de
						// pepitas para "rehacer" el intento
					i--;
				}
			}

		}

		for (int i = 0; i < nMinas; i++) {
			int aleatorioXMina = random.nextInt(tamañoTablero);// Posicion aleatorio para la x
			int aleatorioYMina = random.nextInt(tamañoTablero);// posicion aleatorio para la y
			posAux = new Posicion(aleatorioXMina, aleatorioYMina);
			System.out.println("For de minas");
			if (diccionarioPosiciones.get(posAux) == Tipo.VOID) {// Entra en el if solo si el hueco que estamos
																	// comprobando esta vacio

				diccionarioPosiciones.put(posAux, Tipo.MINA);//Remplazas el valor vacio por una mina

			} else {// si intenta entrar en una casilla que no esta vacia se le suma 1 al numero de
					// minas para "rehacer" el intento
				i--;
			}

		}
		
		for (int xx = 0; xx < tamañoTablero; xx++) {
			for (int yy = 0; yy < mapa[xx].length; yy++) {// Creacion del mapa
				aux2 = new Posicion(xx,yy); 
				if (diccionarioPosiciones.get(aux2)== null) {
					diccionarioPosiciones.put(new Posicion(xx, yy), Tipo.VOID);
				}
				

			}
		}
		
		imprimirMapa(nJugadores);
		return diccionarioPosiciones;

	}

	public void imprimirMapa(int nJugadores) {

		int x = tamañoTablero;
		int y = tamañoTablero;
		int[][] mapa = new int[x][y];
		int k = 0;

		for (int xx = 0; xx < tamañoTablero; xx++) {
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

	public boolean esPosicionVacia(Posicion pos) {
		return !diccionarioPosiciones.containsKey(pos);
	}

	private Posicion generarPosicionAleatoria() {
		Random random = new Random();
		Posicion pos;
		do {
			pos = new Posicion(random.nextInt(tamañoTablero), random.nextInt(tamañoTablero));
		} while (diccionarioPosiciones.containsKey(pos));
		return pos;
	}
}