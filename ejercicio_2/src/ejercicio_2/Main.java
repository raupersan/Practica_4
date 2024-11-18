package ejercicio_2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	static Scanner sc = new Scanner(System.in);
	static Random random = new Random();


	public static void main(String[] args) {
		Tablero tablero = null;
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
		/*for (int i = 0; i < nJugadores; i++) {
			Integer id = i + 1;
			// es.submit(new Jugador(id, 0, new Posicion(random.nextInt(15),
			// random.nextInt(15)), barrera, Tipo.JUGADOR));
			j = new Jugador(id, 0, new Posicion(random.nextInt(15), random.nextInt(15)), barrera, Tipo.JUGADOR, tablero);
			j.mover(tablero);
		}
		*/
		tablero.crearMapa();
		
	}
}
