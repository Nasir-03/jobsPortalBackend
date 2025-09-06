package job.example.portal.dto;

import java.time.LocalDateTime;

public class Certification {

	private String title;
	private String issuer;
	private LocalDateTime issueDate;
	private String certificationId;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIssuer() {
		return issuer;
	}
	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}
	public LocalDateTime getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(LocalDateTime issueDate) {
		this.issueDate = issueDate;
	}
	public String getCertificationId() {
		return certificationId;
	}
	public void setCertificationId(String certificationId) {
		this.certificationId = certificationId;
	}
	public Certification(String title, String issuer, LocalDateTime issueDate, String certificationId) {
		super();
		this.title = title;
		this.issuer = issuer;
		this.issueDate = issueDate;
		this.certificationId = certificationId;
	}
	public Certification() {
		super();
	}
	
}
