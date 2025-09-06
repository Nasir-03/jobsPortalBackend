package job.example.portal.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class UserDTO {

	private Long id;
     @NotBlank(message = "Name is required filled")
	private String name;
     @NotBlank(message = "email is required filled")
	private String email;
     @NotBlank(message = "password is required filled")
     @Pattern(
    		  regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,15}$",
    		  message = "Password must be 8–15 characters long and include upper case, lower case, digit, and special character.")
     private String password;
	private AccountType accountType;
	private Long profileId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public AccountType getAccountType() {
		return accountType;
	}
	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}
	public UserDTO(Long id, String name, String email, String password, AccountType accountType,Long profileId) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.accountType = accountType;
		this.profileId = profileId;
	}
	
	public Long getProfileId() {
		return profileId;
	}
	public void setProfileId(Long profileId) {
		this.profileId = profileId;
	}
	public UserDTO() {
		super();
	}
	
}
