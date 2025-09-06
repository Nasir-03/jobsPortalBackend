package job.example.portal.service;

import java.io.IOException;
import java.util.List;

import job.example.portal.dto.Experience;
import job.example.portal.dto.ProfileDTO;
import job.example.portal.entity.Profile;

public interface ProfileService {
	
	   Long createProfile(String email);
	   
	    ProfileDTO getProfile(Long id);
	    
//	    ProfileDTO updateProfile(Long id, ProfileDTO profileDTO) throws IOException;
	    
	    ProfileDTO addExperience(Long id, Experience experience);

		List<ProfileDTO> getAllProfiles();
}
