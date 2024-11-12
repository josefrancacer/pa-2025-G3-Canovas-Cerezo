package pa.hospital.conInterfaz;

import pa.hospital.conInterfaz.GestionSalasHospital;
import pa.hospital.conInterfaz.Quirofano;
import pa.hospital.conInterfaz.SalaVideo;

public class DemoConInterfaz {
	public static void main(String[] args) {
		GestionSalasHospital gestion = new GestionSalasHospital();
		Quirofano [] quirofanos = new Quirofano[7];
		for(int i = 0; i<quirofanos.length; i++) {
			quirofanos[i] = new Quirofano();
		}
		SalaVideo [] salas = new SalaVideo[10];
		for(int i = 0; i<salas.length ; i++) {
			salas[i] = new SalaVideo();
		}
		
		for(Quirofano q : quirofanos) {
			gestion.reservar(q);
			gestion.anularReserva(q);
		}
		
		for(SalaVideo sala : salas) {
			gestion.reservar(sala);
			gestion.anularReserva(sala);
		}
	}
}
