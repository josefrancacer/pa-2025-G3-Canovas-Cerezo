package pa;

public class Cita {
	private int inicio; //0..24
	private int fin;  //0..24
	private int dia_semana;  //0..6
	
	public Cita() {
		this.dia_semana = 0;
		this.inicio = 0;
		this.fin = 1;	
	}
	
	public int getInicio() {
		return inicio;
	}
	
	public int getFin() {
		return fin;
	}
	
	public int getDia() {
		return dia_semana;
	}
		
	public void setDia(int dia) {
		if(dia_valido(dia)) {
			dia_semana= dia ;
	}
	}
		
	private boolean hora_valida(int hora) {
		boolean valido = true;
		if (hora < 0 || hora > 24) {
			valido = false;
			}	
		return valido;
	}
	private boolean franja_es_valida(int inicio, int fin) {
		boolean valido = false;
		if (hora_valida(inicio) && hora_valida(fin)) {
			if (fin > inicio) {
				valido = true;
			}
		}
		return valido;
	}
	
	private boolean dia_valido(int dia) {
		boolean valido;
		if (dia <= 6 && dia >= 0) {
			valido = True;
		}
		return valido;
		
	}
	public void setFranjaHoraria(int inicio, int fin) {
		if(franja_es_valida(inicio,fin)){
			this.inicio= inicio;
			this.fin = fin;	
		}
			
	}
	
	
	public boolean es_valida() {
		return false;
	}
	
	public boolean solapa_con(Cita c) {
		boolean solapa;
		if (this.dia_semana == c.dia_semana) {
			if((c.inicio > this.inicio && c.inicio < this.fin)||(c.fin > this.inicio && c.fin > this.inicio)) {
				solapa = true;
		}
	}
		return solapa;
	}
	
	private String mostrar_dia(int dia) {
		String dia_semana;
		String [] dias_semana = new String[] {"Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo"};
		dia_semana = dias_semana[dia];
		return dia_semana;
		
	}
	public void imprimir() {
		System.out.println("Datos de la cita:");
		System.out.println("hora inicio " + this.inicio + "h");
		System.out.println("hora fin " + this.fin + "h");
		System.out.println("Dia " + mostrar_dia(this.dia_semana));
		
	}

}
