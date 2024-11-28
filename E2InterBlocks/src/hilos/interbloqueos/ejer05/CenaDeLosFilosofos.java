package hilos.interbloqueos.ejer05;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CenaDeLosFilosofos {
	static Scanner teclado = new Scanner(System.in);
	static Random aleatorio = new Random();
	
	public static void empezarCena(ArrayList<Thread> listaFilosofos, ArrayList<Tenedor> listaTenedores) {
		
		//int num = aleatorio.nextInt(listaFilosofos.size());
		for(int i = 0;i <listaFilosofos.size();i++) {
			listaFilosofos.get(i).start();
		}
		
	}
	
	

	public static void main(String[] args) {
		ArrayList<Thread> listaFilosofos = new ArrayList<>();
		ArrayList<Tenedor> listaTenedores = new ArrayList<>();

		int nFilosofos = 0;

		while (nFilosofos <= 1) {
			System.out.println("Introduce el número de filósofos");
			System.out.println("(mínimo 2 filósofos)");
			nFilosofos = teclado.nextInt();
		}

		for (int i = 0; i < nFilosofos; i++) {

			listaTenedores.add(new Tenedor(false, i + 1));

		}
		for (int i = 0; i < nFilosofos; i++) {
			if (i < nFilosofos - 1) {
				listaFilosofos.add(new Filosofo('P', i + 1, listaTenedores.get(i), listaTenedores.get(i + 1)));
			} else {
				listaFilosofos.add(new Filosofo('P', i + 1, listaTenedores.get(i), listaTenedores.get(0)));
			}
		}
		
		empezarCena(listaFilosofos,listaTenedores); 
		System.out.println(listaFilosofos);

	
		
	}

}
