package job.example.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import job.example.portal.dto.ApplicantDTO;
import job.example.portal.dto.Application;
import job.example.portal.dto.JobDTO;
import job.example.portal.entity.Job;
import job.example.portal.repository.JobRepository;
import job.example.portal.service.jobService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/jobs")
public class JobController {
	
	private jobService jobService;
	
	@Autowired
	private JobRepository jobRepository;
	
	@Autowired
	public JobController(job.example.portal.service.jobService jobService) {
		this.jobService = jobService;
	}

	@PostMapping("/post")
	public ResponseEntity<JobDTO> postJob(@RequestBody JobDTO jobDTO){
		JobDTO dto = jobService.postJob(jobDTO);
		return new ResponseEntity<JobDTO>(dto,HttpStatus.OK);
	}
	
//	@GetMapping("/allJobs")
//	public ResponseEntity<List<JobDTO>> getAllJobs() {
//		List<JobDTO> lst = jobService.getAllJobs();
//		return new ResponseEntity<List<JobDTO>>(lst,HttpStatus.OK);
//	}
	
	@GetMapping("/allJobs")
	public List<Job> getAllJobs() {
	    return jobRepository.findAll();
	}

	
	@GetMapping("/get/{id}")
	public ResponseEntity<JobDTO> getJob(@PathVariable Long id) {
		 JobDTO dto = jobService.getJob(id);
		return new ResponseEntity<JobDTO>(dto,HttpStatus.OK);
	}
	
	@PostMapping("/apply/{id}")
	public ResponseEntity<ApplicantDTO> applyJob(@PathVariable Long id,
			@RequestBody ApplicantDTO applicantDTO){
		ApplicantDTO dto = jobService.applyJob(id, applicantDTO);
		return new ResponseEntity<ApplicantDTO>(dto, HttpStatus.OK);
	}
	
	@GetMapping("/PostedBy/{id}")
	public ResponseEntity<List<JobDTO>> getJobPostedBy(@PathVariable Long id) {
		 List<JobDTO> dto = jobService.getJobPostedBy(id);
		return new ResponseEntity<>(dto,HttpStatus.OK);
	}
	
	@PostMapping("/changeAppStatus")
	public void changeStatus(@RequestBody Application application) {
		 jobService.changeAppStatus(application);
	}
}
