package job.example.portal.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class JobDTO {

	private Long id;
	private String jobTitle;
	private String company;
	private List<ApplicantDTO> applicants = new ArrayList<>();
	private String about;
	private String experience;
	private String jobType;
	private String location;
	private Long packagedOffer;
	private LocalDateTime postTime;
	private String description;
	private List<String>skillsRequired;
	private JobStatus jobStatus;
	private Long postedBy;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public Long getPostedBy() {
		return postedBy;
	}
	public void setPostedBy(Long postedBy) {
		this.postedBy = postedBy;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public List<ApplicantDTO> getApplicants() {
		return applicants;
	}
	public void setApplicants(List<ApplicantDTO> applicants) {
		this.applicants = applicants;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getJobType() {
		return jobType;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Long getPackagedOffer() {
		return packagedOffer;
	}
	public void setPackagedOffer(Long packagedOffer) {
		this.packagedOffer = packagedOffer;
	}
	public LocalDateTime getPostTime() {
		return postTime;
	}
	public void setPostTime(LocalDateTime postTime) {
		this.postTime = postTime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<String> getSkillsRequired() {
		return skillsRequired;
	}
	public void setSkillsRequired(List<String> skillsRequired) {
		this.skillsRequired = skillsRequired;
	}
	public JobStatus getJobStatus() {
		return jobStatus;
	}
	public void setJobStatus(JobStatus jobStatus) {
		this.jobStatus = jobStatus;
	}
	public JobDTO(Long id, String jobTitle, String company, List<ApplicantDTO> applicants, String about, String experience,
			String jobType, String location, Long packagedOffer, LocalDateTime postTime, String description,
			List<String> skillsRequired, JobStatus jobStatus,Long postedBy) {
		super();
		this.id = id;
		this.jobTitle = jobTitle;
		this.company = company;
		this.applicants = (applicants != null) ? applicants : new ArrayList<>();
		this.about = about;
		this.experience = experience;
		this.jobType = jobType;
		this.location = location;
		this.packagedOffer = packagedOffer;
		this.postTime = postTime;
		this.description = description;
		this.skillsRequired = skillsRequired;
		this.jobStatus = jobStatus;
		this.postedBy = postedBy;
	}
	public JobDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
