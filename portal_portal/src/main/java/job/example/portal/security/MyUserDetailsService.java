//package job.example.portal.security;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import job.example.portal.dto.UserDTO;
//import job.example.portal.service.UserService;
//
//@Service
//public class MyUserDetailsService implements UserDetailsService{
//
//	private UserService userService;
//	
//	@Autowired
//	public MyUserDetailsService(UserService userService) {
//		this.userService = userService;
//	}
//
//	@Override
//	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//	    UserDTO dto = userService.getUserByEmail(email);
//	    if (dto == null) {
//	        throw new UsernameNotFoundException("User not found with email: " + email);
//	    }
//	    return new CustomUserDetails(
//	            dto.getId(),
//	            email,
//	            dto.getPassword(),
//	            dto.getAccountType(),
//	            new ArrayList<>()  // roles/authorities should go here later
//	    );
//	}
//
//
//}



package job.example.portal.security;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import job.example.portal.dto.UserDTO;
import job.example.portal.service.UserService;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Autowired
    public MyUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserDTO dto = userService.getUserByEmail(email);
        if (dto == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }

        return new CustomUserDetails(
                dto.getId(),
                email,
                dto.getName(),
                dto.getPassword(),
                dto.getAccountType(),
                dto.getProfileId(),
                new ArrayList<>() // add roles/authorities here if needed
        );
    }
}
