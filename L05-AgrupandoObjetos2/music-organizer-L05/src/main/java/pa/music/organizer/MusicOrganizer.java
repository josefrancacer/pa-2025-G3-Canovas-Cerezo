package pa.music.organizer;

import java.util.ArrayList;
import pa.music.player.MusicPlayer;

/**
 * A class to hold details of audio fileNames. It includes a player
 * to play the audio files.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 */
public class MusicOrganizer {
    /**
     * An ArrayList for storing the music fileNames
     * The fileName includes a file extension and
     * directory path file, i.e. "/src/main/resources/title1.mp3"
     */
    private ArrayList<String> fileNames;
    /**
     * An ArrayList for storing the titles of music fileNames
     * (extension file and path file are not included)
     */
    private ArrayList<String> titles;
    /**
     * A player for the music fileNames
     */
    private MusicPlayer player;
        
    /**
     * Create a MusicOrganizer
     */
    public MusicOrganizer() {
        fileNames = new ArrayList<>();
        player = new MusicPlayer();
        titles = new ArrayList<>();
    }
    
    
    /**
     * Return the number of fileNames in the collection.
     * @return The number of fileNames in the collection.
     */
    public int getNumberOfFiles() {
        return fileNames.size();
    }
    
    
    /**
     * Return an ArrayList with the fileNames in the collection.
     * @return An ArrayList with the fileNames in the collection.
     */    
    public ArrayList<String> getFiles() {
        return fileNames;
    }
    
    
    
    /**
     * Start playing a file in the collection if the index is valid.
     * Plays all frames of file (unless stopPlaying() is used)
     * @param index The index of the file to be played .
     */
    public void startPlaying(int index) {
        if(validIndex(index)) {
            String filename = fileNames.get(index-1);
            player.playFile(filename);
        }
    }

    /**
     * Stop the player.
     */
    public void stopPlaying() {
        player.stop();
    }

    /**
     * Play a file in the collection if the index is valid. 
     * Only plays a sample (first 500 frames of the file). Then stops.
     * @param index The index of the file to be played.
     */
    public void playAndWait(int index) {
        if(validIndex(index)) {
            String filename = fileNames.get(index-1);
            player.playSample(filename);
        }
    }
    
    /**
     * Play a file in the collection if the index is valid. 
     * Only plays a sample (first numFrames frames
     * of the file given as a parameter). Then stops.
     * @param index The index of the file to be played.
     * @param numFrames The number of frames to be played
     */
    public void playAndWait(int index, int numFrames) {
        if(validIndex(index)) {
            String filename = fileNames.get(index-1);
            player.playSample(filename,numFrames);
        }
    }
    
    
    /**
     * Initialize the fileNames and titles of our music organizer
     * with an array of titles.
     * <p>
     * clears fileNames and titles fields.
     * Then adds title names, and file names to fileNames and titles fields,
     * respectively.
     * </p>
     * <p>
     * A file name is created adding to a title the preffix 
     * "src/main/resources/mp3/", and the suffix ".mp3".
     * Then, each file name is added to fileNames field
     * </p>
     * @param path Path string of all title names
     * @param extension Extension string of all title names
     * @param nombresTemas Array of Strings with title names
     * 
     */
    public void loadSongs(String path, String extension, String[] nombresTemas) {
        for(String tema: nombresTemas) {
        	fileNames.add(path + tema + extension);
        	titles.add(tema);
        }
    }
    
    /**
     * Determine whether the given index is valid for the collection.
     * Print an error message if it is not:
     * - "Index cannot be negative or zero: ", when the index is negative or zero,
     * - "Index is too large: ", when the index is > that collection size
     * 
     * @param index The index to be checked.
     * @return true if the index is valid, false otherwise.
     */
    private boolean validIndex(int index) {
        boolean valido = true;
        if(index <= 0) {
        	valido = false;
        	System.out.println("Index cannot be negative or zero");
        }else if(index > titles.size()) {
        	valido = false;
        	System.out.println("Index is too large");
        }
        
        return valido;
    }
    
    /**
     * Print a file name from the collection if index is a valid value
     * @param index The index of the file to be printed
     */
    public void printFileName(int index) {
    	if(validIndex(index)) {
    		System.out.println(fileNames.get(index));
    		
    	}
    	
    }
    
    /**
     * Show a numbered list of all the fileNames in the collection.
     * The first fileName is numbered with 1, and so on
     * i.e. 1. /path/Filename.mp3
     *      2. /path/OtherFilename.mp3
     *      3. /path/FileNameThree.mp3
     */
    public void printAllFileNames() {
    	
    	for(int i = 0; i< fileNames.size(); i++) {
    		System.out.println((i+1) + ". " + fileNames.get(i));
    	}
    }
    
    /**
     * Print a title song in the collection if index is a valid value.
     * i.e. /path/Filename.mp3
     * @param index The index of the file to be printed.
     */
    public void printTitleName(int index) {
    	if(validIndex(index)) {
    		System.out.println(titles.get(index));
    	}
    	
    }
    	
    /**
     * Show a numbered list of all the titleNames in the collection.
     * The first fileName is numbered with 1, and so on
     * i.e. 1. Title One
     *      2. Title Two
     *      3. Title Three
     */
    public void printAllTitleNames() {
    	for(int i = 0; i< titles.size(); i++) {
    		System.out.println((i+1) + ". " + titles.get(i));
    	}
    }
    
    /**
     * Find the index of the first file matching the given
     * search string.
     * @param searchString The string to match.
     * @return The index of the first occurrence, or -1 if
     *         no match is found.
     */
    public int findFirst(String searchString) {
    	int index = -1;
    	boolean encontrado = false;
    	int i = 0;
    	while(i < fileNames.size() && !encontrado) {
    		if(searchString.equals(fileNames.get(i))) {
    			encontrado = true;
    			index = i;
    		}else {
    			i++;
    		}
    	}
    	return index;
    }
    
    /**
     * Add a file and the corresponding title to the collection.
     * @param path The path or the file to be added. 
     * @param extension Extension of the filename to be added
     * @name The filename to be added
     */
    public void addSong(String path, String extension, String title) {
    	titles.add(title);
    	fileNames.add(path + title + extension);
    }
    
    /**
     * Remove a file and the corresponding title from the collection if the index is valid.
     * @param index The index of the file to be removed.
     */
    public void removeSong(int index) {
    	if(validIndex(index)) {
    		titles.remove(index);
    		fileNames.remove(index);
    	}
    }
    
}
