package pa.hospital.conInterfaz;

public class Quirofano implements IReservable{
	private static int id_index = 1;
	private String id;
	private int id_num;
	
	
	public Quirofano() {
		this.id = "quirofano-" + id_index;
		id_num = id_index;
		id_index ++;
		
	}
	
	public int getId() {
		return id_num;
	}
	public void reservar() {
		System.out.println("Se ha reservado el quirófano " + this.getId());
	}
	
	public void anularReserva() {
		System.out.println("Se ha anulado la reserva del quirófano " + this.getId());
	}
}
