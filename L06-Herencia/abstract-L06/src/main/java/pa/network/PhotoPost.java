package pa.network;

import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * This class stores information about a post in a social network. 
 * The main part of the post consists of a photo and a caption. 
 * Other data, such as author and time, are also stored.
 * 
 * @author Michael Kölling and David J. Barnes
 * @version 0.1
 */
public class PhotoPost extends Post
{
    private String filename;  // the name of the image file
    private String caption;   // a one line image caption


    /**
     * Constructor for objects of class PhotoPost.
     * 
     * @param author    The username of the author of this post.
     * @param filename  The filename of the image in this post.
     * @param caption   A caption for the image.
     */
    public PhotoPost(String author, String filename, String caption)
    {
        super(author);
        this.filename = filename;
        this.caption = caption;
    }

  

    /**
     * Return the file name of the image in this post.
     * 
     * @return The post's image file name.
     */
    public String getImageFile()
    {
        return filename;
    }

    /**
     * Return the caption of the image of this post.
     * 
     * @return The image's caption.
     */
    public String getCaption()
    {
        return caption;
    }

    /**
     * Return the time of creation of this post.
     * 
     * @return The post's creation time formatted as "hh:mm:ss".
     */
  

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
         System.out.println("Message content: " + "[" + filename + "]" + " " + caption);
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
    
}
