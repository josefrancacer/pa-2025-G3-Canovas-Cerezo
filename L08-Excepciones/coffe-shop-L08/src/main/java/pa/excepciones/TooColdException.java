package pa.excepciones;

public class TooColdException extends Exception {
	public TooColdException() {};
	public TooColdException(String message) {
		super(message);
	}
}
