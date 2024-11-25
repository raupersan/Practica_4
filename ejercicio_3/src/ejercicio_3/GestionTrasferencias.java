package ejercicio_3;

import java.util.concurrent.atomic.DoubleAdder;
import java.util.ArrayList;

/**
 * Clase que representa la gestión de transferencias entre clientes.
 * Cada instancia de esta clase es un hilo que realiza una transferencia segura 
 * entre dos clientes dentro de una lista, utilizando sincronización para 
 * evitar condiciones de carrera.
 */
public class GestionTrasferencias extends Thread {

    private final ArrayList<Cliente> listaCliente;
    private final Transferencia transferencia;

    /**
     * Constructor de la clase GestionTrasferencias.
     * 
     * @param listaCliente   Lista de clientes involucrados en la transferencia.
     * @param transferencia  Objeto que contiene los datos de la transferencia a realizar.
     */
    public GestionTrasferencias(ArrayList<Cliente> listaCliente, Transferencia transferencia) {
        this.listaCliente = listaCliente;
        this.transferencia = transferencia;
    }

    /**
     * Método principal que gestiona la transferencia.
     * 
     * Encuentra los clientes de origen y destino en la lista, los bloquea de forma ordenada 
     * para evitar bloqueos mutuos (deadlocks), y realiza la transferencia de forma segura.
     */
    public void gestionTransferencias() {
        Cliente origen = null;
        Cliente destino = null;

        // Buscar clientes origen y destino
        for (Cliente cliente : listaCliente) {
            if (transferencia.getOrigen().equals(cliente.getId())) {
                origen = cliente;
            }
            if (transferencia.getDestino().equals(cliente.getId())) {
                destino = cliente;
            }
        }

        // Determinar el orden de bloqueo para evitar deadlocks
        Object primero, segundo;
        if (System.identityHashCode(origen) < System.identityHashCode(destino)) {
            primero = origen;
            segundo = destino;
        } else {
            primero = destino;
            segundo = origen;
        }

        // Sincronizar en el orden determinado
        synchronized (primero) {
            System.out.println(Thread.currentThread().getName() + " bloqueó " + origen.getId());
            try {
                Thread.sleep(100); // Simula el tiempo de procesamiento
            } catch (InterruptedException e) {
                e.printStackTrace();
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

    /**
     * Sobrescribe el método run() para iniciar el proceso de transferencia 
     * cuando el hilo sea ejecutado.
     */
    @Override
    public void run() {
        this.gestionTransferencias();
    }
}
