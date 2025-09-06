package job.example.portal.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ApplicantDTO {

	private Long applicantId;
	private String name;
	private Long phone;
	private String webSite;
	private String coverLetter;
	private LocalDateTime timeStamp;
	 @JsonFormat(shape = JsonFormat.Shape.STRING)
	private ApplicationStatus applicationStatus;
	private LocalDateTime interviewTime;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	public String getWebSite() {
		return webSite;
	}
	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}
	public String getCoverLetter() {
		return coverLetter;
	}
	public void setCoverLetter(String coverLetter) {
		this.coverLetter = coverLetter;
	}
	public Long getApplicantId() {
		return applicantId;
	}
	public void setApplicantId(Long applicantId) {
		this.applicantId = applicantId;
	}
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
	public ApplicationStatus getApplicationStatus() {
		return applicationStatus;
	}
	public void setApplicationStatus(ApplicationStatus applicationStatus) {
		this.applicationStatus = applicationStatus;
	}
	public LocalDateTime getInterviewTime() {
		return interviewTime;
	}
	public void setInterviewTime(LocalDateTime interviewTime) {
		this.interviewTime = interviewTime;
	}
	public ApplicantDTO(Long applicantId, String name, Long phone, String webSite, String coverLetter,
			LocalDateTime timeStamp, ApplicationStatus applicationStatus,
			LocalDateTime interviewTime) {
		super();
		this.applicantId = applicantId;
		this.name = name;
		this.phone = phone;
		this.webSite = webSite;
		this.coverLetter = coverLetter;
		this.timeStamp = timeStamp;
		this.applicationStatus = applicationStatus;
		this.interviewTime = interviewTime;
	}
	public ApplicantDTO() {
		super();
	}
	
	
}
