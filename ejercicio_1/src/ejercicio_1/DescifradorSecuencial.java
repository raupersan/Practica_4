package ejercicio_1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class DescifradorSecuencial {

	public static long descifradorContraseñaSec(String contraseña){
		// TODO Auto-generated method stub

		Scanner teclado = new Scanner(System.in);
		//Random ran = new Random();
		//String contraseña;
		boolean encontrado= false;

		final String cadena = "abcdefghijklmnñopqrstuvwxyz";

		System.out.println("Meta su contraseña");
		contraseña = teclado.nextLine();

		String aleatorio = "";
		int contador = 0;
		
		long hora;
		long tiempoFinal=0;
		do {
			hora = System.currentTimeMillis();
			
			for (int i = 0; i < cadena.length(); i++) {
				for (int a = 0; a < cadena.length(); a++) {
					for (int h = 0; h < cadena.length(); h++) {
						for (int j = 0; j < cadena.length(); j++) {
							
							aleatorio = "" + cadena.charAt(i) + cadena.charAt(a) + cadena.charAt(h) + cadena.charAt(j);
							System.out.println("aleatorio: " + aleatorio.toString() + " " + "contraseña: " + contraseña);

							contador++;
							if(aleatorio.equals(contraseña)) {
								tiempoFinal= System.currentTimeMillis()-hora;
								encontrado=true;
							}
							if(encontrado==true)
								j=cadena.length();

						}
						if(encontrado==true)
							h=cadena.length();
					}
					if(encontrado==true)
						a=cadena.length();
				}

				if(encontrado==true)
					i=cadena.length();

			}
			System.out.println("aleatorio: " + aleatorio + " " + "contraseña: " + contraseña);
		} while (!aleatorio.equals(contraseña));
		System.out.println("El numero de intentos ha sido de: " + contador);
		//System.out.println("Encontrado en " + tiempoFinal + " ms");
		teclado.close();
		return tiempoFinal;
	}

}
