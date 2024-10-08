package pa;
import java.util.Random;

public class PruebaCitas {
	
	public static void comparar_citas(Cita cita1, Cita cita2) {
		cita1.imprimir();
		cita2.imprimir();
		if (cita1.solapa_con(cita2)) {
			System.out.println("SOLAPAAAN");
		}
			else { System.out.println("NO SOLAPAN");
		}
		
	}
	public static void main(String[] args) {
		Random horas_aleatorias = new Random();
		Cita[] citas = new Cita[6];
		for (int i = 0; i<=5; i++) {
			citas[i] = new Cita();
			citas[i].imprimir();
			citas[i].setFranjaHoraria(horas_aleatorias.nextInt(0,24),horas_aleatorias.nextInt(0,24));
			citas[i].imprimir();
		}
		

	}

}
