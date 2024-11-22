package src.ejercicio_1;

import java.util.Scanner;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.*;

public class Descifrador {

	static Scanner sc = new Scanner(System.in);

	public static byte[] getHash(String text) {
		byte[] encodedhash = null;
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("SHA-256");
			encodedhash = digest.digest(text.getBytes(StandardCharsets.UTF_8));
		} catch (NoSuchAlgorithmException e) {
			//
			e.printStackTrace();
		}
		return encodedhash;
	}

	public static void main(String[] args) {
		int longitud = 4;
		String contrasena;
		long tiempo;
		long tiempoFinal;
		Object mapa;
		System.out.println("Introduce tu contraseña");
		contrasena = sc.nextLine();
		tiempo=System.currentTimeMillis();
		ExecutorService es = Executors.newFixedThreadPool(26);

		for (char a = 'a'; a <= 'z'; a++) {
			DescifradorParalelo aux;
			es.submit(aux = new DescifradorParalelo(contrasena.length(), contrasena.getBytes(), contrasena, a,false));
			
		}
		tiempoFinal=System.currentTimeMillis()-tiempo;
		
		System.out.println("Contraseña descifrada en: " + tiempoFinal + " ms");
	}
}
