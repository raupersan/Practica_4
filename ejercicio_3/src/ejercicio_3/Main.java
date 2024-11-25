package ejercicio_3;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		try {
			ArrayList<Cliente> listaCliente = (new LeerArchivos()).leerClientes();
			ArrayList<Transferencia[]> listaTransferencias = (new LeerArchivos()).leerTransferencias();

			for (Transferencia[] transferenciArray : listaTransferencias) {
				for (int i = 0; i < transferenciArray.length; i++) {
					t.procesar();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}