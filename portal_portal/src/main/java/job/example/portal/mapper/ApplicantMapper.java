package job.example.portal.mapper;

import job.example.portal.dto.ApplicantDTO;
import job.example.portal.entity.Applicant;

public class ApplicantMapper {
	
	public static ApplicantDTO toDTO(Applicant applicant) {
        return new ApplicantDTO(
            applicant.getApplicantId(),
            applicant.getName(),
            applicant.getPhone(),
            applicant.getWebSite(),
            applicant.getCoverLetter(),
            applicant.getTimeStamp(),
            applicant.getApplicationStatus(),
            applicant.getInterviewTime()
        );
    }

    public static Applicant toEntity(ApplicantDTO dto) {
        return new Applicant(
            dto.getApplicantId(),
            dto.getName(),
            dto.getPhone(),
            dto.getWebSite(),
            dto.getCoverLetter(),
            dto.getTimeStamp(),
            dto.getApplicationStatus(),
            dto.getInterviewTime()
        );
    }
}
