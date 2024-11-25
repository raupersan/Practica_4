package ejercicio_3;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import com.google.gson.Gson;

public class LeerArchivos {
	Gson gson = new Gson();

	public LeerArchivos() {

	}

	public ArrayList<Cliente> leerClientes() throws IOException {
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		for (int i = 1; i <= 6; i++) {
				String ruta = "Cliente" + i+".json";
				FileReader fr = new FileReader("datos.json");
				Cliente cliente = gson.fromJson(fr, Cliente.class);
				clientes.add(cliente);
		
		}
		return clientes;
	}
	public ArrayList<Transferencia> leerTransferencias() throws IOException{
		ArrayList<Transferencia> transferencias = new ArrayList<Transferencia>();
		for (int i = 1; i <= 10; i++) {
			String ruta = "Cliente" + i+".json";
			FileReader fr = new FileReader("datos.json");
			Transferencia transferencia = gson.fromJson(fr, Transferencia.class);
			transferencias.add(transferencia);
				
		}
		return transferencias;
	}
}
