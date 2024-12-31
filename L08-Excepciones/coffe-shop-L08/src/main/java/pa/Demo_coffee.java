package pa;

import pa.coffe.VirtualPerson;
import pa.coffe.VirtualCafe;
import pa.coffe.CoffeCup;
import java.util.ArrayList;

public class Demo_coffee {
		public static void main(String [] args) {
			VirtualCafe cafeteria = new VirtualCafe("Costa");
			String [] temps = {
					"aaa", "","20","95", "75", "18", "35.7", "55"};
			String [] names = {
					"", "Roberto","Verónica","Alberto","María"
			};
			ArrayList<CoffeCup> cafes = new ArrayList<>();
			System.out.println("Creamos los cafés que podemos servir");
			for(String temp: temps) {
				try {
					cafes.add(new CoffeCup(Integer.parseInt(temp)));
					System.out.println("La entrada con valor: " + temp + " es valida");
				}catch(NumberFormatException ex) {
					if(temp.equals("")) {
						System.out.println("Detectado un valor de temperatura vacío");
					}else {
						System.out.println("Entrada incorrecta: "+ temp + " no es un número entero");
					}
				}
				
			}
			for(String name : names) {
				if(name.equals("")) {
					cafeteria.addClient(new VirtualPerson(), false);
				}else {
					cafeteria.addClient(new VirtualPerson(name), false);
				}
			}
			VirtualPerson cliente = cafeteria.getNextClient();
			int i=0;
			boolean otroCafe;
			
			while(cliente != null) {
				otroCafe = cafeteria.serveCustomer(cliente, cafes.get(i%cafes.size()));
				if(otroCafe) {
					cafeteria.addClient(cliente, false);
				}
				cliente = cafeteria.getNextClient();
				i++;
			}
			System.out.println("Ya no quedan más clientes por servir");
			System.out.println("Hoy se ha recaudado " + cafeteria.getGanancias() + " euros");
		}
	}

