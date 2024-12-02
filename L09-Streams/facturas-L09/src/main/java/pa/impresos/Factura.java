package pa.impresos;
import java.time.LocalDate;
import java.util.ArrayList;
import java.io.Serializable;

public class Factura implements Serializable{
	public static final int MAX_LINEAS = 6;
	private static int ultimoID = 1;
	private int id;
	private LocalDate fecha;
	private String cliente;
	private ArrayList<LineaFactura> lineas;
	private float total;
	private static final long serialVersionUID = 1L;
	
	public Factura(String c) {
		id = ultimoID;
		ultimoID++;
		cliente = c;
		fecha = LocalDate.now();
		lineas = new ArrayList<LineaFactura>();
		total = 0;
	}
	
	public ArrayList<LineaFactura> getLineas(){
		return lineas;
	}
	
	public int getId() {
		return id;
	}
	public LocalDate getFecha() {
		return fecha;
		
	}
	public float getTotal() {
		return total;
		
	}
	public String getCliente() {
		return cliente;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public void setLineas(ArrayList<LineaFactura> facturas) {
		this.lineas = facturas;
	}
	public int addLinea(LineaFactura nueva) {
		int res = 0;
		if(lineas.size()<MAX_LINEAS) {
			lineas.add(nueva);
			res = lineas.size();
			total += nueva.getImporte();
			
		}
		return res;
	}
}
