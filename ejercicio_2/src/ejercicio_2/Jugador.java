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
		this.mover(null);

	}

	public void mover(HashMap tablero) {
		Posicion pos;
		if(tablero.get(new Posicion(this.getPos().getX()+1, this.getPos().getY()))!=Tipo.JUGADOR) {
			if(tablero.get(new Posicion(this.getPos().getX()+1, this.getPos().getY()))==Tipo.MINA) {
				System.out.println("Has encontrado una mina y has perdido con un total de " + this.getnPepitas() + " pepitas");
			}
			else {
				int pepTotal = this.getnPepitas()+1;
				this.setnPepitas(pepTotal);
				System.out.println("Has encontrado una pepita, tu total es " +  this.getnPepitas() + " pepitas encontradas");
				tablero.remove(new Posicion(this.getPos().getX()+1, this.getPos().getY()));
				tablero.put(new Posicion(this.getPos().getX()+1, this.getPos().getY()), Tipo.JUGADOR);
				this.setPos(new Posicion(this.getPos().getX()+1, this.getPos().getY()));
			}
				
		}
		else if(tablero.get(new Posicion(this.getPos().getX(), this.getPos().getY()+1))!=Tipo.JUGADOR){
			if(tablero.get(new Posicion(this.getPos().getX()+1, this.getPos().getY()))==Tipo.MINA) {
				System.out.println("Has encontrado una mina y has perdido con un total de " + this.getnPepitas() + " pepitas");
			}
			else {
				int pepTotal = this.getnPepitas()+1;
				this.setnPepitas(pepTotal);
				System.out.println("Has encontrado una pepita, tu total es " +  this.getnPepitas() + " pepitas encontradas");
				tablero.remove(new Posicion(this.getPos().getX()+1, this.getPos().getY()));
				tablero.put(new Posicion(this.getPos().getX()+1, this.getPos().getY()), Tipo.JUGADOR);
				this.setPos(new Posicion(this.getPos().getX()+1, this.getPos().getY()));
			}
		}
		/*HashMap<Posicion, Tipo> mapa = Main.crearMapa<Posicion, Integer>();
			if() {
				this.setPos(new Posicion(nuevaPosX, nuevaPosY));
		}
		*/
		
	}
}
