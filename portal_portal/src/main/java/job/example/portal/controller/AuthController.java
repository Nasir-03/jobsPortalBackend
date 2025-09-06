package job.example.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import job.example.portal.security.AuthUtill;
import job.example.portal.security.AuthenticationRequest;
import job.example.portal.security.AuthenticationResponse;

@RestController
@RequestMapping("/auth")
public class AuthController {

	private UserDetailsService userDetailsService;
	private AuthUtill authUtill;
	private AuthenticationManager authenticationManager;
	
	@Autowired
	public AuthController(UserDetailsService userDetailsService, AuthUtill authUtill,
			AuthenticationManager authenticationManager) {
		this.userDetailsService = userDetailsService;
		this.authUtill = authUtill;
		this.authenticationManager = authenticationManager;
	}
	
	@PostMapping("/login")
	public ResponseEntity<AuthenticationResponse> createAuthenticationToken(@RequestBody AuthenticationRequest request){
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
	
	  final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
	  final String jwt = authUtill.generateToken(userDetails);
	  
	  return new ResponseEntity<>(new AuthenticationResponse(jwt), HttpStatus.OK);
	}

	
}
