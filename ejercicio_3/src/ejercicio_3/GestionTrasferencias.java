package ejercicio_3;

import java.util.ArrayList;

public class GestionTrasferencias {

	private ArrayList<Cliente> clientes = new LeerArchivos().leerClientes();
	
	public void gestionTransferencias(ArrayList<Cliente> listaCliente, ArrayList<Transferencia> listaTransferencias) {

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
		
		
	}

}
