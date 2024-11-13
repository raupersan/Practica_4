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
		HashMap tablero;
		int nJugadores;
		System.out.println("Introduce el número de jugadores");
		nJugadores= sc.nextInt();
        ExecutorService es = Executors.newFixedThreadPool(nJugadores);
        CyclicBarrier barrera = new CyclicBarrier(2, () -> {
            System.out.println("Todos los jugadores han hecho 2 movimientos.");
        });
       
       
		iniciarTablero(tablero, nJugadores);
<<<<<<< HEAD
		crearMapa();
=======
		
		 for (int i = 0; i < nJugadores; i++) {
			 Integer nombre = i+1;
			 String nom = nombre.toString();
				es.submit(new Jugador(nom,0 ,new Posicion(0,0) , barrera));
			}
		 
>>>>>>> 4bbc78dd059f7e117bbfa87f35cd0d6b49b32fc3
	}

	

}
