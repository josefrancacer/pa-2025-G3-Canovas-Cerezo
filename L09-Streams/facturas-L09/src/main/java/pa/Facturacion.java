package pa;
import pa.impresos.Factura;
import pa.impresos.LineaFactura;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.time.LocalDate;

public class Facturacion {
	private ArrayList<Factura> facturas;
	public Facturacion() {
		facturas = new ArrayList<Factura>();
	} 
	public Factura buscarFactura(String cliente) {
		Factura encontrada = null;
		int i;
		
		i = 0;
		while(i<facturas.size() && encontrada == null) {
			if(cliente.equals(facturas.get(i).getCliente())) {
				encontrada = facturas.get(i);
			}
			else {
				i++;
			}
		}
		
		return encontrada;
		
	}
	public void generarFacturas(ArrayList<LineaFactura> lineas) {
		Factura f;
		for(LineaFactura linea : lineas) {
			f = buscarFactura(linea.getIdCliente());
			if(f == null) {
				f = new Factura(linea.getIdCliente());
				f.addLinea(linea);
				facturas.add(f);	
			}
			else {
				f.addLinea(linea);
			}
		}
	}
	
	public ArrayList<LineaFactura> leerLineas(String archivo){
		ArrayList<LineaFactura> lineas_factura = new ArrayList<>();
		try(FileReader fr = new FileReader(archivo);
				BufferedReader in = new BufferedReader(fr) ){
			int i = 0;
			String [] datosFactura = new String[4];
			String linea;
				do {
					linea = in.readLine();
					if(i==4) {
						lineas_factura.add(new LineaFactura(datosFactura[0], 
								datosFactura[1], LocalDate.parse(datosFactura[2]) , Float.parseFloat(datosFactura[3])));
						i = 0;
					}else {
						datosFactura[i]= linea;
						i++;
					}		
						
				}while(linea != null);
		
			}catch (IOException ex) {
				System.out.println("ERROR" + ex.getMessage());
			}
			
		return lineas_factura;
	}
	
	public void imprimirFacturas() {
		System.out.println(facturas.size());
		for(Factura factura : facturas) {
			System.out.println("hola");
			String archivo = "src/main/resources/fichero" + factura.getId()+".txt";
			try(FileWriter fw = new FileWriter(archivo); 
					BufferedWriter out = new BufferedWriter(fw)){
				out.write(String.format("%-14s%-16s%-10s","Fecha","Servicio","Importe"));
				out.newLine();
				out.write(String.format("%-14s%-16s%-10s","-","-","-").replace(' ','-'));
				out.newLine();
				for(LineaFactura linea: factura.getLineas()) {
					//línea de separación
					//Cada línea de factura
					out.write(String.format("%-14s", linea.getLocalDate()));
					out.write(String.format("%-16s", linea.getServicio()));
					out.write(String.format("%-10s", linea.getImporte()));
					out.newLine();
					
				}
				out.write("Total importe: " + factura.getTotal());
				
				
				
			}catch(IOException ex) {
				System.out.println(ex.getMessage());
			}
		}
		
		
	}
	public static void main(String[] args) {
		Facturacion sistemaf = new Facturacion();
		ArrayList<LineaFactura> lineasFacturas = sistemaf.leerLineas("src/main/resources/datosLineas.txt");
		sistemaf.generarFacturas(lineasFacturas);
		sistemaf.imprimirFacturas();
	}
}
