package pa;
import pa.gui.EntornoGrafico;
public class PlayerModoGrafico {
	public static void main(String[] args) {
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
		EntornoGrafico reproducir = new EntornoGrafico(canciones);
		reproducir.startAplicacion();
	}
}
