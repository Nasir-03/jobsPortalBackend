package job.example.portal.security;

public class AuthenticationResponse {

	private String jwt;

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

	public AuthenticationResponse() {
		super();
	}

	public AuthenticationResponse(String jwt) {
		this.jwt = jwt;
	}
	
}
