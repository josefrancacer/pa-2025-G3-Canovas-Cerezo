package pa;
import pa.music.organizer.MusicOrganizer;
import java.util.ArrayList;
public class PlayerSoloListaDeTemas {
	public static void main(String[] args) {
		MusicOrganizer organizador = new MusicOrganizer();
		String [] canciones = new String[] {"tema1A", "tema2B", "tema3A", "tema4B" , "tema5A", "tema6B", "tema7B"};
		for(String cancion : canciones) {
			organizador.addSong("/pa", ".mp3", cancion);
		}
		System.out.println("Inicializamos nuestro organizador de música...");
		System.out.println("Listado de todos los temas");
		organizador.printAllTitleNames();
		System.out.println("Listado de todos los ficheros");
		organizador.printAllFileNames();
		System.out.print("EL título de la posición 3 es: ");
		organizador.printTitleName(3);
		System.out.print("EL título de la posición -1 es: " );
		organizador.printTitleName(-1);
		System.out.print("EL título de la posición 8 es: ");
		organizador.printTitleName(8);
		System.out.println("Añadimos un nuevo tema");
		organizador.addSong("/pa", ".mp3", "tema1C");
		char b = 'B';
		ArrayList<String> titles = new ArrayList<>(); 
		titles = organizador.getFiles();
		for(int i = titles.size() -1; i >= 0; i--) {
			boolean tieneB = false;
			int j =0;
			while(j < titles.get(i).length() && tieneB == false){
				char caracter = titles.get(i).charAt(j);
				if(caracter == b) {
					organizador.removeSong(i);
					tieneB= true;
					}
					else { 
						j++;	
				}
			}
		}
		System.out.println("Nuevo listado de nombres de canciones");
		organizador.printAllTitleNames();
		System.out.println("Nuevo listado de ficheros mp3: ");
		organizador.printAllFileNames();
	}
}
