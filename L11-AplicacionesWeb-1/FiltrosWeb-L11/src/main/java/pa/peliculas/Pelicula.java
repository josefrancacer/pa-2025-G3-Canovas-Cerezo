package pa.peliculas;

public class Pelicula {
	private String name;
	private int votos;
	
	public Pelicula(String nombre, int num_votos){
		name = nombre;
		votos = num_votos;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getVotos() {
		return votos;
	}

	public void setVotos(int votos) {
		this.votos = votos;
	}
	
}
