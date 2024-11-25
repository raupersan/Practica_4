package ejercicio_3;

import java.security.KeyStore.TrustedCertificateEntry;
import java.util.ArrayList;
import java.io.*;

public class GestionTrasferencias {



	public void gestionTransferencias() {

		try {
			 ArrayList<Cliente> listaCliente = (new LeerArchivos()).leerClientes();
			 ArrayList<Transferencia[]> listaTransferencias = (new LeerArchivos()).leerTransferencias();
			

		
		for (Transferencia transferencia : listaTransferencias) {
			for (Cliente clientes : listaCliente) {
				if (transferencia.getOrigen().equals(clientes)) {
					clientes.setSaldo(clientes.getSaldo()- transferencia.getMonto());
					
				}	
			}
			for (Cliente cliente2 : listaCliente) {
				if (transferencia.getDestino().equals(cliente2)) {
					cliente2.setSaldo(cliente2.getSaldo()+ transferencia.getMonto());
					
				}	
			}
		}
		
		}catch(IOException e){
			e.printStackTrace();
		}
	}

}
