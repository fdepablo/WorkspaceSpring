package modelo.excepciones;

public class CustomException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomException(String mensaje) {
		super("Error!!!: " + mensaje);
	}
}
