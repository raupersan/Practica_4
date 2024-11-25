package ejercicio_2;

public class Posicion {

	private int x;
	private int y;
	public Posicion(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	@Override
	public String toString() {
		return "Posicion X : " + getX() + " Posicion Y: "  + getY();
	}
	@Override
	public boolean equals(Object p1) {
		Posicion p2 = (Posicion) p1;
		if(this.x == p2.x && this.y == p2.y) {
			return true;
			
		}else
		return false;
	}
	 private static Posicion generarPosicion(Tablero tablero) {
	        Posicion pos;
	        do {
	            pos = new Posicion(random.nextInt(BOARD_SIZE), random.nextInt(BOARD_SIZE));
	        } while (!tablero.esPosicionVacia(pos));
	        return pos;
	    }
}
