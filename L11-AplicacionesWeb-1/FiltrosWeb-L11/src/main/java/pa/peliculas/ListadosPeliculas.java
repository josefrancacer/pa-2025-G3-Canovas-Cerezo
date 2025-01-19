package pa.peliculas;

import java.util.ArrayList;

public class ListadosPeliculas {
	public ArrayList<Pelicula> peliculasDisponibles(){
		ArrayList<Pelicula> foroPelis = new ArrayList<>();
		String[] pelis = {"Peli1", "Peli2", "Peli3", "Peli4", "Peli5", "Peli6", "Peli7", "Peli8", "Peli9", "Peli10"};
		int[] votos = {100,350,435,800,98,220,600,850,927,689};
		for(int i=0; i<pelis.length; i++) {
			foroPelis.add(new Pelicula(pelis[i],votos[i]));
		}
		return foroPelis;
	}
	private static ArrayList<Pelicula> ordenarPelis(ArrayList<Pelicula> lista){
		int n = lista.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (lista.get(j).getVotos() < lista.get(j + 1).getVotos()) {
                    Pelicula temp = lista.get(j);
                    lista.set(j, lista.get(j + 1));
                    lista.set(j + 1, temp);
                }
            }
        }
        return lista;
		}
		
	public String[] peliculasMasVotadas(ArrayList<Pelicula> lista) {
		String[] masVotadas = new String[3];
		ArrayList<Pelicula> peliculas = ordenarPelis(lista);
		
		for(int i = 0; i<masVotadas.length; i++) {
			masVotadas[i] = peliculas.get(i).getName();
		}
		return masVotadas;
	}
	public String[] peliculasMenosVotadas(ArrayList<Pelicula> lista) {
		String[] menosVotadas = new String[3];
		ArrayList<Pelicula> peliculas = ordenarPelis(lista);
		
		for(int i =0; i< menosVotadas.length; i++) {
			menosVotadas[i] = peliculas.get(peliculas.size()-(1+i)).getName();
		}
		return menosVotadas;
	}
}	
