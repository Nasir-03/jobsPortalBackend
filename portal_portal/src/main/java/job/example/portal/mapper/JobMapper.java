package job.example.portal.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import job.example.portal.dto.ApplicantDTO;
import job.example.portal.dto.JobDTO;
import job.example.portal.entity.Applicant;
import job.example.portal.entity.Job;

//public class JobMapper {
//
//	public static Job toJobEntity(JobDTO dto) {
//		// Ensure we always have a typed list
//		List<ApplicantDTO> applicantDTOList = dto.getApplicants() != null ? dto.getApplicants() : new ArrayList<>();
//
//		List<Applicant> applicants = applicantDTOList.stream().map(ApplicantMapper::toEntity) // ApplicantDTO →
//																								// Applicant
//				.collect(Collectors.toList());
//
//		return new Job(dto.getId(), dto.getJobTitle(), dto.getCompany(), applicants, dto.getAbout(),
//				dto.getExperience(), dto.getJobType(), dto.getLocation(), dto.getPackagedOffer(), dto.getPostTime(),
//				dto.getDescription(), dto.getSkillsRequired(), dto.getJobStatus(),dto.getPostedBy());
//	}
//
//	public static JobDTO toJobDTO(Job job) {
//		 if (job == null) {
//			 throw new IllegalArgumentException("is is null");
//		 }
//		
//		// Ensure we always have a typed list
//		List<Applicant> applicantList = job.getApplicants() != null ? job.getApplicants() : new ArrayList<>();
//
//		List<ApplicantDTO> applicantDTOs = applicantList.stream().map(ApplicantMapper::toDTO) // Applicant →
//																								// ApplicantDTO
//				.collect(Collectors.toList());
//
//		return new JobDTO(job.getId(), job.getJobTitle(), job.getCompany(), applicantDTOs, job.getAbout(),
//				job.getExperience(), job.getJobType(), job.getLocation(), job.getPackagedOffer(), job.getPostTime(),
//				job.getDescription(), job.getSkillsRequired(), job.getJobStatus(),job.getPostedBy());
//	}
//}


//
//public class JobMapper {
//
//    public static Job toJobEntity(JobDTO dto) {
//        if (dto == null) {
//            throw new IllegalArgumentException("JobDTO cannot be null in JobMapper.toJobEntity");
//        }
//
//        List<Applicant> applicants = (dto.getApplicants() != null ? dto.getApplicants() : List.<ApplicantDTO>of())
//                .stream()
//                .map(ApplicantMapper::toEntity)
//                .toList();
//
//        return new Job(
//                dto.getId(),
//                dto.getJobTitle(),
//                dto.getCompany(),
//                applicants,
//                dto.getAbout(),
//                dto.getExperience(),
//                dto.getJobType(),
//                dto.getLocation(),
//                dto.getPackagedOffer(),
//                dto.getPostTime(),
//                dto.getDescription(),
//                dto.getSkillsRequired() != null ? dto.getSkillsRequired() : new ArrayList<>(),
//                dto.getJobStatus(),
//                dto.getPostedBy()
//        );
//    }
//
//    public static JobDTO toJobDTO(Job job) {
//        if (job == null) {
//            throw new IllegalArgumentException("Job cannot be null in JobMapper.toJobDTO");
//        }
//
//        List<ApplicantDTO> applicantDTOs = (job.getApplicants() != null ? job.getApplicants() : List.<Applicant>of())
//                .stream()
//                .map(ApplicantMapper::toDTO)
//                .toList();
//
//        return new JobDTO(
//                job.getId(),
//                job.getJobTitle(),
//                job.getCompany(),
//                applicantDTOs,
//                job.getAbout(),
//                job.getExperience(),
//                job.getJobType(),
//                job.getLocation(),
//                job.getPackagedOffer(),
//                job.getPostTime(),
//                job.getDescription(),
//                job.getSkillsRequired() != null ? job.getSkillsRequired() : new ArrayList<>(),
//                job.getJobStatus(),
//                job.getPostedBy()
//        );
//    }
//}

//
//package job.example.portal.mapper;
//
//import job.example.portal.dto.JobDTO;
//import job.example.portal.dto.ApplicantDTO;
//import job.example.portal.entity.Job;
//import job.example.portal.entity.Applicant;
//
//import java.util.stream.Collectors;

public class JobMapper {

    public static JobDTO toJobDTO(Job job) {
        if (job == null) return null;

        JobDTO dto = new JobDTO();
        dto.setId(job.getId());
        dto.setJobTitle(job.getJobTitle());
        dto.setCompany(job.getCompany());
        dto.setAbout(job.getAbout());
        dto.setExperience(job.getExperience());
        dto.setJobType(job.getJobType());
        dto.setLocation(job.getLocation());
        dto.setPackagedOffer(job.getPackagedOffer());
        dto.setPostTime(job.getPostTime());
        dto.setDescription(job.getDescription());
        dto.setSkillsRequired(job.getSkillsRequired());
        dto.setJobStatus(job.getJobStatus());
        dto.setPostedBy(job.getPostedBy());

        // 🔥 Convert applicants
        dto.setApplicants(
            job.getApplicants().stream()
                .map(ApplicantMapper::toDTO)
                .collect(Collectors.toList())
        );

        return dto;
    }

    public static Job toJobEntity(JobDTO dto) {
        if (dto == null) return null;

        Job job = new Job();
        job.setId(dto.getId());
        job.setJobTitle(dto.getJobTitle());
        job.setCompany(dto.getCompany());
        job.setAbout(dto.getAbout());
        job.setExperience(dto.getExperience());
        job.setJobType(dto.getJobType());
        job.setLocation(dto.getLocation());
        job.setPackagedOffer(dto.getPackagedOffer());
        job.setPostTime(dto.getPostTime());
        job.setDescription(dto.getDescription());
        job.setSkillsRequired(dto.getSkillsRequired());
        job.setJobStatus(dto.getJobStatus());
        job.setPostedBy(dto.getPostedBy());

        // 🔥 Convert applicants
        job.setApplicants(
            dto.getApplicants().stream()
                .map(ApplicantMapper::toEntity)
                .collect(Collectors.toList())
        );

        return job;
    }
}
