package job.example.portal.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(UserAlreadyExistException.class)
	public ResponseEntity<ErrorResponse> handleUserAlreadyExist(UserAlreadyExistException ex) {
	    ErrorResponse error = new ErrorResponse(HttpStatus.CONFLICT.value(), ex.getMessage());
	    return new ResponseEntity<>(error, HttpStatus.CONFLICT);
	}
	
	// validation exception handler
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationErrors(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error ->
            errors.put(error.getField(), error.getDefaultMessage())
        );

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
	
	 @ExceptionHandler(UserNotRegisterException.class)
	  public ResponseEntity<ErrorResponse> handleUserNotRegisterException(UserNotRegisterException ex) {
		  ErrorResponse error = new ErrorResponse(HttpStatus.NOT_FOUND.value(),ex.getMessage());
		  return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	  }
	 
	 @ExceptionHandler(IllegalArgumentException.class)
	 public ResponseEntity<ErrorResponse> handleIllegalArgument(IllegalArgumentException exception){
		 ErrorResponse error = new ErrorResponse(HttpStatus.ALREADY_REPORTED.value(),exception.getMessage());
		 return new ResponseEntity<ErrorResponse>(error,HttpStatus.ALREADY_REPORTED);
	 }
	 
//	 @ExceptionHandler(Exception.class)
//	    public ResponseEntity<String> handleAllExceptions(Exception ex) {
//	        ex.printStackTrace();  // Show in console
//	        return new ResponseEntity<>("Internal server error: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//	    }
	
	 public ResponseEntity<ErrorResponse> handleResourceNotFound(ResourceNotFoundException ex){
		 ErrorResponse error = new ErrorResponse(HttpStatus.NOT_FOUND.value(),ex.getMessage());
		 return new ResponseEntity<ErrorResponse>(error,HttpStatus.NOT_FOUND);
	 }
	 
	 @ExceptionHandler(Exception.class)
	    public ResponseEntity<ErrorResponse> handleGeneric(Exception ex) {
	        ErrorResponse error = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
	        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	 
}
