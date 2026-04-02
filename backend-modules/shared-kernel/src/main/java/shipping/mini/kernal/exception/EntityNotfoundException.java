package shipping.mini.kernal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "ID not found")
public class EntityNotfoundException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6943012653865812164L;

	public EntityNotfoundException(String message) {
		super(message);
	}

}
