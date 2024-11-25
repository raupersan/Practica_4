package ejercicio_2;

import java.util.HashMap;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Future;

public class Jugador extends Thread {
	private int id;
	private int nPepitas;
	private Posicion pos;
	private Tipo tipo;
	private CyclicBarrier barr;
	private Tablero tablero;
	private boolean perdido;
	
	public Jugador(int id, int nPepitas, Posicion pos, CyclicBarrier barr, Tipo tipo, Tablero tablero, boolean perdido) {
		this.id = id;
		this.nPepitas = nPepitas;
		this.pos = pos;
		this.tipo = tipo;
		this.barr = barr;
		this.tablero = tablero;
		this.perdido = perdido;
	}

	public CyclicBarrier getBarr() {
		return barr;
	}

	public void setBarr(CyclicBarrier barr) {
		this.barr = barr;
	}

	public long getId() {
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
		while (!Thread.currentThread().isInterrupted() && !perdido) {
             try {
            	 mover();
				barr.await();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				System.out.println("El jugador " + id + " ha encontrado una mina y ha perdido");
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
			}
		 }

	}

	public void mover() {
		Posicion[] moves = {
	            new Posicion(pos.getX() + 1, pos.getY()),
	            new Posicion(pos.getX(), pos.getY() + 1),
	            new Posicion(pos.getX() + 1, pos.getY() + 1),
	            new Posicion(pos.getX() - 1, pos.getY()),
	            new Posicion(pos.getX(), pos.getY() - 1),
	            new Posicion(pos.getX() - 1, pos.getY() - 1)
	        };

	        for (Posicion pos : moves) {
	            if (tablero.intentarMover(pos)) {
	                return;
	            }
	        }
	        System.out.println("Jugador " + id + " está rodeado y no se puede mover.");
	    }
	}

