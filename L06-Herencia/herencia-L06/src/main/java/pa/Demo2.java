package pa;

import pa.network.MessagePost;
import pa.network.NewsFeed;
import pa.network.PhotoPost;
import pa.network.Post;

public class Demo2 {
	public static void main(String[] args) {
			NewsFeed feed = new NewsFeed();
			MessagePost mensaje = new MessagePost("jose", "Buenas tardes");
			PhotoPost foto = new PhotoPost("jose", "foto.jpg", "foto del día");
			feed.addPost(mensaje);
			feed.addPost(foto);
			for(int i = 0; i<3; i++) {
				mensaje.like();
			}
			mensaje.unlike();
			
			for(int i = 0; i<18; i++) {
				mensaje.like();
			}
			for(int i = 0; i<25; i++) {
				mensaje.unlike();
			}
			for(int i = 0; i<7; i++) {
				mensaje.addComment("comentario" + i);
			}
			for(int i = 0; i<35; i++) {
				foto.like();
			}
			for(int i = 0; i<4; i++) {
				foto.unlike();
			}
			for(int i = 0; i<10; i++) {
				foto.addComment("comentario" + i);
			}
			feed.show();
			
			
			
		
	}
}
