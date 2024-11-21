package src.ejercicio_1;

public class DescifradorParalelo extends Thread {
	private char a;
	private int longitud;
	private byte[] contraseña;
//
	public DescifradorParalelo(char a, int longitud, byte[] contraseña) {
		this.a = a;
		this.longitud = longitud;
		this.contraseña = contraseña;
	}

	public boolean descifrar() {
		
		char[] comprobar={this.a, 'a', 'a', 'a'};
		boolean encontrado = false;
		String aux = null;
		for (int i = 0; i < longitud && !encontrado; i++) {
			for (char j = 'a'; j < 'z'; j++) {
				comprobar[0]= this.a;
				comprobar[i] = j;
				aux = comprobar.toString();
				if (Descifrador.getHash(aux).equals(contraseña)) {
					encontrado = true;
				}
			}
		}
		return true;
	}

	@Override
	public void run() {
		this.descifrar();
	}

}
