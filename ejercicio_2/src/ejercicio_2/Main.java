package ejercicio_2;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
	
	static Scanner sc = new Scanner(System.in);
	private static void iniciarTablero(HashMap tablero) {
		
	}
	public static void main(String[] args) {
		HashMap tablero;
		int nJugadores;
		System.out.println("Introduce el número de jugadores");
		nJugadores= sc.nextInt();
		iniciarTablero(tablero, nJugadores);
	}

	

}
