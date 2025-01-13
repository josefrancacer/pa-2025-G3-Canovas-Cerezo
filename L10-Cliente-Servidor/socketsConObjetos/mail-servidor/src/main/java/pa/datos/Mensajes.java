package pa.datos;

import java.util.ArrayList;
import java.util.Arrays;

import pa.MailItem;

public class Mensajes {
    public static ArrayList<MailItem> mensajesPrueba1 = new ArrayList<>(
    		Arrays.asList(
    				new MailItem("Carlos","Marta", "Mensaje número 1"),
    				new MailItem("Pedro","Marta", "Mensaje número 2"),
    				new MailItem("Luis","Marta", "Mensaje número 3")
    				)
    		);			
}
