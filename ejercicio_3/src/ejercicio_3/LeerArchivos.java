package ejercicio_3;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import com.google.gson.Gson;

public class LeerArchivos {
	Gson gson = new Gson();

	public ArrayList<Cliente> leerClientes() throws IOException{
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		for (int i = 1; i <= 6; i++) {
			String ruta = ".\\data\\Cliente" + i + ".json";
			FileReader fr = new FileReader(ruta);
			Cliente cliente = gson.fromJson(fr, Cliente.class);
			clientes.add(cliente);

		}
		
		return clientes;
	}

	public List<Transferencia> leerTransferencias() throws IOException {
		List<Transferencia> listaTransferencias=null;
		Type lista = new TypeToken<List<Transferencia>>() {}.getType();
		Transferencia[] transferencias = null;
		for (int i = 1; i <= 10; i++) {
			String ruta = ".\\data\\Transferencias" + i + ".json";
			FileReader fr = new FileReader(ruta);
			listaTransferencias=gson.fromJson(fr, lista);
				
		}
		return listaTransferencias;
	}
}
