import pa.Cita;
import pa.Medico;

public class Prueba {
	public static void main(String [] args) {
		Cita [] citasfran = new Cita[8];
		String [] nombres = new String[] {"Pedro", "María","Lucas", "Ana","Gloria","Matías","Eva","Carlos"};
		int [] diasreserva = new int[]{2,2,2,2,2,3,8,4} ;
		String [] horarios = new String[] {"mañana", "mañana", "mañana", "mañana","mañana","otro","tarde","tarde"};
		Medico fran = new Medico("001","Oftalmólogo");
		fran.printHorario();
		for(int i = 0; i<= citasfran.length - 1; i++) {
			citasfran[i] = fran.reservarCita(diasreserva[i], horarios[i], nombres[i]);
			if (citasfran[i] != null) {
				citasfran[i].imprimirCita();
			}
		
		}
		fran.printHorario();
		
	}
}