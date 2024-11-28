package src.ejercicio_1;

import java.util.Scanner;
import java.util.concurrent.*;

public class Descifrador {

	static Scanner sc = new Scanner(System.in);
	
	/**
	 * Programa que pide al usuario que introduzca una contraseña alfabética
	 * en minúsculas y la descifra por fuerza bruta 
	 */
	
	public static void main(String[] args) {
		String contrasena;
		System.out.println("Introduce tu contraseña");
		contrasena = sc.nextLine();
		contrasena = contrasena.toLowerCase();
		/**
		 * @param contrasena  		Contraseña introducida por el usuario, será alfabética y en minúsculas
		 */
		ExecutorService es = Executors.newFixedThreadPool(26);
		System.out.println("Buscando...");
		for (char a = 'a'; a <= 'z'; a++) {
			/**
			 * <p>
			 * Paralelización de la tarea
			 * <ul>
			 * 		<li>Lanzamos un pool de 26 hilos, uno por cada letra del alfabeto</li>
			 * 		<li>Hacemos un objeto ({@link DescifradorParalelo}), que recibe por parámetros la 
			 * 			inicial con la que va a empezar a probar las contraseñas, la contraseña, la
			 * 			longitud de esta y la contraseña convertida en bytes</li>
			 * 		<li>Haciendo submit llamamos al método run de la clase anteriormente creada, que
			 * 			hereda la clase Thread para implementar la parelización</li>
			 * </ul>
			 * </p>
			 */
			
			es.submit(new DescifradorParalelo(contrasena.length(), contrasena.getBytes(), contrasena, a));
		}
	}
}
