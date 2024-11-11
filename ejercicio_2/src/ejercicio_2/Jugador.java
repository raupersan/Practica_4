package ejercicio_2;

public class Jugador {
	private String nombre;
	private int id;
	private int nPepitas;
	
	
	public Jugador(String nombre, int nPepitas) {
		super();
		this.nombre = nombre;
		this.nPepitas = nPepitas;
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
	
	@Override
	public String toString() {
		return "Soy el jugador: " + nombre + " y tengo " + nPepitas + " pepitas";
	}
}
