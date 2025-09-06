package job.example.portal.dto;

import java.time.LocalDateTime;

public class Application {

	private Long jobId;
	private Long applicationId;
	private LocalDateTime interviewing;
	private ApplicationStatus applicationStatus;
	
	public Long getJobId() {
		return jobId;
	}
	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}
	public Long getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
	}
	public LocalDateTime getInterviewing() {
		return interviewing;
	}
	public void setInterviewing(LocalDateTime interviewing) {
		this.interviewing = interviewing;
	}
	public ApplicationStatus getApplicationStatus() {
		return applicationStatus;
	}
	public void setApplicationStatus(ApplicationStatus applicationStatus) {
		this.applicationStatus = applicationStatus;
	}
	public Application() {
		super();
	}
	public Application(Long jobId, Long applicationId, LocalDateTime interviewing, ApplicationStatus applicationStatus) {
		this.jobId = jobId;
		this.applicationId = applicationId;
		this.interviewing = interviewing;
		this.applicationStatus = applicationStatus;
	}
}
