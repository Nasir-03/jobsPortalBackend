package job.example.portal.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import job.example.portal.dto.ApplicantDTO;
import job.example.portal.dto.Application;
import job.example.portal.dto.ApplicationStatus;
import job.example.portal.dto.JobDTO;
import job.example.portal.dto.JobStatus;
import job.example.portal.entity.Applicant;
import job.example.portal.entity.Job;
import job.example.portal.exception.ResourceNotFoundException;
import job.example.portal.exception.UserNotRegisterException;
import job.example.portal.mapper.ApplicantMapper;
import job.example.portal.mapper.JobMapper;
import job.example.portal.repository.JobRepository;
import job.example.portal.utility.SequenceGeneratorService;

@Service
public class JobServiceImpl implements jobService{

	private SequenceGeneratorService sequenceGeneratorService;
	private JobRepository jobRepository;
	
	@Autowired
	public JobServiceImpl(JobRepository jobRepository, SequenceGeneratorService sequenceGeneratorService) {
		this.jobRepository = jobRepository;
		this.sequenceGeneratorService = sequenceGeneratorService;
	}
	
//	@Override
//	public JobDTO postJob(JobDTO jobDTO) {
//	    if (jobDTO.getId() == null) { // NEW job case
//	        jobDTO.setId(sequenceGeneratorService.generateSequence("job_sequence")); // always Long
//	        jobDTO.setPostTime(LocalDateTime.now());
//	    } else { // UPDATE existing job case
//	        Job existingJob = jobRepository.findById(jobDTO.getId())
//	                .orElseThrow(() -> new UserNotRegisterException("Job not found"));
//
//	        if (existingJob.getJobStatus().equals(JobStatus.DRAFT) ||
//	            jobDTO.getJobStatus().equals(JobStatus.CLOSED)) {
//	            jobDTO.setPostTime(LocalDateTime.now());
//	        }
//	    }
//
//	    Job job = JobMapper.toJobEntity(jobDTO);
//	    jobRepository.save(job);
//	    return JobMapper.toJobDTO(job);
//	}
	
	
	
	
	@Override
	public JobDTO postJob(JobDTO jobDTO) {
	    try {
	        if (jobDTO.getId() == null) {
	            jobDTO.setId(sequenceGeneratorService.generateSequence("job_sequence"));
	            jobDTO.setPostTime(LocalDateTime.now());
	        } else {
	            Job existingJob = jobRepository.findById(jobDTO.getId())
	                .orElseThrow(() -> new UserNotRegisterException("Job not found"));

	            if (existingJob.getJobStatus().equals(JobStatus.DRAFT) ||
	                jobDTO.getJobStatus().equals(JobStatus.CLOSED)) {
	                jobDTO.setPostTime(LocalDateTime.now());
	            }
	        }

	        System.out.println("Saving JobDTO: " + jobDTO);

	        Job job = JobMapper.toJobEntity(jobDTO);
	        System.out.println("Converted Job Entity: " + job);

	        jobRepository.save(job);

	        return JobMapper.toJobDTO(job);
	    } catch (Exception e) {
	        e.printStackTrace(); // will show the real error in logs
	        throw e;
	    }
	}

	


	
	@Override
	public List<JobDTO> getAllJobs() {
	    List<Job> jobs = jobRepository.findAll();
	    List<JobDTO> dtos = new ArrayList<>();
	    for (Job job : jobs) {
	        try {
	            JobDTO dto = JobMapper.toJobDTO(job);
	            dtos.add(dto);
	        } catch (Exception e) {
	            System.err.println("Error converting job ID " + job.getId() + ": " + e.getMessage());
	            e.printStackTrace();
	        }
	    }
	    return dtos;
	}

	@Override
	public JobDTO getJob(Long id) {
		Job job = jobRepository.findById(id).
				orElseThrow(() -> new UserNotRegisterException("post not found"));
		
		return JobMapper.toJobDTO(job);		
	}

	@Override
	public ApplicantDTO applyJob(Long id, ApplicantDTO applicantDTO) {
		Job job = jobRepository.findById(id)
				.orElseThrow(()-> new UserNotRegisterException("Job not found "));
	
	    List<Applicant> applicants = job.getApplicants();
	    if (applicants == null)applicants = new ArrayList<>();
	    
	    if (applicantDTO.getApplicantId() != null &&
	    	    applicants.stream().anyMatch(x -> 
	    	        Objects.equals(x.getApplicantId(), applicantDTO.getApplicantId())
	    	    )) {
	    	    throw new IllegalArgumentException("Applicant already registered for this job.");
	    	}

	    applicantDTO.setApplicationStatus(ApplicationStatus.APPLIED);
	    Applicant applicant=ApplicantMapper.toEntity(applicantDTO);
	    applicants.add(applicant);
        job.setApplicants(applicants);
        jobRepository.save(job);
        return ApplicantMapper.toDTO(applicant);
	}

	public List<JobDTO> getJobPostedBy(Long id) {
	    return jobRepository.findByPostedBy(id)
	            .stream()
	            .map(JobMapper::toJobDTO) // static method reference
	            .toList();
	}

//	@Override
//	public void changeAppStatus(Application application) {
//		Job job = jobRepository.findById(application.getId()).
//				orElseThrow(() -> new ResourceNotFoundException("Job not found"));
//	
//	List<Applicant> applicants = job.getApplicants().stream().map((x) -> {
//		if (application.getApplicationId()==x.getApplicantId()) {
//			x.setApplicationStatus(application.getApplicationStatus());
//			if (application.getApplicationStatus().
//					equals(ApplicationStatus.INTERVIEWING))x.setInterviewTime(application.getInterviewing());
//		}
//		return x;
//	}).toList();
//	}

	
	
	@Override
	public void changeAppStatus(Application application) {
	    Job job = jobRepository.findById(application.getJobId()) // ✅ now explicit
	            .orElseThrow(() -> new ResourceNotFoundException("Job not found"));

	    for (Applicant applicant : job.getApplicants()) {
	        if (applicant.getApplicantId().equals(application.getApplicationId())) {
	            applicant.setApplicationStatus(application.getApplicationStatus());
	            if (application.getApplicationStatus() == ApplicationStatus.INTERVIEWING) {
	                applicant.setInterviewTime(application.getInterviewing());
	            }
	        }
	    }

	    jobRepository.save(job);
	}




}
