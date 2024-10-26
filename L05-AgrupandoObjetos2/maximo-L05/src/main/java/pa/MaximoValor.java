package pa;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
public class MaximoValor {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		s.useLocale(Locale.ENGLISH);
		ArrayList<Double> lista_numeros = new ArrayList<>();
		System.out.println("Pon un número: ");
		do {
			 
			 double num = s.nextDouble();
			 lista_numeros.add(num);
			 }while(s.hasNextDouble());
		
		s.close();
		double maximo = 0;
		for(int i = 0; i< lista_numeros.size(); i++) {
			if (lista_numeros.get(i)> maximo) {
				maximo = lista_numeros.get(i);
			}
			
		}
		for(int i = 0; i<lista_numeros.size(); i++) {
			System.out.print(lista_numeros.get(i));
			if(lista_numeros.get(i) == maximo) {
				System.out.println("<== Valor máximo");
			}else {
				System.out.println();
			}
		}
			
				
	
}
}
