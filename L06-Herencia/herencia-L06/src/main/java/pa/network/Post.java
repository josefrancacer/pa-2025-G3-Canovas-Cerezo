package pa.network;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Post {
	protected String username;
    protected long timestamp;   // tiempo actual en milisegundos
    protected int likes;
    protected ArrayList<String> comments;
    
    public Post(String author) {
    	username = author;
        timestamp = System.currentTimeMillis();
        likes = 0;
        comments = new ArrayList<>();
    	
    }
    public void like() {
    	likes++;
    }
    public void unlike() {
    	if (likes > 0) {
            likes--;
    	}
    }
    public void addComment(String text)
    {
        comments.add(text);
    }
    public String getTimeStamp()
    {
        String date = new SimpleDateFormat("H:mm:ss").format(new Date(timestamp));
        return date;
    }
    
    public void display()
    {
    	 System.out.println("Message author: " + username);
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
    protected String timeString(long time)
    {
        long current = System.currentTimeMillis();
        long pastMillis = current - time;      // time passed in milliseconds
        long seconds = pastMillis/1000;
        long minutes = seconds/60;
        if(minutes > 0) {
            return minutes + " minutes ago";
        }
        else {
            return seconds + " seconds ago";
        }
    }
}
