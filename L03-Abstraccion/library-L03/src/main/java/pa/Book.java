package pa;
/**
 * A class that maintains information on a book.
 * This might form part of a larger application such
 * as a library system, for instance.
 *
 * @author (Insert your name here.)
 * @version (Insert today's date here.)
 */
public class Book
{
    // The fields.
    private String author;
    private String title;
    private int pages;
    private String refNumber;
    private int borrowed;
    /**
     * Set the author and title fields when this object
     * is constructed.
     */
    public Book(String bookAuthor, String bookTitle, int bookPages)
    {
        author = bookAuthor;
        title = bookTitle;
        pages = bookPages;
        refNumber = "";
        
    }
    
    public String getAuthor() {
    	return author;
    }
    public String getTitle() {
    	return title;
    }
    public int getPages() {
    	return pages; 
    }
    public String getRefNumber() {
    	return refNumber;
    }
 
    public void setRefNumber(String refNumber) {
    	if(refNumber != null  && refNumber.length() >= 3) {
    		this.refNumber = refNumber;
    	}
    	else {
    		System.out.println("ERROR: El número de referencia del libro " + this.title + " debe contener al menos tres caracteres");
    	}
    }
    public void printDetails() {
        	System.out.println("Author: " + author);
        	System.out.println("Title: " + title);
        	System.out.println("Pages: " + pages);
        	if(refNumber.length() == 0) { // si aun no he llamado a setRefNumber
        		System.out.println("RefNumber: ZZZ");
        	}
        	else {
        		System.out.println("RefNumber: " + refNumber);
        	}
        	mostrarVecesPrestado();
        }
    	public int getBorrowed() {
        	return borrowed;
        }
        
        public void prestar() {
        	borrowed++;
        }
        
        public void mostrarVecesPrestado() {
        	System.out.print("Este libro se ha prestado " + borrowed);
        	if(borrowed == 1) {
        		System.out.println(" vez.");
        	}
        	else {
        		System.out.println(" veces.");
        	}
        }
        
    }   

