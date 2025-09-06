package job.example.portal.entity;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import job.example.portal.dto.ApplicationStatus;

public class Applicant {
	
	private Long applicantId;
	private String name;
	private Long phone;
	private String webSite;
	private String coverLetter;
	private LocalDateTime timeStamp;
	 @JsonFormat(shape = JsonFormat.Shape.STRING)
	private ApplicationStatus applicationStatus;
	private LocalDateTime interviewTime;
	
	public LocalDateTime getInterviewTime() {
		return interviewTime;
	}
	public void setInterviewTime(LocalDateTime interviewTime) {
		this.interviewTime = interviewTime;
	}
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
	
	public Applicant(Long applicantId, String name, Long phone, String webSite, String coverLetter,
			LocalDateTime timeStamp, ApplicationStatus applicationStatus,
			LocalDateTime interviewTime) {
		this.applicantId = applicantId;
		this.name = name;
		this.phone = phone;
		this.webSite = webSite;
		this.coverLetter = coverLetter;
		this.timeStamp = timeStamp;
		this.applicationStatus = applicationStatus;
		this.interviewTime = interviewTime;
	}
	public Applicant() {
		super();
	}
	
}
