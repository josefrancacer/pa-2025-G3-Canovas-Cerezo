package pa.cliente;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.io.ObjectInputStream;
import java.util.Scanner;

import pa.MailItem;

import java.io.IOException;

public class MailClientSocket {

		public void enviarMensajes(String user, ObjectOutputStream out, ObjectInputStream in) throws IOException, ClassNotFoundException{
			Scanner sc = new Scanner(System.in);
			System.out.println(in.readUTF());
			String sendTo = sc.nextLine();
			System.out.println(in.readUTF());
			String mensaje = sc.nextLine();
			MailItem enviar = new MailItem(user, sendTo, mensaje);
			out.writeObject(enviar);
			out.flush();
			String confirmar = in.readUTF();
			System.out.println(confirmar);
		}
		public void recibirMensajes(String user, ObjectInputStream in) throws IOException, ClassNotFoundException {
			int num_correos = in.readInt();
			System.out.println("Mensajes recibidos = " + num_correos);
			if(num_correos > 0) {
				System.out.println(user + " : aquí tiene sus mensajes");
				for(int i = 1; i <= num_correos; i++) {
					System.out.println("Leyendo mensaje: " + i);
					MailItem recibido = (MailItem) in.readObject();
					recibido.print();
				}
			}
		}
		public static void main(String[] args){
			String serverName = "localhost";
			int port = 6066;
			try(Socket client = new Socket(serverName, port);
					ObjectOutputStream out= new ObjectOutputStream(client.getOutputStream());
					ObjectInputStream in = new ObjectInputStream(client.getInputStream());
					Scanner s = new Scanner(System.in)){
					MailClientSocket clientSocket = new MailClientSocket();
					int opcion;
				do {
					System.out.println("Introduce tu nombre: ");
					String user = s.nextLine();
					out.writeUTF(user);
					out.flush();
					System.out.println(in.readUTF());
					opcion = s.nextInt();
					s.nextLine();
					out.writeInt(opcion);
					out.flush();
					switch(opcion) {
					case 1:
						clientSocket.recibirMensajes(user, in);
						break;
					case 2:
						clientSocket.enviarMensajes(user, out, in);
						break;
					}
				}while(opcion == 1 || opcion == 2);
				
				System.out.println("El cliente termina");
						
				
				
			}catch(IOException ex) {
				
			}catch(ClassNotFoundException ex) {
				
			}
		}
}
