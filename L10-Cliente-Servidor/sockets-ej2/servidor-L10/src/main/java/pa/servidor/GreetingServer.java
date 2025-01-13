package pa.servidor;


/**
 * Write a description of class GreetingServer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.net.*;
import java.io.*;

public class GreetingServer {

   public static void main(String [] args) {
       int port = 6066;
       final int MILISEG_ESPERA = 10000;
       
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
            
                 System.out.println("Client says: "+in.readUTF());
             
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
