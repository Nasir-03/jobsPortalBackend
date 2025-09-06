package job.example.portal.mapper;

import job.example.portal.dto.ProfileDTO;
import job.example.portal.entity.Profile;

public class ProfileMapper {

    public static Profile toProfileEntity(ProfileDTO profileDTO) {
        Profile profile = new Profile(
                profileDTO.getId(),
                profileDTO.getName(),
                profileDTO.getJobTitle(),
                profileDTO.getCompany(),
                profileDTO.getLocation(),
                profileDTO.getAbout(),
                profileDTO.getImageData(),
                profileDTO.getTotalExp(),
                profileDTO.getEmail(),
                profileDTO.getSkills(),
                profileDTO.getExperiences(),
                profileDTO.getCertificates(),
                profileDTO.getSavedJobs()
        );
        return profile;
    }
    
    public static ProfileDTO toProfileDTO(Profile profile) {
        ProfileDTO pDto = new ProfileDTO(
                profile.getId(),
                profile.getName(),
                profile.getJobTitle(),
                profile.getCompany(),
                profile.getLocation(),
                profile.getAbout(),
                profile.getImageData(),
                profile.getTotalExp(),
                profile.getEmail(),
                profile.getSkills(),
                profile.getExperiences(),
                profile.getCertificates(),
                profile.getSavedJobs()
        );
        return pDto;
    }
}
