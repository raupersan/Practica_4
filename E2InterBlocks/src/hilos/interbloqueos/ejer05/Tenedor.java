package hilos.interbloqueos.ejer05;

import java.util.concurrent.CompletionException;
import java.util.concurrent.Semaphore;

public class Tenedor {

	private Boolean cogido = false;
	private int numero;
	private int numeroFilo;
	private Semaphore semaforo;

	public Boolean getCogido() {
		return cogido;
	}

	public void setCogido(Boolean cogido) {
		this.cogido = cogido;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Tenedor(Boolean cogido, int numero) {
		super();
		this.cogido = cogido;
		this.numero = numero;
		this.semaforo = new Semaphore(1);
	}

	@Override
	public String toString() {
		return "Tenedor numero: " + numero + " y su estado actual es: " + cogido;
	}

	public boolean intentarCoger() {
		boolean dispo = false;

		if (semaforo.tryAcquire()) {
			dispo = true;
			this.setCogido(true);
		}

		return dispo;
	}

	public void dejarTenedor() {
		semaforo.release();
		this.setCogido(false);
		//System.out.println(this.getCogido());

	}

}
