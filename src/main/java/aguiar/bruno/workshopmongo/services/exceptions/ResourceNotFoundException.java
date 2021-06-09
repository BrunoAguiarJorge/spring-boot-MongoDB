package aguiar.bruno.workshopmongo.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {
	private static final long serialversionUID = 1L;
	
	public ResourceNotFoundException(String msg) {
		super(msg);
	}
}
