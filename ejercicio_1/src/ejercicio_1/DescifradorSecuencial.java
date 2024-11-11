package ejercicio_1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class DescifradorSecuencial {

	public long descifrar(int ini, int longitud, byte[] contraseña) {
		// TODO Auto-generated method stub

		Scanner teclado = new Scanner(System.in);
		boolean encontrado = false;

		char c = (char) ini;
		final String cadena = "abcdefghijklmnñopqrstuvwxyz";

		String aleatorio = "";
		int contador = 0;

		long hora;
		long tiempoFinal = 0;
		do {
			hora = System.currentTimeMillis();

			for (int j = 0; j <longitud; j++) {
				
			
			for (char i = 'a'; i <= 'z'; i++) {

				aleatorio = aleatorio + i;
				System.out.println("aleatorio: " + aleatorio.toString() + " " + "contraseña: " + contraseña);

				contador++;
				if (aleatorio.equals(contraseña)) {
					tiempoFinal = System.currentTimeMillis() - hora;
					encontrado = true;
				}
				if (encontrado == true)
					i = 'z';

			}
			//aleatorio = aleatorio + cadena.charAt(i);
			}
			System.out.println("aleatorio: " + aleatorio + " " + "contraseña: " + contraseña);
		} while (!aleatorio.equals(contraseña));
		System.out.println("El numero de intentos ha sido de: " + contador);
		teclado.close();
		return tiempoFinal;
	}

}
