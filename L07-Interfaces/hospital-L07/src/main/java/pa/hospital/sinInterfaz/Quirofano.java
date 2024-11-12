package pa.hospital.sinInterfaz;

public class Quirofano {
	private String id;
	
	public Quirofano(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	public void reservar() {
		System.out.println("Se ha reservado el quirófano " + id);
	}
	
	public void anularReserva() {
		System.out.println("Se ha anulado la reserva del quirófano " + id);
	}
}
