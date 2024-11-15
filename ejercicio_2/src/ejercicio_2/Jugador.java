package ejercicio_2;

import java.util.HashMap;
import java.util.concurrent.CyclicBarrier;

public class Jugador implements Runnable {
	private int id;
	private int nPepitas;
	private Posicion pos;
	Tipo tipo;

	public Jugador(int id, int nPepitas, Posicion pos, CyclicBarrier barr, Tipo tipo) {
		super();
		this.id = id;
		this.nPepitas = nPepitas;
		this.pos = pos;
		this.tipo = tipo;
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

	public Tipo getTipo() {
		return tipo;
	}

	@Override
	public void run() {
		this.mover();

	}

	private void mover() {
		int nuevaPosX = this.getPos().getX()+1;
		int nuevaPosY = this.getPos().getY()+0;
		/*HashMap<Posicion, Tipo> mapa = Main.crearMapa<Posicion, Integer>();
			if() {
				this.setPos(new Posicion(nuevaPosX, nuevaPosY));
		}
		*/
		
	}
}
