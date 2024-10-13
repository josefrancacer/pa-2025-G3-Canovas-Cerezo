package pa;

public class Demo {
	public static void main(String[] args) {
		float [] notasmates = new float[]{7.0f, 0.2f, 3.2f, 5.8f, 6.4f, 1.4f, 4.7f, 5.5f, 1.6f, 5, 3, 1, 8.2f, 1.8f};
		NotasAsignatura mates = new NotasAsignatura("Matemáticas", notasmates);
		mates.mostrarNotas_en_columnas(0);
		mates.mostrarNotas_en_columnas(3);
		System.out.println("Nota mínima: " + mates.calcularValorMinimo());
		System.out.println("Nota máxima: " + mates.calcularValorMaximo());
		System.out.println("Nota media: " + mates.calcularMedia());
		
		mates.mostrarHistograma(3, 8);
		mates.mostrarHistograma(0, 5);
		mates.mostrarHistograma(3, 1);
	}

}
