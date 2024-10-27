package pa.network;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public abstract class Post {
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
    
    public abstract void display();

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
