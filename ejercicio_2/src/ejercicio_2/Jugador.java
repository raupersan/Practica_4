package ejercicio_2;

import java.util.HashMap;
import java.util.concurrent.CyclicBarrier;

public class Jugador implements Runnable {
	private int id;
	private int nPepitas;
	private Posicion pos;
	Tipo tipo;

	public Jugador(int id, int nPepitas, Posicion pos, CyclicBarrier barr, Tipo tipo, Tablero tablero) {
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

	public void mover(Tablero tablero) {
		Posicion pos;
		//mueves una vez la x
		if(tablero.get(pos = new Posicion(this.getPos().getX()+1, this.getPos().getY()))!=Tipo.JUGADOR) {
			if(tablero.get(pos)==Tipo.MINA) {
				System.out.println("Has encontrado una mina y has perdido con un total de " + this.getnPepitas() + " pepitas");
				//TODO mirar exit
				//Thread.currentThread();
			}
			else {
				int pepTotal = this.getnPepitas()+1;
				this.setnPepitas(pepTotal);
				System.out.println("Has encontrado una pepita, tu total es " +  this.getnPepitas() + " pepitas encontradas");
				tablero.remove(pos);
				tablero.put(pos, Tipo.JUGADOR);
				this.setPos(pos);
			}
				
		}
		//mueves una vez la y
		else if(tablero.get(pos = new Posicion(this.getPos().getX(), this.getPos().getY()+1))!=Tipo.JUGADOR){
			if(tablero.get(pos)==Tipo.MINA) {
				System.out.println("Has encontrado una mina y has perdido con un total de " + this.getnPepitas() + " pepitas");
			}
			else {
				int pepTotal = this.getnPepitas()+1;
				this.setnPepitas(pepTotal);
				System.out.println("Has encontrado una pepita, tu total es " +  this.getnPepitas() + " pepitas encontradas");
				tablero.remove(pos);
				tablero.put(pos, Tipo.JUGADOR);
				this.setPos(pos);
			}
		}
		//Mueves las dos
		else if(tablero.get(pos = new Posicion(this.getPos().getX()+1, this.getPos().getY()+1))!=Tipo.JUGADOR){
			if(tablero.get(pos)==Tipo.MINA) {
				System.out.println("Has encontrado una mina y has perdido con un total de " + this.getnPepitas() + " pepitas");
			}
			else {
				int pepTotal = this.getnPepitas()+1;
				this.setnPepitas(pepTotal);
				System.out.println("Has encontrado una pepita, tu total es " +  this.getnPepitas() + " pepitas encontradas");
				tablero.remove(pos);
				tablero.put(pos, Tipo.JUGADOR);
				this.setPos(pos);
			}
		}	//mueves -una vez la x
		else if(tablero.get(pos = new Posicion(this.getPos().getX()-1, this.getPos().getY()))!=Tipo.JUGADOR){
			if(tablero.get(pos)==Tipo.MINA) {
				System.out.println("Has encontrado una mina y has perdido con un total de " + this.getnPepitas() + " pepitas");
			}
			else {
				int pepTotal = this.getnPepitas()+1;
				this.setnPepitas(pepTotal);
				System.out.println("Has encontrado una pepita, tu total es " +  this.getnPepitas() + " pepitas encontradas");
				tablero.remove(pos);
				tablero.put(pos, Tipo.JUGADOR);
				this.setPos(pos);
			}
		}	//mueves -una vez la y	
		else if(tablero.get(pos = new Posicion(this.getPos().getX(), this.getPos().getY()-1))!=Tipo.JUGADOR){
			if(tablero.get(pos)==Tipo.MINA) {
				System.out.println("Has encontrado una mina y has perdido con un total de " + this.getnPepitas() + " pepitas");
			}
			else {
				int pepTotal = this.getnPepitas()+1;
				this.setnPepitas(pepTotal);
				System.out.println("Has encontrado una pepita, tu total es " +  this.getnPepitas() + " pepitas encontradas");
				tablero.remove(pos);
				tablero.put(pos, Tipo.JUGADOR);
				this.setPos(pos);
			}
		} 	//mueves -una vez las dos
		else if(tablero.get(pos = new Posicion(this.getPos().getX()-1, this.getPos().getY()-1))!=Tipo.JUGADOR){
			if(tablero.get(pos)==Tipo.MINA) {
				System.out.println("Has encontrado una mina y has perdido con un total de " + this.getnPepitas() + " pepitas");
			}
			else {
				int pepTotal = this.getnPepitas()+1;
				this.setnPepitas(pepTotal);
				System.out.println("Has encontrado una pepita, tu total es " +  this.getnPepitas() + " pepitas encontradas");
				tablero.remove(pos);
				tablero.put(pos, Tipo.JUGADOR);
				this.setPos(pos);
			}
		}
		//falta el resto de casos pero se entiende la idea
		else {
			System.out.println("Estás rodeado de jugadores y no te puedes mover");
		}
		/*HashMap<Posicion, Tipo> mapa = Main.crearMapa<Posicion, Integer>();
			if() {
				this.setPos(new Posicion(nuevaPosX, nuevaPosY));
		}
		*/
		
	}
}
