package src.ejercicio_1;

import java.util.Arrays;

public class DescifradorParalelo extends Thread {
	private int longitud;
	private byte[] contraseña;
	private String palabra;
	private char letra;
//
	public DescifradorParalelo(int longitud, byte[] contraseña, String palabra,char letra) {
		this.longitud = longitud;
		this.contraseña = contraseña;
		this.palabra = palabra;
		this.letra = letra;
	}

	public void descifrar() {
		String aux ;
		
		aux = letra + palabra;
		char[] contra = new char[longitud];
		probarLetras(contra, 1, longitud, aux);

	}

	private void probarLetras(char[] contra, int aux, int longitud, String palabra) {
		if (aux == longitud) {

			String prueba = new String(contra);
			prueba= letra+prueba;
			if (prueba.equals(palabra)) {
				System.out.println("¡Palabra encontrada: " + prueba + "!");

				System.exit(0);
			} else
				System.out.println(Arrays.toString(contra));

			return;
		}

		for (char i = 'a'; i <= 'z'; i++) {
			contra[aux] = i;
			contra[0] = this.letra;
			probarLetras(contra, aux + 1, longitud, palabra);
		}
	}

	@Override
	public void run() {
		this.descifrar();
	}

}
