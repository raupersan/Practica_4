package src.ejercicio_1;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;

public class DescifradorParalelo extends Thread {
	private int longitud;
	private byte[] contraseña;
	private String palabra;
	private char letra;
	
	/**/long tiempo;
	/**/long tiempoFinal;
	
	
	public DescifradorParalelo(int longitud, byte[] contraseña, String palabra, char letra) {
		this.longitud = longitud;
		this.contraseña = contraseña;
		this.palabra = palabra;
		this.letra = letra;
	}

	public void descifrar() throws InterruptedException {
		String aux;
	/**/	tiempo = System.currentTimeMillis();
		aux = letra + palabra;
		char[] contra = new char[(aux.length())-1];
		byte[] contraHash = getHash(aux);
		probarLetras(contra, 1, longitud, contraHash);

	}

	/**
	 * 
	 * @param contra
	 * @param aux
	 * @param longitud
	 * @param contraHash
	 * @throws InterruptedException
	 */
	private void probarLetras(char[] contra, int aux, int longitud, byte[] contraHash) throws InterruptedException {
		if (aux == longitud) {

			HashMap<String, byte[]> diccionarioContraseñas = new HashMap<String, byte[]>();
			diccionarioContraseñas.put(palabra, contraHash);
			String prueba = new String(contra);
			byte[] hash = getHash(prueba);
			if(diccionarioContraseñas.containsKey(prueba)) {
				System.out.println(prueba);
		/**/		tiempoFinal = System.currentTimeMillis() - tiempo;
					double tiempoSeg = (double)tiempoFinal/1000; 
		/**/		System.out.println("Contraseña descifrada en: " + tiempoFinal + " ms (" + tiempoSeg + ")s");
				System.exit(0);
			}
			return;
		}
		contra[0] = this.letra;
		for (char i = 'a'; i <= 'z'; i++) {
			contra[aux] = i;
			
			probarLetras(contra, aux + 1, longitud, contraHash);
		}
	}

	/**
	 * 
	 * @param text
	 * @return
	 */
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

	@Override
	public void run() {
		try {
			this.descifrar();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
