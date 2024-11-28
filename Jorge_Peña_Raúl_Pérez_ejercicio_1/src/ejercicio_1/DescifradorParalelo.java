package src.ejercicio_1;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class DescifradorParalelo extends Thread {
	private int longitud;
	private byte[] contraseña;
	private String palabra;
	private char letra;
	
	/**
	 * @param tiempo		Guarda el momento exacto en el que el hilo comienza a paralelizar
	 * @param tiempoFinal	Calcula el tiempo actual y le resta el tiempo en el que empezó el proceso,
	 * 						obteniendo así el tiempo en ms que tardó en descubrir la contraseña
	 */
	
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
		tiempo = System.currentTimeMillis();
		aux = letra + palabra;
		char[] contra = new char[(aux.length()) - 1];
		byte[] contraHash = getHash(aux);
		probarLetras(contra, , longitud, contraHash);

	}

	/**
	 * 
	 * @param contra				Array de char que recoge las nuevas letras que se van probando, ya que la primera es conocida
	 * @param aux					Cuenta el tamaño de el previo array, y cuando tenga el mismo tamaño que la contraseña,
	 * 								el programa empezará a comprobar si esa cadena coincide con la contraseña
	 * 
	 * @param longitud				Tamaño de la contraseña			
	 * @param contraHash			Contraseña hasheada
	 * @throws InterruptedException	Controla la interrupción inesperada de un hilo
	 */
	private void probarLetras(char[] contra, int aux, int longitud, byte[] contraHash) throws InterruptedException {
		/*
		 * <p>
		 * Función recursiva que añade letras tantas veces como tamaño tenga la contrasña -1,
		 * ya que el primer dígito es conocido
		 * </p>
		 * 
		 * <p>La contraseña se introduce en un hashmap con la palabra como clave
		 * y la contraseña hasheada como valor, después se comprueba si la cadena 
		 * que ha generado el hilo coincide con esta clave, de ser así, habrá encontrado
		 * la contraseña y mostrará un mensaje con el tiempo que ha tardado en hacerlo</p>
		 */
		
		
		if (aux == longitud) {

			HashMap<String, byte[]> diccionarioContraseñas = new HashMap<String, byte[]>();
			diccionarioContraseñas.put(palabra, contraHash);
			String prueba = new String(contra);
			if (diccionarioContraseñas.containsKey(prueba)) {
				System.out.println(prueba);
				tiempoFinal = System.currentTimeMillis() - tiempo;
				double tiempoSeg = (double) tiempoFinal / 1000;
				System.out.println("Contraseña descifrada en: " + tiempoFinal + " ms (" + tiempoSeg + ")s");
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
			e.printStackTrace();
		}
	}

}
