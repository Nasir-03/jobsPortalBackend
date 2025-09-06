//package job.example.portal.service;
//
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import job.example.portal.repository.ProfileRepository;
//import job.example.portal.dto.Experience;
//import job.example.portal.dto.ProfileDTO;
//import job.example.portal.entity.Profile;
//import job.example.portal.exception.UserAlreadyExistException;
//import job.example.portal.mapper.ProfileMapper;
//import job.example.portal.utility.SequenceGeneratorService;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Base64;
//
//@Service 
//public class ProfileServiceImpl implements ProfileService {
//
//    private final SequenceGeneratorService sequenceGeneratorService;
//    private final ProfileRepository profileRepository;
//
//    public ProfileServiceImpl(SequenceGeneratorService sequenceGeneratorService, ProfileRepository profileRepository) {
//		this.sequenceGeneratorService = sequenceGeneratorService;
//		this.profileRepository = profileRepository;
//	}
//
//    @Override
//    public Long createProfile(String email) {
//        Profile profile = new Profile();
//        profile.setId(sequenceGeneratorService.generateSequence("profile_sequence"));
//        profile.setEmail(email);
//        profile.setSkills(new ArrayList<>());
//        profile.setExperiences(new ArrayList<>());
//        profile.setCertificates(new ArrayList<>());
//
//        profileRepository.save(profile);
//        return profile.getId();
//    }
//
//	@Override
//	public ProfileDTO getProfile(Long id) {
//		Profile profile = profileRepository.findById(id)
//		        .orElseThrow(() -> new UserAlreadyExistException("User not found exceptions"));
//		
//	 return ProfileMapper.toProfileDTO(profile);
//	}
//
//	public Profile updateProfile(String id, String jobTitle, String company, String location, byte[] imageData) throws IOException {
//        Profile existing = profileRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Profile not found"));
//
//        existing.setJobTitle(jobTitle);
//        existing.setCompany(company);
//        existing.setLocation(location);
//
//        if (imageData != null) {
//            existing.setImageData(imageData);
//        }
//
//        return profileRepository.save(existing);
//    }
//	    
//		profileRepository.save(profile);
//		return ProfileMapper.toProfileDTO(profile);
//	}
//
//	@Override
//	public ProfileDTO addExperience(Long id,Experience experience) {
//		Profile profile = profileRepository.findById(id)
//				.orElseThrow(()-> new UsernameNotFoundException("User is not found"));
//		
//		profile.getExperiences().add(experience);
//		profileRepository.save(profile);
//		return ProfileMapper.toProfileDTO(profile);
//	}
//}



package job.example.portal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import job.example.portal.dto.Experience;
import job.example.portal.dto.ProfileDTO;
import job.example.portal.entity.Profile;
import job.example.portal.exception.ResourceNotFoundException;
import job.example.portal.exception.UserAlreadyExistException;
import job.example.portal.mapper.ProfileMapper;
import job.example.portal.repository.ProfileRepository;
import job.example.portal.utility.SequenceGeneratorService;

@Service
public class ProfileServiceImpl implements ProfileService {

    private final SequenceGeneratorService sequenceGeneratorService;
    private final ProfileRepository profileRepository;

    public ProfileServiceImpl(SequenceGeneratorService sequenceGeneratorService,
                               ProfileRepository profileRepository) {
        this.sequenceGeneratorService = sequenceGeneratorService;
        this.profileRepository = profileRepository;
    }

    @Override
    public Long createProfile(String email) {
        Profile profile = new Profile();
        profile.setId(sequenceGeneratorService.generateSequence("profile_sequence"));
        profile.setEmail(email);
        profile.setSkills(new ArrayList<>());
        profile.setExperiences(new ArrayList<>());
        profile.setCertificates(new ArrayList<>());

        profileRepository.save(profile);
        return profile.getId();
    }

    @Override
    public ProfileDTO getProfile(Long id) {
        Profile profile = profileRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("profile not found"));
        return ProfileMapper.toProfileDTO(profile);
    }


	@Override
	public ProfileDTO addExperience(Long id,Experience experience) {
		Profile profile = profileRepository.findById(id)
				.orElseThrow(()-> new UsernameNotFoundException("User is not found"));
		
		profile.getExperiences().add(experience);
		profileRepository.save(profile);
		return ProfileMapper.toProfileDTO(profile);
	}

	@Override
	public List<ProfileDTO> getAllProfiles() {
		List<Profile> profiles = profileRepository.findAll();
		return profiles.stream()
	               .map(ProfileMapper::toProfileDTO)
	               .toList();
	}
	
}

