package pa;

public class Prueba {
	public static void main(String [] args) {
		
		Book b1 = new Book("George R.R. Marin", "Juego de Tronos", 1300);
		Book b2 = new Book("Umberto Eco", "El nombre de la rosa", 987);
		Book b3 = new Book("Cristian Jacq", "Tuttankamon", 876);
		
		System.out.println("Creados los tres libros");
		
		b1.setRefNumber("01"); 
		b2.setRefNumber("001");
		b3.setRefNumber("0003");
		b1.printDetails();
		b2.printDetails();
		b3.printDetails();
		
		b1.setRefNumber("0001");
		b2.setRefNumber("0002");
		b1.printDetails();
		b2.printDetails();
		
		b1.prestar();
		b1.prestar();
		b2.prestar();
		
		for(int i = 1; i <= 20; i++) {
			b3.prestar();
		}
		b1.mostrarVecesPrestado();
		b2.mostrarVecesPrestado();
		b3.mostrarVecesPrestado();
		
	}
}
