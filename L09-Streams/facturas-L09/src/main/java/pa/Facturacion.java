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
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.BufferedOutputStream;
import java.io.ObjectInputStream;
import java.io.BufferedInputStream;
import java.io.FileInputStream;

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
	public void guardarFicheroFacturas() {
		try(ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream
				(new FileOutputStream("src/main/resources/factura.dat")))){
			System.out.println("Guardando facturas");
			for(Factura factura : facturas) {
				out.writeObject(factura);
				System.out.println("Guardada factura " + factura.getId());
			}
			
		}catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	public void leerFicheroFacturas() {
		Factura factura;
		try(ObjectInputStream in = new ObjectInputStream(new BufferedInputStream
				(new FileInputStream("src/main/resources/factura.dat")))){
			
			factura = (Factura) in.readObject();
			while(factura != null) {
				System.out.println("FACTURA LEIDA:");
				System.out.println("Fecha: " + factura.getFecha());
				System.out.println("Cliente: " + factura.getCliente());
				System.out.println("Total factura: " + factura.getTotal() + " euros");
				System.out.println("Número de líneas: " + factura.getLineas().size());
				for(int i = 0; i < factura.getLineas().size(); i++) {
					System.out.print("Servicio:  ");
					System.out.print(factura.getLineas().get(i).getServicio() + "  ");
					System.out.print(factura.getLineas().get(i).getLocalDate() + "  ");
					System.out.println(factura.getLineas().get(i).getImporte());
				}
				factura = (Factura) in.readObject();
			}
			
		}catch(IOException ex) {
			System.out.println(ex.getMessage());
		}catch(ClassNotFoundException ex) {
			System.out.println(ex.getMessage());
		}
	}
	public static void main(String[] args) {
		Facturacion sistemaf = new Facturacion();
		ArrayList<LineaFactura> lineasFacturas = sistemaf.leerLineas("src/main/resources/datosLineas.txt");
		sistemaf.generarFacturas(lineasFacturas);
		sistemaf.imprimirFacturas();
		sistemaf.guardarFicheroFacturas();
		sistemaf.leerFicheroFacturas();
	}
}
