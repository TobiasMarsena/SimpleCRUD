package simpleCRUD.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import simpleCRUD.entity.Users;
import simpleCRUD.repository.UsersRepository;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UsersRepository usersRepository;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers(
						"/",
						"/api/**",
						"/css/**",
						"/js/**",
						"/img/**").permitAll()
				.antMatchers(
						"/home/**",
						"/student/**").hasRole("USER")
				.anyRequest().authenticated()
			.and()
			.formLogin()
				.loginPage("/login")
				.permitAll()
			.and()
			.logout()
				.invalidateHttpSession(true)
				.clearAuthentication(true)
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/login?logout")
				.permitAll()
			.and()
			.exceptionHandling()
				.accessDeniedPage("/access-denied")
			.and()
			.csrf().disable();
	}

	
	  @Autowired 
	  protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception { 
		  auth.authenticationProvider(new CustomAuthenticationProvider());
		  }
	 
	  
	  @Component
	  public class CustomAuthenticationProvider implements AuthenticationProvider {
	   
	      @Override
	      public Authentication authenticate(Authentication authentication) 
	        throws AuthenticationException {
	    
	          String name = authentication.getName();
	          String password = authentication.getCredentials().toString();
	          Iterable<Users> users = usersRepository.findAll();
	          for (Users user : users) {
	        	  if (name.equals(user.getUsername()) && password.equals(user.getPassword())) {
	    	          List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
	    	          grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
	                  return new UsernamePasswordAuthenticationToken(
	    	                name, password,grantedAuths);
	        	  }
	          } 
	          return null;
	    
	      }
	   
	      @Override
	      public boolean supports(Class<?> authentication) {
	          return authentication.equals(UsernamePasswordAuthenticationToken.class);
	      }
	  }
}
