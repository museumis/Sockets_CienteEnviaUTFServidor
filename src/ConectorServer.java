import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Servidor
 * @author Ismael Martin
 *
 */
public class ConectorServer {
	/*
	 * Metodo para iniciar el programa
	 */
	public static void main(String[] args) throws IOException {
		int puerto = 8000;
		// ----------------
		// Activar Sevidor
		// ----------------
		ServerSocket servidor = null;
		try {
			servidor = new ServerSocket(puerto);
			System.out.println("Escuchando en el puerto " + servidor.getLocalPort());
		} catch (IOException io) {
			io.printStackTrace();
		}
		// ----------------
		// Conectar el Cliente
		// ----------------
		Socket clienteConectado = null;
		try {
			clienteConectado = servidor.accept();
		} catch (IOException io) {
			io.printStackTrace();
		}// Esperando a un cliente
		System.out.println("LLega el primer cliente.");		
		// ----------------
		// Recepcion del flujo el cliente
		// ----------------
		InputStream entrada = null;
		try {
			entrada = clienteConectado.getInputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
		DataInputStream flujoEntrada = new DataInputStream(entrada);
		System.out.println(flujoEntrada.readUTF());
		// ----------------
		// Cierre de los flujos de cliente,Cierre del cliente, Cierre del servidor
		// ---------------
		try {
			flujoEntrada.close();
			entrada.close();// Realizar acciones con cliente1. En este caso, nada, cierra la conexion
			clienteConectado.close();
			servidor.close(); // Cierro socket servidor
		} catch (IOException e) {
			e.printStackTrace();
		}
	}//Fin main
}//Fin de la clase
