package pa.network;

import pa.network.MessagePost;
import java.util.ArrayList;
import pa.network.MessagePost;


/**
 * The NewsFeed class stores news posts for the news feed in a social network 
 * application.
 * 
 * Display of the posts is currently simulated by printing the details to the
 * terminal. (Later, this should display in a browser.)
 * 
 * This version does not save the data to disk, and it does not provide any
 * search or ordering functions.
 * 
 * @author Michael Kölling and David J. Barnes
 * @version 0.1
 */
public class NewsFeed
{
    private ArrayList<Post> posts;

    /**
     * Construct an empty news feed.
     */
    public NewsFeed()
    {
        posts = new ArrayList<>();
        
    }

    /**
     * Add a text post to the news feed.
     * 
     * @param message  The text post to be added.
     */
    public void addPost(Post post)
    {
        posts.add(post);
    }

    /**
     * Add a photo post to the news feed.
     * 
     * @param photo  The photo post to be added.
     */
  
    /**
     * Show the news feed. Currently: print the news feed details to the
     * terminal. (To do: replace this later with display in web browser.)
     */
    public void show()  {
        for(int i = 0; i<posts.size(); i++) {
        	posts.get(i).display();
            // Debes imprimir una línea en blanco después de mostrar cada tipo de mensaje
 
        }
    }
}
