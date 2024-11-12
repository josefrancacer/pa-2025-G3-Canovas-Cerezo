package pa.hospital.sinInterfaz;

public class GestionSalasHospital {
	
	public void reservarQuirofano(Quirofano q) {
		q.reservar();
	}
	public void anularReservaQuirofano(Quirofano q) {
		q.anularReserva();
	}
	public void reservarSala(SalaVideo sala) {
		sala.reservar();
	}
	public void anularReservaSala(SalaVideo sala) {
		sala.anularReserva();
	}
}
