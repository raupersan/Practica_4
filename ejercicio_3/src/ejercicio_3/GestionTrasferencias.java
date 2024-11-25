package ejercicio_3;

import java.util.concurrent.atomic.DoubleAdder;
import java.util.ArrayList;
import java.io.*;


public class GestionTrasferencias extends Thread {

	ArrayList<Cliente> listaCliente;
	Transferencia transferencia;
	
	public void gestionTransferencias() {

		for (Cliente clientes : listaCliente) {

			if (transferencia.getOrigen().equals(clientes.getId())) {
				clientes.restarSaldo(transferencia.getMonto());
				

			}
		}
		for (Cliente cliente2 : listaCliente) {

			if (transferencia.getDestino().equals(cliente2.getId())) {
				 cliente2.agregarSaldo(transferencia.getMonto()); 

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
