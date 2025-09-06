package job.example.portal.mapper;

import job.example.portal.dto.UserDTO;
import job.example.portal.entity.User;

public class UserMapper {
	
//	public static User toEntity(UserDTO userDTO) {
//	    Long id = null;
//	    if (userDTO.getId() != null && !userDTO.getId().isEmpty()) {
//	        id = Long.parseLong(userDTO.getId());
//	    }
//
//	    return new User(
//	        id,
//	        userDTO.getName(),
//	        userDTO.getEmail(),
//	        userDTO.getPassword(),
//	        userDTO.getAccountType(),
//	        userDTO.getProfileId() // ✅ FIXED: include profileId
//	    );
//	}
	
	 public static User toEntity(UserDTO dto) {
	        if (dto == null) {
	            return null;
	        }
	        return new User(
	                dto.getId(),
	                dto.getName(),
	                dto.getEmail(),
	                dto.getPassword(),
	                dto.getAccountType(),
	                dto.getProfileId()
	        );
	    }


//	public static UserDTO toDto(User user) {
//	    return new UserDTO(
//	        user.getId() != null ? String.valueOf(user.getId()) : null,
//	        user.getName(),
//	        user.getEmail(),
//	        user.getPassword(),
//	        user.getAccountType(),
//	        user.getProfileId() // ✅ FIXED: include profileId
//	    );
//	}
	
	 public static UserDTO toDto(User user) {
	        if (user == null) {
	            return null;
	        }
	        return new UserDTO(
	                user.getId(),
	                user.getName(),
	                user.getEmail(),
	                user.getPassword(),
	                user.getAccountType(),
	                user.getProfileId()
	        );
	    }

}
