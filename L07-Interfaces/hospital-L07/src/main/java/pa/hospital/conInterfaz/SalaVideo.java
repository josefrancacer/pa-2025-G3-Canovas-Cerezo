package pa.hospital.conInterfaz;

public class SalaVideo implements IReservable {
	private static int id_index = 100;
	private int id;
	
	public SalaVideo() {
		this.id = id_index;
		id_index++;
	}
	public int getId() {
		return id;
	}
	public void reservar() {
		System.out.println("Se ha reservado la sala de video " + this.getId());
	}
	
	public void anularReserva() {
		System.out.println("Se ha anulado la reserva de la sala de video " + this.getId());
	}
}
