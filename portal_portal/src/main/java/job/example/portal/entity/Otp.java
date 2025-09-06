package job.example.portal.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Otp {

	@Id
	private String email;
	private String otpCode;
	private LocalDateTime creationTime;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getOtpCode() {
		return otpCode;
	}
	public void setOtpCode(String otpCode) {
		this.otpCode = otpCode;
	}
	public LocalDateTime getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(LocalDateTime creationTime) {
		this.creationTime = creationTime;
	}
	public Otp() {
		super();
	}
	public Otp(String email, String otpCode, LocalDateTime creationTime) {
		super();
		this.email = email;
		this.otpCode = otpCode;
		this.creationTime = creationTime;
	}
	
}
