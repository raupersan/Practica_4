package ejercicio_2;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	static Scanner sc = new Scanner(System.in);

	/*private static void iniciarTablero(HashMap tablero, int nJugadores) {

	}*/

	public static HashMap<Posicion, Tipo> crearMapa() {

		HashMap<Posicion, Tipo> diccionarioPosiciones = new HashMap<>();

		int x = 17;
		int y = 17;
		int[][] mapa = new int[x][y];
		int k = 0;
		for (int xx = 0; xx < mapa.length; xx++) {
			for (int yy = 0; yy < mapa[xx].length; yy++) {

				diccionarioPosiciones.put(new Posicion(xx, yy), null);

				if (xx == 0) {
					System.out.print("__ ");
				} else if (xx == x - 1) {

					System.out.print("¯¯ ");

				} else if (yy == 0 || yy == 16) {
					System.out.print("|");
				} else if ((yy == 16 && xx == 0) || (yy == 16 && xx == 17)) {

					System.out.println();

				} else {
					System.out.print(" x ");
				}
			}
			System.out.println();

		}
		return diccionarioPosiciones;
	}

	public static void main(String[] args) {
		HashMap tablero = null;
		int nJugadores;
		Jugador j;
		do {
			System.out.println("Introduce el número de jugadores");
			nJugadores = sc.nextInt();
			if (nJugadores > 10) {
				System.out.println("Hay demasiados jugadores, no se podría rellenar el tablero");
			}
		} while (nJugadores > 10);
		ExecutorService es = Executors.newFixedThreadPool(nJugadores);
		
		CyclicBarrier barrera = new CyclicBarrier(nJugadores, () -> {
			//nJugadore== numero de hilos
			//Tiene que ser atributo del hilo construido
			System.out.println("Todos los jugadores han hecho su movimiento.");
		});

		// iniciarTablero(nJugadores); 

		tablero = new Tablero(nJugadores);
		Random random = new Random();
		for (int i = 0; i < nJugadores; i++) {
			Integer id = i + 1;
			// es.submit(new Jugador(id, 0, new Posicion(random.nextInt(15),
			// random.nextInt(15)), barrera, Tipo.JUGADOR));
			j = new Jugador(id, 0, new Posicion(random.nextInt(15), random.nextInt(15)), barrera, Tipo.JUGADOR);
			j.mover(tablero);
		}
	}
}
