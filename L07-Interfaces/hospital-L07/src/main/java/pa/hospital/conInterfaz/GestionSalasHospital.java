package pa.hospital.conInterfaz;

public class GestionSalasHospital {
	
	public void reservar(IReservable reserva) {
		reserva.reservar();
	}
	public void anularReserva(IReservable reserva) {
		reserva.anularReserva();
	}
}
