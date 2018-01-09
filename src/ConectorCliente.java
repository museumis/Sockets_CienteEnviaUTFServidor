import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Cliente
 * 
 * @author Ismael Martin
 *
 */
public class ConectorCliente {
	/**
	 * Metodo que inicia el programa
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int puerto = 8000;// Puerto
		 String host = "localhost";
		//String host = "192.168.3.205";

		// -----------------
		// Activar el cliente
		// -----------------
		Socket cliente = null;
		try {
			cliente = new Socket(host, puerto);
		} catch (IOException io) {
			io.printStackTrace();
		}
		// -----------------
		// Conectar cliente al sevidor
		// -----------------
		InetAddress i = cliente.getInetAddress();
		System.out.println("Puerto local:  " + cliente.getLocalPort());
		System.out.println("Puerto remoto:  " + cliente.getPort());
		System.out.println("Nombre host remoto:  " + i.getHostName());
		System.out.println("IP host remoto:  " + i.getHostAddress());
		// -----------------
		// Crear flujos hacia el servidor
		// -----------------
		OutputStream salidaCliente = null;
		try {
			salidaCliente = cliente.getOutputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
		DataOutputStream flujoSalidaCliente = new DataOutputStream(salidaCliente);
		try {
			flujoSalidaCliente.writeUTF("Este mensaje se envia al servidor desde el cliente.");
			// -----------------
			// Cierre flujos y cierre del cliente.
			// -----------------
			flujoSalidaCliente.close();
			salidaCliente.close();
			cliente.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}//Fin de main
}//Fin de la clase
