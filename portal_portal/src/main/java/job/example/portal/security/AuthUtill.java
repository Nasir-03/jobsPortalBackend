package job.example.portal.security;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class AuthUtill {
	
	@Value("${jwt.secretKey}")
	private String jwtSecretKey;
	
	private SecretKey getSecretKey() {
		return Keys.hmacShaKeyFor(jwtSecretKey.getBytes(StandardCharsets.UTF_8));
	}
	
//	1. generate Token
	
	public String generateToken(UserDetails userDetails) {
		CustomUserDetails customUser = (CustomUserDetails)userDetails;
	    Map<String, Object> claims = new HashMap<>();
	    
	    claims.put("id", customUser.getId());
	    claims.put("name", customUser.getName());
	    claims.put("accountType", customUser.getAccountType());
	    claims.put("profileId", customUser.getProfileId());
	    
		return Jwts.builder()
	            .subject(userDetails.getUsername())  
	            .claims(claims)
	            .issuedAt(new Date())                        // ✅ new style
	            .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // ✅ new style
	            .signWith(getSecretKey())
	            .compact();
	}

//	2. Extract allcalims
	
	private Claims extractAllClaims(String token) {
		 return Jwts.parser()
	                .verifyWith(getSecretKey())
	                .build()
	                .parseSignedClaims(token)
	                .getPayload();
	}
	

//  3. Extract UserName
  
  public String getUserNameFromToken(String token) {
  	return extractAllClaims(token).getSubject();
  }

//  4. Extract userId
  
  public String getUserIdFromToken(String token) {
  	return extractAllClaims(token).get("userid",String.class);
  }
  
//  5. check token expired
  
  private Boolean isTokenExpired(String token) {
  	Date expiration = extractAllClaims(token).getExpiration();
  	return expiration.before(new Date());
  }
  
//  6. Validate token
  
  public boolean validateToken(String token,String username) {
  	final String usernames = getUserNameFromToken(token);
      return (usernames.equals(username) && !isTokenExpired(token));
  }



}
