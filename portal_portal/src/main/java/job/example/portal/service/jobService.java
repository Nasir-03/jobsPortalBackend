package job.example.portal.service;

import java.util.List;

import job.example.portal.dto.ApplicantDTO;
import job.example.portal.dto.Application;
import job.example.portal.dto.JobDTO;

public interface jobService {

	public JobDTO postJob(JobDTO jobDTO);
	public List<JobDTO> getAllJobs();
	public JobDTO getJob(Long id);
	public ApplicantDTO applyJob(Long id, ApplicantDTO applicantDTO);
	public List<JobDTO> getJobPostedBy(Long id);
	public void changeAppStatus(Application application);
}
