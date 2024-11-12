package pa.hospital.sinInterfaz;

public class DemoSinInterfaz {

	public static void main(String[] args) {
		GestionSalasHospital gestion = new GestionSalasHospital();
		Quirofano [] quirofanos = new Quirofano[7];
		for(int i = 0; i<quirofanos.length; i++) {
			quirofanos[i] = new Quirofano("Q" + (i+1));
		}
		SalaVideo [] salas = new SalaVideo[10];
		for(int i = 0; i<salas.length ; i++) {
			salas[i] = new SalaVideo(i+1);
		}
		
		for(Quirofano q : quirofanos) {
			gestion.reservarQuirofano(q);
			gestion.anularReservaQuirofano(q);
		}
		for(SalaVideo sala : salas) {
			gestion.reservarSala(sala);
			gestion.anularReservaSala(sala);
		}
		
	}

}
