package job.example.portal.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;
import jakarta.validation.Valid;
import job.example.portal.dto.LoginDTO;
import job.example.portal.dto.MailResponseDTO;
import job.example.portal.dto.NotificationDTO;
import job.example.portal.dto.UserDTO;
import job.example.portal.entity.Otp;
import job.example.portal.entity.User;
import job.example.portal.exception.UserAlreadyExistException;
import job.example.portal.exception.UserNotRegisterException;
import job.example.portal.mapper.UserMapper;
import job.example.portal.repository.OtpRepository;
import job.example.portal.repository.UserRepository;
import job.example.portal.utility.Data;
import job.example.portal.utility.SequenceGeneratorService;

@Service
@EnableScheduling
public class UserServiceImpl implements UserService{

	private UserRepository userRepository;
	private SequenceGeneratorService sequenceGeneratorService;
	private PasswordEncoder passwordEncoder;
	private JavaMailSender javaMailSender;
	private OtpRepository otpRepository;
	private ProfileService profileService;
	private NotificationService notificationService;
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository,
	                       SequenceGeneratorService sequenceGeneratorService,
	                       PasswordEncoder passwordEncoder,
	                       JavaMailSender javaMailSender,
	                       OtpRepository otpRepository,
	                       ProfileService profileService,
	                       NotificationService notificationService) {
	    this.userRepository = userRepository;
	    this.sequenceGeneratorService = sequenceGeneratorService;
	    this.passwordEncoder = passwordEncoder;
	    this.javaMailSender = javaMailSender;
	    this.otpRepository = otpRepository;
	    this.profileService = profileService;
	    this.notificationService = notificationService;
	}

	
	@Override
	public UserDTO registerUser(UserDTO userDTO){
		 if (userRepository.existsByEmail(userDTO.getEmail())) {
		        throw new UserAlreadyExistException("User Already exist");
		    }
		 userDTO.setProfileId(profileService.createProfile(userDTO.getEmail()));
		 userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
		 User user = UserMapper.toEntity(userDTO);
		 user.setId(sequenceGeneratorService.generateSequence("user_sequence"));
		 userRepository.save(user);
		 return UserMapper.toDto(user);
	}

	@Override
	public UserDTO loginUser(LoginDTO loginDTO) {
		if (!userRepository.existsByEmail(loginDTO.getEmail())) {
			throw new UserNotRegisterException("user not register");
		}
		User user = userRepository.findByEmail(loginDTO.getEmail());
		
		if (!passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())) {
			throw new UserAlreadyExistException("Password not metched");
		}
         return UserMapper.toDto(user);
	}

	@Override
	public MailResponseDTO sendOtp(String email) {
		try {
			User user = userRepository.findByEmail(email);
			if (user == null) {
				throw new UserNotRegisterException("you have not account from this email");
			}
			MimeMessage mm = javaMailSender.createMimeMessage();
			MimeMessageHelper message = new MimeMessageHelper(mm,true);
		    
			message.setTo(email);
			message.setSubject("Your Otp Code");
//			SequenceGeneratorService this class
//			made in utility package
			
			String genOtp = SequenceGeneratorService.generateOtp();
			Otp otp = new Otp(email,genOtp,LocalDateTime.now());
			otpRepository.save(otp);
			
			message.setText(Data.getMessage(genOtp),true);
			javaMailSender.send(mm);
			return new MailResponseDTO("Otp sent successfully");
		
		}catch(Exception e) {
			 throw new RuntimeException("Failed to send email: " + e.getMessage());
		}
	}

	@Override
	public MailResponseDTO verifyOtp(String email, String otp) {
		Otp otpEntity = otpRepository.findById(email).orElseThrow(()->
		new UserNotRegisterException("user is not registerd"));
		
		if (!otpEntity.getOtpCode().equals(otp)) {
			throw new UserAlreadyExistException("incorrect otp");
		}
		return new MailResponseDTO("otp matched");
	}

	@Override
	public MailResponseDTO changePass(@Valid LoginDTO loginDTO) {
	    if (loginDTO.getEmail() == null || loginDTO.getPassword() == null) {
	        throw new IllegalArgumentException("Email and password must not be null");
	    }

	    if (!userRepository.existsByEmail(loginDTO.getEmail())) {
	        throw new UserNotRegisterException("User not registered");
	    }
	    
	    User user = userRepository.findByEmail(loginDTO.getEmail());

	    System.out.println("Fetched user ID = " + user.getId()); // ✅ Add this log

	    user.setPassword(passwordEncoder.encode(loginDTO.getPassword()));
	    userRepository.save(user);
	    
	    NotificationDTO noti = new NotificationDTO();
	    noti.setId(user.getId());
	    noti.setMessage("password reset successfully");
	    noti.setAction("password reset");
        notificationService.sendNotification(noti);
	    return new MailResponseDTO("Password changed successfully");
	}

	@Scheduled(fixedRate = 600000)
	public void removeExpiredOTPs() {
	    LocalDateTime expiry = LocalDateTime.now().minusMinutes(5);
	    List<Otp> expiredOtps = otpRepository.findByCreationTimeBefore(expiry);
	    if (!expiredOtps.isEmpty()) {
	        otpRepository.deleteAll(expiredOtps);
	        System.out.println("Removed " + expiredOtps.size() + " expired OTPs");
	    }
	}

	@Override
	public UserDTO getUserByEmail(String email) {
	    User user = userRepository.findByEmail(email);
	    if (user == null) {
	        throw new UsernameNotFoundException("User not found with email: " + email);
	    }
	    return UserMapper.toDto(user);
	}

}
