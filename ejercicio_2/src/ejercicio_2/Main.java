package ejercicio_2;

import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
	
	static Scanner sc = new Scanner(System.in);
	private static void iniciarTablero(HashMap tablero,int nJugadores) {
		
	}
	
	public static void crearMapa() {
		
		int x = 17;
		int y = 17;
		int[][] mapa = new int[x][y];
		int k = 0;
		for (int i = 0; i < mapa.length; i++) {
			for (int j = 0; j < mapa[i].length; j++) {
				if (i == 0) {
					System.out.print("__ ");
				} else if (i == x - 1) {

					System.out.print("¯¯ ");

				} else if (j == 0 || j == 16) {
					System.out.print("|");
				} else if ((j == 16 && i == 0)||(j==16 && i == 17)) {

					System.out.println();

				} else {
					System.out.print(" x ");
				}
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		HashMap tablero = null;
		int nJugadores;
		do {
		System.out.println("Introduce el número de jugadores");
		nJugadores= sc.nextInt();
			if(nJugadores>100) {
				
			}
		}while (nJugadores>100);
        ExecutorService es = Executors.newFixedThreadPool(nJugadores);
        CyclicBarrier barrera = new CyclicBarrier(nJugadores, () -> {
            System.out.println("Todos los jugadores han hecho su movimiento.");
        });
       
		//iniciarTablero(nJugadores);

		crearMapa();

		 for (int i = 0; i < nJugadores; i++) {
			 Integer id = i+1;
				es.submit(new Jugador(id,0 ,new Posicion(0,0) , barrera));
			}
		 

	}

	

}
