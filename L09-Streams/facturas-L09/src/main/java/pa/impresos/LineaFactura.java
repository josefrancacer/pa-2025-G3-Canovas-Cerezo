package pa.impresos;

import java.time.LocalDate;
import java.io.Serializable;

public class LineaFactura implements Serializable {
	private String idCliente;
	private String servicio;
	private LocalDate date;
	private float importe;
	private static final long serialVersionUID = 1L;
	public LineaFactura(String i, String s, LocalDate id, float im) {
		idCliente = i;
		servicio = s;
		date = id;
		importe = im;
		
	}
	
	
	public String getIdCliente() {
		return idCliente;
	}
	public String getServicio() {
		return servicio;
		
	}
	public LocalDate getLocalDate() {
		return date;
	}
	public float getImporte() {
		return importe;
	}
}
