package ejercicio_2;

import java.util.HashMap;
import java.util.Scanner;

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
		iniciarTablero(tablero, nJugadores);
		crearMapa();
	}

	

}
