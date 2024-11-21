package ejercicio_1;

import java.util.Arrays;

public class DescifradorSecuencial {

	public static void descifrar(int longitud, byte[] contraseña, String palabra) {
		// TODO Auto-generated method stub

		char[] contra = new char[longitud];
		probarLetras(contra, 0, longitud, palabra);

	}

	private static void probarLetras(char[] contra, int aux, int longitud, String palabra) {
		if (aux == longitud) {

			String prueba = new String(contra);
			if (prueba.equals(palabra)) {
				System.out.println("¡Palabra encontrada: " + prueba + "!");
				System.exit(0);
			} else
				System.out.println(Arrays.toString(contra));

			return;
		}

		for (char i = 'a'; i <= 'z'; i++) {
			contra[aux] = i;
			probarLetras(contra, aux + 1, longitud, palabra);
		}
	}

}
