package job.example.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import job.example.portal.dto.LoginDTO;
import job.example.portal.dto.MailResponseDTO;
import job.example.portal.dto.UserDTO;
import job.example.portal.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
@Validated
@RequestMapping("/users")
public class UserController {

	private UserService userService;
	
	@Autowired
	public UserController (UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/register")
	public ResponseEntity<UserDTO> registerUser(@Valid @RequestBody UserDTO userDTO){
		UserDTO userDTO2 = userService.registerUser(userDTO);
		return new ResponseEntity<UserDTO>(userDTO2,HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<UserDTO> loginUser(@RequestBody LoginDTO loginDTO){
		UserDTO loginDTO2 = userService.loginUser(loginDTO);
		return new ResponseEntity<UserDTO>(loginDTO2,HttpStatus.OK);
	}
	
	@PostMapping("/sendOtp/{email}")
	public ResponseEntity<MailResponseDTO> sendOtp(@PathVariable @Email(message = "Email is not valid") String email){
		MailResponseDTO responseDTO = userService.sendOtp(email);
		return new ResponseEntity<MailResponseDTO>(responseDTO,HttpStatus.CREATED);
	}
	
      @GetMapping("/verifyOtp/{email}/{otp}")
	public ResponseEntity<MailResponseDTO> verifyOtp(@PathVariable @Email(message = "Email is invalid") String email,
			@PathVariable @Pattern(regexp = "^[0-9]{6}$",message = "{otp.invalid}") String otp){
		MailResponseDTO responseDTO = userService.verifyOtp(email,otp);
		return new ResponseEntity<MailResponseDTO>(responseDTO,HttpStatus.CREATED);
	}
      
     @PostMapping("/changePass")
    public ResponseEntity<MailResponseDTO> changePass(@RequestBody LoginDTO loginDTO){
    	 MailResponseDTO mailResponseDTO = userService.changePass(loginDTO);
    	 return new ResponseEntity<MailResponseDTO>(mailResponseDTO,HttpStatus.OK);
     }
}
