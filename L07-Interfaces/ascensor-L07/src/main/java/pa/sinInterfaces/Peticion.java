package pa.sinInterfaces;

/**
 * Cada petición se caracteriza por un piso de destino (piso_destino) y un identificador (id),
 * ambos de tipo entero. Los valores de los dos atributos NO se podrán cambiar, pero sí consultar.
 * En el caso del identificador, su valor no se pasará como parámetro en el constructor, sino que 
 * se asignará automáticamente, comenzando con el valor 0, y cada nueva petición verá incrementado 
 * en 1 su valor de id.
 */
public class Peticion {
	private int piso_destino;
	private int id;
	private static int next_id = 0;
	
	public Peticion(int pd) {
		piso_destino = pd;
		id = next_id++;
	}
	public int getId() {
		return id;
	}
	
	public int getPisoDestino() {
		return piso_destino;
	}
	
	//los atributos se llamarán "piso_destino" e "id" y son privados.
	
}
