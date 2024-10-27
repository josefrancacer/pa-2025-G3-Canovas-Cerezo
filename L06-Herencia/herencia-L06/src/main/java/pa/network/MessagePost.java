package pa.network;

import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * This class stores information about a post in a social network. 
 * The main part of the post consists of a (possibly multi-line)
 * text message. Other data, such as author and time, are also stored.
 * 
 * @author Michael Kölling and David J. Barnes
 * @version 0.1
 */
public class MessagePost extends Post 
{
    private String message;   // an arbitrarily long, multi-line message

    /**
     * Constructor for objects of class MessagePost.
     * 
     * @param author    The username of the author of this post.
     * @param text      The text of this post.
     */
    public MessagePost(String author, String text)
    {
        super(author);
        message = text;
    }
    /**
     * Return the text of this post.
     * 
     * @return The post's text.
     */
    public String getText()
    {
        return message;
    }

    /**
     * Display the details of this post.
     * 
     * (Currently: Print to the text terminal. This is simulating display 
     * in a web browser for now.)
     */
    @Override
    public void display()
    {
        System.out.println("Message author: " + username);
        System.out.println("Message content: " + message);
        System.out.print("Message date: " + timeString(timestamp));
        System.out.println("- " + likes + " people like this.");
        if(comments.size() > 0) {
       	 System.out.println("\t" + comments.size() + " comment(s):");
       	 for(int i = 0; i<comments.size(); i++) {
       		System.out.println("\t" + (i+1) + ". " + comments.get(i));
       	 }
        }else {
       	 System.out.println("\tNo comments.");
       	 
        }
        
        
    }
    
    /**
     * Create a string describing a time point in the past in terms 
     * relative to current time, such as "30 seconds ago" or "7 minutes ago".
     * Currently, only seconds and minutes are used for the string.
     * 
     * @param time  The time value to convert (in system milliseconds)
     * @return      A relative time string for the given time
     */
    
    
    
   
}
