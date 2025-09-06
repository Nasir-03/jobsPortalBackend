package job.example.portal.exception;

public class IllegalArgumentsExceptions extends RuntimeException{

	public IllegalArgumentsExceptions(String message) {
		super(message);
	}
	
	public IllegalArgumentsExceptions() {
		super();
	}
}
