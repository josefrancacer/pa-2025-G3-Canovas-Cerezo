package pa.cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.regex.Pattern;

public class TalkCliente {
	public static void main(String [] args) {
	      String serverName = "localhost";
	      int port = 6066;
	      
	      System.out.println("Client says: Intentando conectar con " 
	                          + serverName + " en el puerto " + port);
	      try (Socket client = new Socket(serverName, port); 
	    	   DataOutputStream out = 
	    			  new DataOutputStream(client.getOutputStream());
	           DataInputStream in = 
	        		  new DataInputStream(client.getInputStream());
	    		  Scanner sc = new Scanner(System.in);
	          ) {
	         
	          System.out.println("Client says: Acabo de conectar con " 
	                       + client.getRemoteSocketAddress() + "HOLAAA FUNCIONOOO");
	          
	          String leido;
	         //Escribimos un mensaje al servidor
	          do {
	        	 System.out.println("HOLA SOY EL SERVIDOR");
	        	 leido = sc.nextLine();
	        	 out.writeUTF(leido);
	        	 out.flush();
	        	 System.out.println("Server says: " + in.readUTF());
	          } while(!leido.equals("Bye"));
	          
	         //leemos el mensaje del servidor
	      }catch(IOException e) {
	        //  e.printStackTrace();
	        System.out.println("Conexión rechazada: ( "+e.getMessage()+ ")");
	      }
	      
	      System.out.println("\nEl cliente termina");
	    }
}
