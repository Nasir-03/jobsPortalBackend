package job.example.portal.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import job.example.portal.dto.Certification;
import job.example.portal.dto.Experience;
import job.example.portal.dto.ProfileDTO;
import job.example.portal.entity.Profile;
import job.example.portal.repository.ProfileRepository;
import job.example.portal.service.ProfileService;




import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.MediaType;
@RestController
@Validated
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/profile")
public class ProfileController {

	private ProfileService profileService;
	@Autowired
	private ProfileRepository profileRepository;
	
	@Autowired
	public ProfileController(ProfileService profileService) {
		this.profileService = profileService;
	}

     @GetMapping("/getPro/{id}")
	public ResponseEntity<ProfileDTO> getProfile(@PathVariable Long id){
		ProfileDTO dto = profileService.getProfile(id);
		return new ResponseEntity<ProfileDTO>(dto,HttpStatus.OK);
	}
      
    
     @PutMapping(value = "/update/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
     public ResponseEntity<Profile> updateProfile(
             @PathVariable("id") Long id,
             @RequestParam(required = false) String jobTitle,
             @RequestParam(required = false) String company,
             @RequestParam(required = false) String location,
             @RequestParam(required = false) String about,
             @RequestPart(required = false) MultipartFile image,
             @RequestParam(required = false) List<String> skills,
             @RequestPart(required = false) List<Experience> experiences,
             @RequestParam(required = false)List<Long> savedJobs
     ) throws IOException {

         Profile profile = profileRepository.findById(id)
                 .orElseThrow(() -> new RuntimeException("Profile not found for id: " + id));

         if (jobTitle != null) profile.setJobTitle(jobTitle);
         if (company != null) profile.setCompany(company);
         if (location != null) profile.setLocation(location);
         if (about != null) profile.setAbout(about);
         if (skills != null) profile.setSkills(skills);
         if (experiences != null) profile.setExperiences(experiences);
         if (savedJobs != null) profile.setSavedJobs(savedJobs);
         if (image != null && !image.isEmpty()) {
             profile.setImageData(image.getBytes());
         }

         Profile updated = profileRepository.save(profile);
         return ResponseEntity.ok(updated);
     }
     
     @GetMapping("/getAll")
     public ResponseEntity<List<ProfileDTO>> getAll(){
    	 List<ProfileDTO> lst = profileService.getAllProfiles();
    	 return new ResponseEntity<List<ProfileDTO>>(lst,HttpStatus.OK);
     }
     
     @PostMapping("/addExp/{id}")
     public ResponseEntity<ProfileDTO> addExperience(@PathVariable Long id,@RequestBody Experience experience){
    	 ProfileDTO dto = profileService.addExperience(id, experience);
    	 return new ResponseEntity<ProfileDTO>(dto,HttpStatus.OK);
     }
}
