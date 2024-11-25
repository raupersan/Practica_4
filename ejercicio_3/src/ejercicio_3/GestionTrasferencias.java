package ejercicio_3;

import java.security.KeyStore.TrustedCertificateEntry;
import java.util.ArrayList;
import java.io.*;

public class GestionTrasferencias {

	public void gestionTransferencias() {


				
				for (Cliente clientes : listaCliente) {
					for (int i = 0; i < transferencia.length; i++) {

						if (transferencia[i].equals(transferencia)) {
							clientes.setSaldo(clientes.getSaldo() - transferencia[i].getMonto());

						}
					}
				}
				for (Cliente cliente2 : listaCliente) {
					for (int i = 0; i < transferencia.length; i++) {
						if (transferencia[i].getDestino().equals(cliente2)) {
							cliente2.setSaldo(cliente2.getSaldo() + transferencia[i].getMonto());

						}
					}
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
