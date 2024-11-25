package ejercicio_3;

import java.security.KeyStore.TrustedCertificateEntry;
import java.util.ArrayList;
import java.io.*;

public class GestionTrasferencias extends Thread {

	ArrayList<Cliente> listaCliente;
	Transferencia transferencia;
	
	public void gestionTransferencias() {

		for (Cliente clientes : listaCliente) {

			if (transferencia.getOrigen().equals(clientes.getId())) {
				clientes.setSaldo(clientes.getSaldo() - transferencia.getMonto());

			}
		}
		for (Cliente cliente2 : listaCliente) {

			if (transferencia.getDestino().equals(cliente2.getId())) {
				cliente2.setSaldo(cliente2.getSaldo() + transferencia.getMonto());

			}
		}
	}

	public GestionTrasferencias(ArrayList<Cliente> listaCliente, Transferencia transferencia) {
		this.listaCliente = listaCliente;
		this.transferencia = transferencia;

	}

	@Override
	public void run() {
		this.gestionTransferencias();

	}

}
