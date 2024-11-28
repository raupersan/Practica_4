package hilos.interbloqueos.ejer05;

import java.util.Arrays;
import java.util.Random;


public class Filosofo extends Thread {

	private char estado;
	private int numero;
	private Tenedor tenedorIzq;
	private Tenedor tenedorDec;

	public char getEstado() {
		return estado;
	}

	public void setEstado(char estado) {
		this.estado = estado;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Tenedor getTenedorIzq() {
		return tenedorIzq;
	}

	public void setTenedorIzq(Tenedor tenedorIzq) {
		this.tenedorIzq = tenedorIzq;
	}

	public Tenedor getTenedorDec() {
		return tenedorDec;
	}

	public void setTenedorDec(Tenedor tenedorDec) {
		this.tenedorDec = tenedorDec;
	}

	public Filosofo(char estado, int numero, Tenedor tenedorIzq, Tenedor tenedorDec) {
		super();
		this.estado = estado;
		this.numero = numero;
		this.tenedorIzq = tenedorIzq;
		this.tenedorDec = tenedorDec;
	}

	public void comer() {
	Random teclado = new Random();
	int num = teclado.nextInt(5);
		if(tenedorIzq.intentarCoger()&&tenedorDec.intentarCoger()&&this.getEstado() == 'H') {
			this.setEstado('C');
			try {
				System.out.println("el filosofo " + this.getNumero() + " empieza a comer");
				System.out.println("Tenedor izquierdo: " + tenedorIzq.getCogido() + " tenedor derecha: " + tenedorDec.getCogido());
				Thread.sleep(num*1000);
				this.setEstado('P');
			
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else {
			
			System.out.println("El filosofo " + this.getNumero() + " esta en estado: " + this.getEstado());
			this.setEstado('H');
		}
		
		tenedorIzq.dejarTenedor();
		tenedorDec.dejarTenedor();
		


		try {
			Thread.sleep(num*1000);
			comer();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public String toString() {
		return "Filosofo [estado=" + estado + ", numero=" + numero + ", tenedorIzq=" + tenedorIzq + ", tenedorDec="
				+ tenedorDec + "]\n";
	}

	@Override
	public void run() {
		this.comer();
		
	}

}
