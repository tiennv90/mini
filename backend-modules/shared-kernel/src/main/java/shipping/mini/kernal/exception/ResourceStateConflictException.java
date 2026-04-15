package shipping.mini.kernal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Resource state has conflict")
public class ResourceStateConflictException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2064868590014517397L;

	public ResourceStateConflictException(String message) {
		super(message);
	}

}
