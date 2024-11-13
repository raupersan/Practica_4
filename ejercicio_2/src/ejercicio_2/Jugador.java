package ejercicio_2;

import java.util.concurrent.CyclicBarrier;

public class Jugador implements Runnable{
	private String nombre;
	private int nPepitas;
	private Posicion pos;
	public Jugador(String nombre, int nPepitas, Posicion pos, CyclicBarrier barr) {
		super();
		this.nombre = nombre;
		this.nPepitas = nPepitas;
		this.pos = pos;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
		return "Soy el jugador: " + nombre + " y tengo " + nPepitas + " pepitas";
	}
	
	@Override
	public void run() {
		
	}
}
