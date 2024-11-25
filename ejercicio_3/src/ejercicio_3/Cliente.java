package ejercicio_3;


import java.util.concurrent.atomic.DoubleAdder;

public class Cliente {

	private String id;
	private String nombre;
	private DoubleAdder saldo;
	private String numeroCuenta;
	private String direccion;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public DoubleAdder getSaldo() {
		return saldo;
	}
	public void setSaldo(DoubleAdder saldo) {
		this.saldo = saldo;
	}
	public String getNumeroCuenta() {
		return numeroCuenta;
	}
	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Cliente(String id, String nombre, DoubleAdder saldo, String numeroCuenta, String direccion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.saldo = saldo;
		this.numeroCuenta = numeroCuenta;
		this.direccion = direccion;
	}
	 public void agregarSaldo(double monto) {
	        saldo.add(monto);  // Sumamos al saldo
	    }

	    public void restarSaldo(double monto) {
	        saldo.add(-monto);  // Restamos del saldo, sumando el negativo del monto
	    }
	
	
	
	
	
	
	
}
