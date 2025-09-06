package job.example.portal.dto;

public class MailResponseDTO {

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public MailResponseDTO(String message) {
		this.message = message;
	}

	public MailResponseDTO() {
		super();
	}
	
}
