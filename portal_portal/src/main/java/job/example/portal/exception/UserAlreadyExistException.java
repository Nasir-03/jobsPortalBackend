package job.example.portal.exception;

public class UserAlreadyExistException extends RuntimeException{

	public UserAlreadyExistException(String message) {
        super(message);
    }
	
	public UserAlreadyExistException() {
		super();
	}
}
