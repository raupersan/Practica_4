package ejercicio_3;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import com.google.gson.Gson;

public class LeerArchivos {
	Gson gson = new Gson();

	public ArrayList<Cliente> leerClientes() throws IOException {
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		for (int i = 1; i <= 6; i++) {
			String ruta = "./data/Cliente" + i + ".json";
			FileReader fr = new FileReader(ruta);
			Cliente cliente = gson.fromJson(fr, Cliente.class);
			clientes.add(cliente);

		}
		return clientes;
	}

	public ArrayList<Transferencia[]> leerTransferencias() throws IOException {
		ArrayList<Transferencia[]> listaTransferencias = new ArrayList<Transferencia[]>();
		Transferencia[] transferencias = null;
		for (int i = 1; i <= 10; i++) {
			String ruta = "./data/Transferencia" + i + ".json";
			FileReader fr = new FileReader(ruta);
			transferencias = gson.fromJson(fr, Transferencia[].class);
			listaTransferencias.add(transferencias);			
		}
		return listaTransferencias;
	}
}
