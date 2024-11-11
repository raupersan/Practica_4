package ejercicio_1;

import java.util.Arrays;

public class DescifradorSecuencial {

	public static void descifrar(int longitud, byte[] contraseña) {
		// TODO Auto-generated method stub

		char[] contra = new char[longitud];
		probarLetras(contra, 0,longitud);

	}

	private static void probarLetras(char[]contra, int aux,int longitud) {
		 if (aux == longitud) {
	            System.out.println(Arrays.toString(contra));
	            return;
	        }
	        
	        for (char i = 'a'; i <= 'z'; i++) {
	            contra[aux] = i;
	            probarLetras(contra, aux + 1, longitud);
	        }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String palabra = "casa";
		int longitud = 7;
		byte[] contraseña = palabra.getBytes();

		descifrar(longitud, contraseña);

	}

}


