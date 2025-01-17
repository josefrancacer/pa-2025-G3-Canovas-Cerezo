package pa.servidor;
import pa.datos.Mensajes;
import pa.MailItem;
import java.util.ArrayList;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;




public class MailServerSocket {
	private MailServer servidorCorreo;
	
	public MailServerSocket(ArrayList<MailItem> mensajes) {
		servidorCorreo = new MailServer(mensajes);
	}
	public void servirMensajes(String user, ObjectOutputStream out) throws IOException{
		int numCorreos = servidorCorreo.howManyMailItems(user);
		out.writeInt(numCorreos);
		System.out.println("Enviando " 
				+ numCorreos + " mensajes para: " + user);
		for(int i = 0; i<numCorreos; i++) {
			MailItem correo = servidorCorreo.getNextMailItem(user);
			out.writeObject(correo);
			System.out.println("Mensaje: " + correo.getMessage());
		}
		
	}
	public void recibirMensajes(String user, ObjectOutputStream out, ObjectInputStream in) throws IOException, ClassNotFoundException{
		System.out.println("Pedimos los datos");
		out.writeUTF("Destinatario mensaje: ");
		out.flush();
		out.writeUTF("Escriba su mensaje entre comillas dobles y con un sólo retorno de carro al final: ");
		out.flush();
		MailItem correo = (MailItem) in.readObject();
		System.out.println("Mensaje recibido");
		servidorCorreo.post(correo);
		System.out.println("Mensaje añadido");
		out.writeUTF("Mensaje enviado con éxito");
		out.flush();
		
	}
	public static void main(String[] args) {
		int port = 6066;
		try(ServerSocket serverSocket = new ServerSocket(port); 
				Socket server = serverSocket.accept();
				ObjectOutputStream out = new ObjectOutputStream(server.getOutputStream());
				ObjectInputStream in = new ObjectInputStream(server.getInputStream())
				){
			MailServerSocket mailServer = new MailServerSocket(new ArrayList<MailItem>());
			System.out.println("Servidor de correo en marcha en el puerto: " + server.getLocalPort());
			System.out.println("Acabo de conectar con: " + server.getPort());
			int num_peticion;
			do {
				String user = in.readUTF();
				System.out.println(user + " ha accedido al sistema");
				out.writeUTF("Indique la operacion a realizar: \n"
						+ "1. Consultar mensajes recibidos \n"
						+ "2.Enviar un mensaje \n"
						+ "Teclee opción: (Para terminar teclee cualquier otro valor)");
				out.flush();
				num_peticion = in.readInt();
				switch(num_peticion) {
				case 1:
					mailServer.servirMensajes(user, out);
					break;
				case 2:
					mailServer.recibirMensajes(user, out, in);
					break;
				}
			}while(num_peticion == 1 || num_peticion == 2);
			
			server.close();
			System.out.println("Servidor detenido");
			
			
			
			
		}catch(IOException ex) {
			
		}catch(ClassNotFoundException ex) {
			
		}
		
		
		
	}
}
