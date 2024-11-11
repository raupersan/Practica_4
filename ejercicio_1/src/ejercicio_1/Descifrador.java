package ejercicio_1;

import java.util.HashMap;
import java.util.Scanner;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
		final int longitud = 4;
		String contrasena;
		byte[] hash;
		long tiempoSec;
		long tiempoPar;
		Object mapa;
		System.out.println("Introduce tu contraseña de " + longitud + " dígitos");
		contrasena = sc.nextLine();
		hash = getHash(contrasena);

		for (char a = 'a'; a <= 'z'; a++) {
		//	new DescifradorSecuencial().descifrar(a, contrasena.length() - 1, hash);
			new DescifradorParalelo().descifrar(a, contrasena.length() - 1, hash);
			System.out.print(a);
		}
	//	System.out.println("Contraseña descifrada secuencialmente en: " + tiempoSec + " ms");
	//	System.out.println("Contraseña descifrada paralelamente en: " + tiempoPar + " ms");

	}
}
