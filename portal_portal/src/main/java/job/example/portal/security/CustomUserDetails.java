//package job.example.portal.security;
//
//import java.util.Collection;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import job.example.portal.dto.AccountType;
//
//public class CustomUserDetails implements UserDetails{
//
//	private Long id;
//	private String username;
//	private String password;
//	private AccountType accountType;
//	private Collection<? extends GrantedAuthority>authorities;
//	public Long getId() {
//		return id;
//	}
//	public void setId(Long id) {
//		this.id = id;
//	}
//	public String getUsername() {
//		return username;
//	}
//	public void setUsername(String username) {
//		this.username = username;
//	}
//	public String getPassword() {
//		return password;
//	}
//	public void setPassword(String password) {
//		this.password = password;
//	}
//	public AccountType getAccountType() {
//		return accountType;
//	}
//	public void setAccountType(AccountType accountType) {
//		this.accountType = accountType;
//	}
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		return authorities;
//	}
//	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
//		this.authorities = authorities;
//	}
//	public CustomUserDetails() {
//		super();
//	}
//	public CustomUserDetails(Long id, String username, String password, AccountType accountType,
//			Collection<? extends GrantedAuthority> authorities) {
//		this.id = id;
//		this.username = username;
//		this.password = password;
//		this.accountType = accountType;
//		this.authorities = authorities;
//	}
//	
//		
//}




package job.example.portal.security;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import job.example.portal.dto.AccountType;

public class CustomUserDetails implements UserDetails {

    private Long id;
    private String username;
    private String name;
    private String password;
    private AccountType accountType;
    private Long profileId;
    private Collection<? extends GrantedAuthority> authorities;

    public CustomUserDetails(Long id, String username,String name, String password,
                             AccountType accountType,Long profileId,
                             Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.password = password;
        this.accountType = accountType;
        this.profileId = profileId;
        this.authorities = authorities;
    }

    public Long getProfileId() {
		return profileId;
	}



	public void setProfileId(Long profileId) {
		this.profileId = profileId;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public Long getId() {
        return id;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities == null ? Collections.emptyList() : authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    // 🔑 Required overrides for Spring Security
    @Override
    public boolean isAccountNonExpired() {
        return true; // change if you track account expiry
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // change if you track account locks
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // change if you track password expiry
    }

    @Override
    public boolean isEnabled() {
        return true; // change if you track active/inactive users
    }
}
