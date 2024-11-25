package ejercicio_3;

import java.util.concurrent.atomic.DoubleAdder;
import java.util.ArrayList;
import java.io.*;


public class GestionTrasferencias extends Thread {

    private final ArrayList<Cliente> listaCliente;
    private final Transferencia transferencia;

    public void gestionTransferencias() {
        Cliente origen = null;
        Cliente destino = null;

        // Encontrar el cliente origen y destino en la lista
        for (Cliente cliente : listaCliente) {
            if (transferencia.getOrigen().equals(cliente.getId())) {
                origen = cliente;
            }
            if (transferencia.getDestino().equals(cliente.getId())) {
                destino = cliente;
            }
        }

        if (origen == null || destino == null) {
            System.out.println("Transferencia fallida: Cliente no encontrado");
            return;
        }

        // Determinar el orden de bloqueo para evitar interbloqueos
        Object primero, segundo;
        if (System.identityHashCode(origen) < System.identityHashCode(destino)) {
            primero = origen;
            segundo = destino;
        } else {
            primero = destino;
            segundo = origen;
        }

        // Bloquear en el orden correcto
        synchronized (primero) {
            System.out.println(Thread.currentThread().getName() + " bloqueó " + origen.getId());
            try {
                Thread.sleep(100); // Simula el tiempo de procesamiento
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
            synchronized (segundo) {
                System.out.println(Thread.currentThread().getName() + " bloqueó " + destino.getId());
                // Realizar la transferencia
                origen.restarSaldo(transferencia.getMonto());
                destino.agregarSaldo(transferencia.getMonto());
                System.out.println("Transferencia completada de " + origen.getId() + " a " + destino.getId() + 
                                   " por monto: " + transferencia.getMonto());
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
