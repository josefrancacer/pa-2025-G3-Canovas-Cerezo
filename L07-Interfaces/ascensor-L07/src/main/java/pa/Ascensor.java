package pa;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import pa.sinInterfaces.Peticion;


/**
 * Un ascensor tendrá los siguientes atributos:
 * - peticiones: es una colección ilimitada de objetos de tipo Peticion, y contiene todas las peticiones
 * de los usuarios que hay en la planta en la que el ascensor se ha detenido y ha abierto sus puertas.
 * - peticiones_validas: es una colección ilimitada de objetos de tipo Petición, y contiene las peticiones
 * válidas (son las peticiones de las personas que finalmente subirán al ascensor)
 * - piso_actual: es un entero que representa el piso en el que se encuentra actualmente el ascensor
 * - lector_peticiones: de tipo Scanner, usaremos este objeto para leer los pisos de destino de las personas
 * que están esperando para subir al ascensor.
 * - IMPORTANTE: el ascensor puede recorrer un náximo de 20 pisos, y puede llevar a 4 personas como máximo.
 */
public class Ascensor {
	
	private ArrayList<Peticion> peticiones;
	private ArrayList<Peticion> peticiones_validas;
	private int piso_actual;
	private String entrada;
	private IAccesoDatos entrada_datos;
	private static final int MAX_PISOS = 20;
	private static final int MAX_PERSONAS = 4;
	//declaración de atributos. Son todos privados.
	
	
	public Ascensor(String entrada) {
		peticiones = new ArrayList<Peticion>();
		peticiones_validas = new ArrayList<Peticion>();
		piso_actual = 0;
		this.entrada = entrada;
		if(entrada.equals("terminal")) {
			entrada_datos = new EntradaDesdeTeclado();
		}else {
			if(entrada.equals("fichero")) {
				entrada_datos = new EntradaDesdeFichero();
			}
			else {
				System.out.println("El método de entrada de datos no es correcto");
			}
		}
		
	}

	
	/**
	 * El método nuevo_aviso recibe una petición por parámetro, y devuelve el mensajes de error
	 * asociado a dicha petición, cuyo valor dependerá de:
	 * a) si es una petición válida pero ya está el ascensor lleno, el mensaje será:
	 *    "- El usuario que ha pulsado X ya no cabe\n" (siendo X el número de piso de destino)
	 * b) si es una petición con un valor de piso de destino incorrecto (fuera del rango de
	 *    pisos que puede recorrer el ascensor, el mensaje será:
	 *    "- El usuario que ha pulsado X ha introducido un valor incorrecto\n"
	 * c) si el usuario ya está en la planta a la que ha solicitado ir, el mensaje será:   
	 *    "- El usuario que ha pulsado X ya está en esa planta\n"
	 * El mensaje de error de cada petición será una línea de texto que se concatenará con los mensajes 
	 * de invocaciones previas     
	 */
	private String nuevo_aviso(Peticion p) {
		String mensaje_error = null;
		if(p.getPisoDestino() >= 0 && p.getPisoDestino()<= MAX_PISOS && p.getPisoDestino() != this.piso_actual) {
			if(this.peticiones_validas.size() >= MAX_PERSONAS) {
				mensaje_error = "\t  - El usuario que ha pulsado " + p.getPisoDestino() + " ya no cabe\n";
				piso_actual = p.getPisoDestino();
			}
			
		}
		else {
			if(p.getPisoDestino() > MAX_PISOS) {
				mensaje_error = "\t  - El usuario que ha pulsado " + p.getPisoDestino() + " ha introducido un valor incorrecto\n";
				piso_actual = p.getPisoDestino();
			}
			if(p.getPisoDestino() == piso_actual) {
				mensaje_error = "\t  - El usuario que ha pulsado " + p.getPisoDestino() + " ya está en esa planta\n";
				piso_actual = p.getPisoDestino();
			}
		}
		
		//cada nuevo aviso se añadirá
		
		return mensaje_error;
	}
	
	/**
	 * El método leer_peticiones usa la clase Scanner para leer los números de piso
	 * a los que quieren ir cada una de las personas. Dichos valores los introducirá el usuario
	 * por teclado. Los números de piso de destino serán enteros. Para poder deteminar el 
	 * final la entrada, usaremos el carácter 'A', que incluiremos al final.
	 * Por ejemplo: 3 5 10 12 A
	 *              representan las peticiones 3, 5, 10 y 12.
	 * El método leer_peticiones devuelve el número de peticiones leídas.
	 */
	public int leer_peticiones() {
		int [] peticiones = entrada_datos.obtenerDatos();
		
		//aquí leemos los pisos de destino. Usaremos los métodos hasNextInt() y nextInt() de la clase Scanner
		//para cada dato leido crearemos el objeto Peticion correspondiente, y lo añadiremos a la lista
		//de peticiones del ascensor.
		
		//usaremos el método nextLine() cuando ya no queden enteros por leer, de esta forma
		//"leeremos" el carácter 'A' y el retorno de carro
		//lector_peticiones.nextLine();
		
		return peticiones.length; //aquí devolveremos el número de peticiones que hemos leído	
	}
	
	/**
	 * Este método analiza todas y CADA UNA de las peticiones de la lista peticiones,
	 * de forma que:
	 * - una petición será válida si el piso de destino está dentro del rango de pisos 0..20 y
	 * 	 el piso de destino es diferente al piso actual.
	 * - si la petición es válida, y la persona cabe en el ascensor, entonces dicha petición se añade
	 *   a la lista peticiones_validas
	 * - si la petición no es válida, entonces se genera un nuevo mensaje de aviso, que se
	 * 	 añade (concatena) a los avisos de peticiones anteriores en la lista.
	 * - cada petición, una vez analizada para ver si es válida o no, se borra de la lista de peticiones.
	 * 
	 * El método, después seleccionar las peticiones válidas y obtener la lista peticiones_validas
	 * mostrará por pantalla el mensaje:
	 * "Entran en el ascensor las personas que van a los pisos: x, y, z, ...", en donde x, y, z, ...
	 * son los pisos de destino, separados por comas, de las personas que finalmente entran en el 
	 * ascensor (como máximo serán 4)
	 * 
	 * Si hay peticiones no válidas, el método imprime por pantalla:
	 * "AVISOS" + todos los avisos asociados a cada petición no válida de la lista de peticiones.
	 *  Los avisos de cada petición no válida, se han concatenado en una única
	 *  variable de tipo String. (ver traza de ejecución)
	 * 
	 * El método devuelve el número de avisos que se han generado, que serán tantos como peticiones
	 * no válidas haya
	 */
	public int analizar_peticiones () {
		int num_avisos = 0;
		String avisos = ""; //aquí vamos concatenando todos los avisos de todas las peticiones no válidas
		Iterator<Peticion> iterador = peticiones.iterator();
		while(iterador.hasNext()) {
			Peticion peticion = iterador.next();
			if(nuevo_aviso(peticion) == null) {
				peticiones_validas.add(peticion);
				iterador.remove();
				
				
			}else {
				avisos += nuevo_aviso(peticion);
				num_avisos ++;
			}
		}
		System.out.print("Entran en el ascensor las personas que van a los pisos: ");
		for(Peticion peticion : peticiones_validas) {
			System.out.print(peticion.getPisoDestino() + ", ");
			
		}
		System.out.println();
		if(!avisos.equals("")) {
			System.out.println("\tAVISOS:");
			System.out.println(avisos);
			System.out.println();
		}
		
		
		//analizamos una a una todas las peticiones pasadas por parámetro
		
		//mostramos los pisos de destino de las personas que suben al ascensor
		
		//mostramos los avisos, si los hay
		
		
	   return num_avisos;  //devolvemos el número de avisos (peticiones no válidas)
	}
	
	
	/**
	 * Este método pone en marcha el ascensor para llevar a cada uno de sus ocupantes a los
	 * pisos de destino que han solicitado, las cuales serán las peticiones de la lista
	 * peticiones_validas. 
	 * 
	 * El método imprime el mensaje: "Cerrando puertas. Estamos en el piso: X", siendo X
	 * el piso actual en el que se encuentra el ascensor.
	 * Las peticiones se van antendiendo de una en una, y PARA CADA petición:
	 * - si se solicita ir a un piso más alto que el actual, se mostrará el mensaje:
	 *     "Subiendo a una persona la planta Y" (siendo Y la planta de destino solicitada
	 * - si se solicita ir a un piso inferior al actual, se mostrará el mensaje:
	 *     "Bajando a una persona la planta Y" 
	 * - si la petición anterior a la actual ha solicitado la misma planta, entonces se 
	 *   mostrará el mensaje: 
	 *    "La siguiente persona también puede bajar"  
	 * - Después de procesar CADA petición, ésta se ELIMINARÁ de la lista peticiones_validas
	 * - El ascensor actualizará su posición actual cada vez que suba o baje a la planta de destino.        
	 */
	public void llevar_personas_a_sus_destinos() {	
			System.out.println("Cerrando puertas. Estamos en el piso: " + this.piso_actual);
			Iterator<Peticion> iterador = peticiones_validas.iterator();
			while(iterador.hasNext()) {
				Peticion p = iterador.next();
				if (p.getPisoDestino()>piso_actual) {
					System.out.println("\t Subiendo a una persona a la planta: " + p.getPisoDestino());
				}
				else {
					if(p.getPisoDestino()<piso_actual) {
						System.out.println("\t Bajando a una persona a la planta: " + p.getPisoDestino());
					}
					else {
						System.out.println("La siguiente persona también puede bajar");
					}
				}
				iterador.remove();
			}
	}
	
	
	

}
