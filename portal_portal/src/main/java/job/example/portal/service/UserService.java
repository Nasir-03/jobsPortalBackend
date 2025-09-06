package job.example.portal.service;

import jakarta.validation.Valid;
import job.example.portal.dto.LoginDTO;
import job.example.portal.dto.MailResponseDTO;
import job.example.portal.dto.UserDTO;

public interface UserService {

	public UserDTO registerUser(UserDTO userDTO);

	public UserDTO loginUser(LoginDTO loginDTO);
	
	public UserDTO getUserByEmail(String email);

	public MailResponseDTO sendOtp(String email);

	public MailResponseDTO verifyOtp(String email, String otp);

	public MailResponseDTO changePass(LoginDTO loginDTO);
}
