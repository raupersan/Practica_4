package src.ejercicio_1;

import java.util.Scanner;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.*;

public class Descifrador {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int longitud = 4;
		String contrasena;
		//long tiempo;
		//long tiempoFinal;
		Object mapa;
		System.out.println("Introduce tu contraseña");
		contrasena = sc.nextLine();
		//tiempo = System.currentTimeMillis();
		ExecutorService es = Executors.newFixedThreadPool(26);
		System.out.println("Buscando...");
		for (char a = 'a'; a <= 'z'; a++) {
			DescifradorParalelo aux;
			es.submit(aux = new DescifradorParalelo(contrasena.length(), contrasena.getBytes(), contrasena, a));

		}
		//tiempoFinal = System.currentTimeMillis() - tiempo;

		//System.out.println("Contraseña descifrada en: " + tiempoFinal + " ms");
	}
}
