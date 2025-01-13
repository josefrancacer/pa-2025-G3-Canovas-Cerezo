package pa.cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Cliente {
	
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
	          ) {
	         
	          System.out.println("Client says: Acabo de conectar con " 
	                       + client.getRemoteSocketAddress());
	         
	         //Escribimos un mensaje al servidor
	         out.writeUTF("Hola desde " + client.getLocalSocketAddress());
	          
	         //leemos el mensaje del servidor
	         System.out.println("Server says: " + in.readUTF());
	      }catch(IOException e) {
	        //  e.printStackTrace();
	        System.out.println("Conexión rechazada: ( "+e.getMessage()+ ")");
	      }
	      
	      System.out.println("\nEl cliente termina");
	    }

}
