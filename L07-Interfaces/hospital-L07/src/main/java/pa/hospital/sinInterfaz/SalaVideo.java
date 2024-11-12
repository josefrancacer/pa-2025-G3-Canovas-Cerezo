package pa.hospital.sinInterfaz;

public class SalaVideo {
	private int id;
	
	public SalaVideo(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void reservar() {
		System.out.println("Se ha reservado la sala de video " + id);
	}
	
	public void anularReserva() {
		System.out.println("Se ha anulado la reserva de la sala de video " + id);
	}
}
