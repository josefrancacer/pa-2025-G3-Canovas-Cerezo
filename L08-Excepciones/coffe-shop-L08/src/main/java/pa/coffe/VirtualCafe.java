package pa.coffe;
import java.util.ArrayList;

import pa.excepciones.TooColdException;
import pa.excepciones.TooHotException;

public class VirtualCafe {
	private String name;
	private ArrayList<VirtualPerson> clientes;
	private double ganancias;
	private static final double PRECIO_CAFE = 2;
	private static final double PROPINA = 0.5;
	
	public VirtualCafe(String n) {
		name = n;
		clientes = new ArrayList<>();
		ganancias = 0;
	}
	public void cobrarCafe(boolean propina) {
		double pagado = 0;
		if(propina) {
			pagado += PROPINA;
		}
		pagado += PRECIO_CAFE;
		System.out.println("Cobrado: " + pagado + " euros");
		ganancias += pagado;
	}
	
	public void addClient(VirtualPerson cliente, boolean nuevoCliente) {
		if(nuevoCliente) {
			System.out.println("El cliente "+ cliente.getName()+" ha "
					+ "entrado en la cafetería " + name );
		}
		this.clientes.add(cliente);
	}
	public boolean serveCustomer(VirtualPerson cust, CoffeCup cup) {
		boolean repite = false;
		System.out.println("Hola, " + cust.getName() + " aquí tiene su café.");
		
		try {
			cust.drinkCoffe(cup);
			System.out.println(name + ": el café está en su punto. GRACIAS!");
			cobrarCafe(true);
		} catch(TooHotException exception) {
			System.out.println(exception.getMessage());
			cobrarCafe(false);
		} catch(TooColdException exception) {
			System.out.println(exception.getMessage());
			repite = true;
			
		}
		
		return repite;
	}
	public VirtualPerson getNextClient() {
		VirtualPerson nextClient = null;
		if(clientes.size()>0) {
			nextClient = clientes.get(0);
			clientes.remove(0);
		}
		
		return nextClient;
	}
	public double getGanancias() {
		return ganancias;
	}
}
