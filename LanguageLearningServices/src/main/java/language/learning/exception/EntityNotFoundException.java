package language.learning.exception;

public class EntityNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7904113578097095707L;

	public EntityNotFoundException() {
	}

	public EntityNotFoundException(String msg) {
		super(msg);
	}
}
