package ejercicio_3;

public class Transferencia extends Thread{

	private Cliente origen;
	private Cliente destino;
	private double monto;
	
	public Cliente getOrigen() {
		return origen;
	}
	public void setOrigen(Cliente origen) {
		this.origen = origen;
	}
	public Cliente getDestino() {
		return destino;
	}
	public void setDestino(Cliente destino) {
		this.destino = destino;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public Transferencia(Cliente origen, Cliente destino, double monto) {
		super();
		this.origen = origen;
		this.destino = destino;
		this.monto = monto;
	}
	@Override
	public String toString() {
		return "Transferencia [origen=" + origen + ", destino=" + destino + ", monto=" + monto + "]";
	}
	
}
