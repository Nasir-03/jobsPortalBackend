package job.example.portal.dto;

import java.time.LocalDateTime;

public class Experience {

	private String title;
	private String company;
	private String location;
	private LocalDateTime startDate;
	private LocalDateTime endDate;
	private boolean working;
	private String description;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public LocalDateTime getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}
	public LocalDateTime getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}
	public boolean isWorking() {
		return working;
	}
	public void setWorking(boolean working) {
		this.working = working;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Experience(String title, String company, String location, LocalDateTime startDate, LocalDateTime endDate,
			boolean working, String description) {
		super();
		this.title = title;
		this.company = company;
		this.location = location;
		this.startDate = startDate;
		this.endDate = endDate;
		this.working = working;
		this.description = description;
	}
	public Experience() {
		super();
	}
	
}
