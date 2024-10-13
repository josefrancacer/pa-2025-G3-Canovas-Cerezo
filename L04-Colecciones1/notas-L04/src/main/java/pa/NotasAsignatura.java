package pa;

public class NotasAsignatura {
	private String nombreAsignatura;
	private float [] notas;
	
	public NotasAsignatura(String nombreAsignatura, float[] notas) {
		this.nombreAsignatura = nombreAsignatura;
		this.notas = notas;
		
	}
	
	public String getNombreAsignaturas() {
		return nombreAsignatura;
		
	}
	public float[] getNotas() {
		return notas;
	}
	
	public float calcularValorMinimo() {
		float minimo;
		minimo = this.notas[0]; 
		for(int i = 1; i < notas.length; i++) {
			if (notas[i] < minimo) {
				minimo = notas[i];
			}
		}
		return minimo;
	}
	public float calcularValorMaximo() {
		float maximo;
		maximo = this.notas[0];
		for(int i = 1; i < notas.length; i++) {
			if (notas[i] > maximo) {
				maximo = notas[i];
			}	
		}
		return maximo;
	}
	
	public float calcularMedia() {
		float media;
		float suma = 0;
		for (int i = 0; i< notas.length; i++) {
			suma += notas[i];
		}
		media = suma/notas.length;
		return media;
	}
	
	private int[] calcularFrecuencias() {
		int pos;
		int [] frecuencia_notas = new int [11];
		for(float valor : notas) {
			pos = (int) valor;
			(frecuencia_notas[pos])++;
		}
		return frecuencia_notas;
	}
		
	public void mostrarHistograma(int inicio, int fin) {
		System.out.println("Histograma de notas de la asignatura: " + this.nombreAsignatura);
		System.out.printf("Intervalo de notas: [%1d,%1d] \n",inicio, fin);
		if(inicio >= 0 && inicio <= 10 && fin >= 0 && fin <= 10 && fin>=inicio) {
			int rango;
			rango = fin-inicio;
			int [] frecuencia_notas_completo = this.calcularFrecuencias();
			int [] frecuencia_notas_seccion = new int[11];
			for (int i = inicio; i <= fin; i++) {
				frecuencia_notas_seccion[i-inicio]= frecuencia_notas_completo[i];
			}
			int max = frecuencia_notas_seccion[0];
			for (int valor : frecuencia_notas_seccion) {
				if ( valor > max) {
					max = valor;
				}
			}
			
			System.out.println("Frecuencia máxima en el intervalo: " + max);
			for(int i = max; i>0; i--) {
				for(int j = 0; j <= rango; j++) {
					if(frecuencia_notas_seccion[j] >= i) {
						System.out.print("  *");
					}
					else {
						System.out.print("   ");
					}
				}
				System.out.println("");
			}
			for(int i = 0; i<= rango ; i++ ) {
				System.out.print("---");
			}
			System.out.println("");
			for(int i = 0; i<=rango; i++) {
				System.out.printf("%3d", i+inicio);
			}
			System.out.println("");
		} else{
			System.out.print("Rango de valores inválido\n");
		}
	}

public void mostrarNotas_en_columnas(int num_columnas) {
	System.out.print("Listado de notas de la asignatura: " + this.nombreAsignatura +
			"\n\tNúmero de columnas: " + num_columnas + "\n");
	if(num_columnas != 0) {
		int i = 0;
		for (float valor : notas) {
			i++;
			System.out.print("\t");
			System.out.printf("%6.1f", valor);
			if(i == num_columnas) {
				System.out.println("");
				i = 0;
			}
		}
		System.out.print("\n");
	} else {
		System.out.println("\tError:El número de columnas indicado debe ser mayor que cero");
	}
	
	}
}


