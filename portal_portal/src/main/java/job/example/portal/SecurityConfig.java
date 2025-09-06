package job.example.portal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import job.example.portal.security.AuthFilter;
import job.example.portal.security.jwtAuthenticationEntryPoint;


@Configuration
public class SecurityConfig {

    private final jwtAuthenticationEntryPoint entryPoint;
    private final AuthFilter authFilter;

    @Autowired
    public SecurityConfig(jwtAuthenticationEntryPoint entryPoint, AuthFilter authFilter) {
        this.entryPoint = entryPoint;
        this.authFilter = authFilter;
    }
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
        .cors(cors -> {})  
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                		"/auth/login",
                        "/users/login",          // added login endpoint here
                        "/users/register",
                        "/users/verifyOtp/**",
                        "/users/sendOtp/**"
                ).permitAll()
                .anyRequest().authenticated()
            )
            .exceptionHandling(ex -> ex.authenticationEntryPoint(entryPoint))
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http.addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

}
