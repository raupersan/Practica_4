package ejercicio_3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {

		try {
			ArrayList<Cliente> listaCliente = (new LeerArchivos()).leerClientes();
			List<Transferencia> listaTransferencias = (new LeerArchivos()).leerTransferencias();
			ExecutorService es = Executors.newFixedThreadPool(10);
			for (Transferencia transferenciaArray : listaTransferencias) {
				/**
				 * No sabemos acceder bien al Json así que dejamos indicado cómo tendría que
				 * lanzarse el hilo correspondiente * es.submit(new
				 * GestionTrasferencias(listaCliente, transferenciaArray));
				 */

				System.out.println("PRUEBA");
				System.out.println(transferenciaArray);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}