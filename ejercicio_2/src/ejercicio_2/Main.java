package ejercicio_2;

import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
	
	static Scanner sc = new Scanner(System.in);
	private static void iniciarTablero(HashMap tablero) {
		
	}
	public static void main(String[] args) {
		HashMap tablero;
		int nJugadores;
		System.out.println("Introduce el número de jugadores");
		nJugadores= sc.nextInt();
        ExecutorService es = Executors.newFixedThreadPool(nJugadores);
        CyclicBarrier barrera = new CyclicBarrier(2, () -> {
            System.out.println("Todos los jugadores han hecho 2 movimientos.");
        });
       
       
		iniciarTablero(tablero, nJugadores);
		
		 for (int i = 0; i < nJugadores; i++) {
			 Integer nombre = i+1;
			 String nom = nombre.toString();
				es.submit(new Jugador(nom,0 ,new Posicion(0,0) , barrera));
			}
		 
	}

	

}
