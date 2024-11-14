package ejercicio_2;

import java.util.concurrent.CyclicBarrier;

public class Jugador implements Runnable{
	private int id;
	private int nPepitas;
	private Posicion pos;
	public Jugador(int id, int nPepitas, Posicion pos, CyclicBarrier barr) {
		super();
		this.id = id;
		this.nPepitas = nPepitas;
		this.pos = pos;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getnPepitas() {
		return nPepitas;
	}
	public void setnPepitas(int nPepitas) {
		this.nPepitas = nPepitas;
	}
	
	public Posicion getPos() {
		return pos;
	}
	public void setPos(Posicion pos) {
		this.pos = pos;
	}
	@Override
	public String toString() {
		return "Soy el jugador: " + id + " y tengo " + nPepitas + " pepitas";
	}
	
	@Override
	public void run() {
		
	}
}
