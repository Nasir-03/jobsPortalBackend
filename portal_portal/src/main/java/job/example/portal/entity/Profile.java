//package job.example.portal.entity;
//
//import java.util.List;
//
//import org.springframework.data.mongodb.core.mapping.Document;
//
//import job.example.portal.dto.Certification;
//import job.example.portal.dto.Experience;
//
//@Document(collection = "profiles")
//public class Profile {
//
//	private Long id;
//	private String email;
//	private String jobTitle;
//	private String company;
//	private String location;
//	private String about;
//	private byte[] imageData; 
//	private List<String> skills;
//	private List<Experience> experiences;
//	private List<Certification> certificates;
//	
//	public Profile(Long id, String email, String jobTitle, String company, String location, String about,
//			byte[] imageData,List<String> skills, List<Experience> experiences, List<Certification> certificates) {
//		super();
//		this.id = id;
//		this.email = email;
//		this.jobTitle = jobTitle;
//		this.company = company;
//		this.location = location;
//		this.about = about;
//		this.imageData = imageData;
//		this.skills = skills;
//		this.experiences = experiences;
//		this.certificates = certificates;
//	}
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getJobTitle() {
//		return jobTitle;
//	}
//
//	public void setJobTitle(String jobTitle) {
//		this.jobTitle = jobTitle;
//	}
//
//	public String getCompany() {
//		return company;
//	}
//	
//	 public byte[] getImageData() {
//	        return imageData;
//	    }
//
//	    public void setImageData(byte[] imageData) {
//	        this.imageData = imageData;
//	    }
//
//	public void setCompany(String company) {
//		this.company = company;
//	}
//
//	public String getLocation() {
//		return location;
//	}
//
//	public void setLocation(String location) {
//		this.location = location;
//	}
//
//	public String getAbout() {
//		return about;
//	}
//
//	public void setAbout(String about) {
//		this.about = about;
//	}
//
//	public List<String> getSkills() {
//		return skills;
//	}
//
//	public void setSkills(List<String> skills) {
//		this.skills = skills;
//	}
//
//	public List<Experience> getExperiences() {
//		return experiences;
//	}
//
//	public void setExperiences(List<Experience> experiences) {
//		this.experiences = experiences;
//	}
//
//	public List<Certification> getCertificates() {
//		return certificates;
//	}
//
//	public void setCertificates(List<Certification> certificates) {
//		this.certificates = certificates;
//	}
//
//	public Profile() {
//		super();
//	}
//	
//	
//}


package job.example.portal.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import job.example.portal.dto.Certification;
import job.example.portal.dto.Experience;

@Document(collection = "profile")
public class Profile {
    @Id
    private Long id;
    private String name;
	private String jobTitle;
    private String company;
    private String location;
    private String about;
    private byte[] imageData;
    private Long totalExp;
    private String email;
	private List<String> skills;
	private List<Experience> experiences;
	private List<Certification> certificates;
	private List<Long> savedJobs;

    public Long getTotalExp() {
		return totalExp;
	}

	public void setTotalExp(Long totalExp) {
		this.totalExp = totalExp;
	}

	public List<Long> getSavedJobs() {
		return savedJobs;
	}

	public void setSavedJobs(List<Long> savedJobs) {
		this.savedJobs = savedJobs;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	public List<Experience> getExperiences() {
		return experiences;
	}

	public void setExperiences(List<Experience> experiences) {
		this.experiences = experiences;
	}

	public List<Certification> getCertificates() {
		return certificates;
	}

	public void setCertificates(List<Certification> certificates) {
		this.certificates = certificates;
	}

	public Profile() {}

    public Profile(Long id,String name, String jobTitle, String company, String location, String about, byte[] imageData,
    		Long totalExp,String email,List<String> skills,List<Experience> experiences,
    		List<Certification> certificates,List<Long> savedJobs) {
        this.id = id;
        this.name = name;
        this.jobTitle = jobTitle;
        this.company = company;
        this.location = location;
        this.about = about;
        this.imageData = imageData;
        this.totalExp = totalExp;
        this.email = email;
        this.skills = skills;
        this.experiences = experiences;
        this.certificates = certificates;
        this.savedJobs = savedJobs;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getJobTitle() { return jobTitle; }
    public void setJobTitle(String jobTitle) { this.jobTitle = jobTitle; }

    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getAbout() { return about; }
    public void setAbout(String about) { this.about = about; }

    public byte[] getImageData() { return imageData; }
    public void setImageData(byte[] imageData) { this.imageData = imageData; }
}

