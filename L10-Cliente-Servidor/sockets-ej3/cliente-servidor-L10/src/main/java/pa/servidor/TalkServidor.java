package pa.servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class TalkServidor {
	public static void main(String [] args) {
	       int port = 6066;
	       final int MILISEG_ESPERA = 100000;
	       
	       try (ServerSocket serverSocket= new ServerSocket(port);) {
	        	System.out.println("Server says: Esperando al cliente en el puerto " +
	                                 serverSocket.getLocalPort() + "...");         	 
	    		/* creamos un temporizador de 10 segundos, si en 10 segundos 
	               no se conecta ningún cliente se generará la excepción
	               SocketTimeoutException */
	            serverSocket.setSoTimeout(MILISEG_ESPERA);
	    		
	            try (Socket server = serverSocket.accept();
	                 DataInputStream in = 
	                        new DataInputStream(server.getInputStream());
	                 DataOutputStream out = 
	                        new DataOutputStream(server.getOutputStream());) {
	                    
	                 System.out.println("Server says: Acabo de conectar con " + server.getRemoteSocketAddress());
	                 String leido;
	                 do {
	                	 System.out.println("HOLA SOY EL CLIENTE");
	                	 leido = in.readUTF();
	                     System.out.println("Client says: " + leido);
	                     if (!leido.equals("Bye")) {
	                         out.writeUTF("Mensaje recibido: " + leido);
	                     } else {
	                         out.writeUTF("Gracias por conectarte. Hasta la próxima!");
	                     }
	                     out.flush();
	                 }while(!(leido.equals("Bye")));
	                	 
	                 
	                 out.writeUTF("Gracias por conectarte con " + server.getLocalSocketAddress()
                     + " Hasta la próxima!");    
	            }catch(SocketTimeoutException s) {
	                System.out.println("Socket timed out!");
	                System.out.println("No se ha recibido ninguna petición de conexión en "
	                                +(MILISEG_ESPERA/1000)+" segundos");
	            }
	         }catch(IOException e) {
	            //e.printStackTrace();
	        	System.out.println("Error durante la conexión");
	            System.out.println("Excepción: "+e.toString());
	         } 
	      System.out.println("\nServidor detenido");
	   }
}
