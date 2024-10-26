package pa;
import pa.music.organizer.MusicOrganizer;
import java.util.Scanner;
public class PlayerModoTexto {
	public static void main(String[] args) {
		MusicOrganizer reproductor = new MusicOrganizer();
		String [] canciones = {"Best Friend_Sofi Tukker feat NERVO",
			"I Wish_Andrew Rayel-Robbie Seed-Jimmy Chou",
			"Infinitely Falling_Fly By Midnight",
			"Invincible_Christina Novelli_Nash_Tom Rogers_J.Puchler",
			"Just Around The Hill_Sash",
			"Respect-The Promise_When In Rome-Erasure-Kylie Minogue",
			"Robarte un Beso_Carlos Vives-Sebastián Yatra",
			"Save Your Tears_Ariana Grande",
			"Simples Corazones_Fonseca-feat Melendi",
			"Stay With Me_AVIRA-Linney",
			"Vagabundo_Sebastián Yatra-Manuel Turizo-Beele",
			"With My Own Eyes_Sash"};
	
		for(String cancion : canciones) {
			reproductor.addSong("src/main/resources/mp3/", ".mp3", cancion);
		}
		reproductor.printAllTitleNames();
		Scanner s = new Scanner(System.in);
		boolean continua = true;
		while(continua) {
			System.out.println("Introduce un número de tema: ");
			boolean valido = false;
			int num_index = -1;
			while(!valido) {
				num_index = s.nextInt();
				s.nextLine();
				if(num_index <= 0 || num_index > reproductor.getNumberOfFiles()) {
					System.out.println("Error, vuelva a introducir un número");
				}else {
					valido = true;
				}
			}
			reproductor.startPlaying(num_index);
			System.out.println("Voy a reproducir el tema ");
			reproductor.printTitleName(num_index-1);
			System.out.println("Pulse enter para parar la canción...");
			s.nextLine();
			reproductor.stopPlaying();
			System.out.println("Reproductor detenido");
			System.out.println("¿Quieres escuchar otra canción?(s/n)");
			String seguir = s.next();
			if(seguir.equals("s")){
				continua = true;
			}else {
				continua = false;
			}
		}
		System.out.println("Gracias por utilizar nuestro reproductor!!!");
		
		
		
		
		
		
	

	}
}

