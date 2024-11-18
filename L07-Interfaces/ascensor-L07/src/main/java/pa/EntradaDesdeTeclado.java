package pa;

import java.util.Scanner;
import java.util.ArrayList;

public class EntradaDesdeTeclado implements IAccesoDatos{
	private Scanner lector_peticiones;
	public EntradaDesdeTeclado() {
		lector_peticiones = new Scanner(System.in);
	}
	@Override
	public int[] obtenerDatos() {
		ArrayList<Integer> peticiones = new ArrayList<>();
		System.out.println("\n---------------------------------");
		System.out.println("Estoy en el piso: "); //aquí añadiremos el piso_actual);
		System.out.println("Puertas abiertas. Espero peticiones: ");
		while(lector_peticiones.hasNextInt()) {
			int num_piso = lector_peticiones.nextInt();
			peticiones.add(num_piso);
		}
		lector_peticiones.nextLine();
		
		int [] pisos_num = new int[peticiones.size()];
		
		for (int i = 0; i< peticiones.size(); i++) {
			pisos_num[i] = peticiones.get(i);
		}
		
		//aquí leemos los pisos de destino. Usaremos los métodos hasNextInt() y nextInt() de la clase Scanner
		//para cada dato leido crearemos el objeto Peticion correspondiente, y lo añadiremos a la lista
		//de peticiones del ascensor.
		
		//usaremos el método nextLine() cuando ya no queden enteros por leer, de esta forma
		//"leeremos" el carácter 'A' y el retorno de carro
		//lector_peticiones.nextLine();
		
		return pisos_num; //aquí devolveremos el número de peticiones que hemos leído	
	}
}
