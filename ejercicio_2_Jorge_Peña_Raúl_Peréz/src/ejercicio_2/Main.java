package ejercicio_2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static Random random = new Random();

	public static void main(String[] args) {
		Tablero tablero;
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

			System.out.println("Todos los jugadores han hecho su movimiento.");
		});
		// iniciarTablero(nJugadores);
		System.out.println("Indica el tamaño del tablero");
		int tamTablero = sc.nextInt();
		tablero = new Tablero(tamTablero, nJugadores);
		tablero.crearMapa();
		Random random = new Random();
		for (int i = 0; i < nJugadores; i++) {
			Posicion posInicial = generarPosicion(tablero);
			Jugador jugador = new Jugador(i + 1, 0, posInicial, barrera, Tipo.JUGADOR, tablero);
			es.submit(jugador);
		}
		;
		es.shutdown();

	}

}
