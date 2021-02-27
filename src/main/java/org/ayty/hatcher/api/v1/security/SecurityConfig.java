package org.ayty.hatcher.api.v1.security;
import org.ayty.hatcher.api.v1.user.service.LoadUserByUsarname;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private final JwtService jwtService;
	private final LoadUserByUsarname load;	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(load).passwordEncoder(passwordEncoder());
	}
	@Bean
	public OncePerRequestFilter jwtFilter() {
		return new JwtAuthFilter(jwtService, load);
	}
	 @Override
	    protected void configure( HttpSecurity http ) throws Exception {
	        this.permitAll(http);
	        
	    }
	 @Override
	    public void configure(WebSecurity web) throws Exception {
	        web.ignoring().antMatchers(
	                "/v2/api-docs",
	                "/configuration/ui",
	                "/swagger-resources/**",
	                "/configuration/security",
	                "/swagger-ui.html",
	                "/webjars/**");
	    }
	 private void permitAll(HttpSecurity http) throws Exception{
		 http
         .cors().and().csrf().disable()
         .authorizeRequests()
         .antMatchers("/hatcher")
				.permitAll()
         	.antMatchers(HttpMethod.POST,"/api/v1/hatcher/auth")
         		.permitAll()
         	.antMatchers(HttpMethod.PUT,"/api/v1/hatcher/update/**")
         		.permitAll()
         	.antMatchers(HttpMethod.GET,"/api/v1/hatcher/getById/**")
         		.permitAll()
         		
         		
         		
         	.antMatchers(HttpMethod.GET,"/api/v1/hatcher/projects")
         		.permitAll()
         	.antMatchers(HttpMethod.POST,"/api/v1/hatcher/projects")
         		.permitAll()
         	.antMatchers(HttpMethod.GET,"/api/v1/hatcher/projects/**")
         		.permitAll()
         	.antMatchers(HttpMethod.PUT,"/api/v1/hatcher/projects/**")
         		.permitAll()
         	.antMatchers(HttpMethod.DELETE,"/api/v1/hatcher/projects/**")
         		.permitAll()     		
         	.antMatchers(HttpMethod.GET,"/api/v1/hatcher/listUsers")
         		.permitAll()
         	.antMatchers(HttpMethod.POST,"/api/v1/hatcher/register")
         		.permitAll()
           	.antMatchers(HttpMethod.DELETE,"/api/v1/hatcher/remove/**")
         		.permitAll()
             .anyRequest().authenticated()
         .and()
             .sessionManagement()
             .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
         .and()
             .addFilterBefore( jwtFilter(), UsernamePasswordAuthenticationFilter.class);
		 
	 }
	 private void hasRole(HttpSecurity http) throws Exception{
		 http
         .cors().and().csrf().disable()
         .authorizeRequests()
         .antMatchers(HttpMethod.POST,"/hatcher")
 			.permitAll()
         	.antMatchers(HttpMethod.POST,"/api/v1/hatcher/auth")
         		.hasAnyRole("USER,ADMIN")
         	.antMatchers(HttpMethod.GET,"/api/v1/hatcher/listUsers")
         		.hasAnyRole("USER,ADMIN")
         	.antMatchers(HttpMethod.POST,"/api/v1/hatcher/register")
         		.hasAnyRole("ADMIN")
         	.antMatchers(HttpMethod.DELETE,"/api/v1/hatcher/remove/**")
         		.hasAnyRole("USER,ADMIN")
             .anyRequest().authenticated()
         .and()
             .sessionManagement()
             .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
         .and()
             .addFilterBefore( jwtFilter(), UsernamePasswordAuthenticationFilter.class);
	 }
	 private void authenticate(HttpSecurity http) throws Exception{
		 http
         .cors().and().csrf().disable()
         .authorizeRequests()
         .antMatchers(HttpMethod.POST,"/api/v1/hatcher")
 			.permitAll()
         	.antMatchers(HttpMethod.POST,"/api/v1/hatcher/auth")
         		.permitAll()
         	.antMatchers(HttpMethod.GET,"/api/v1/hatcher/listUsers")
         		.authenticated()
         	.antMatchers(HttpMethod.POST,"/api/v1/hatcher/register")
         		.authenticated()
         	.antMatchers(HttpMethod.DELETE,"/api/v1/hatcher/remove/**")
         		.authenticated()
             .anyRequest().authenticated()
         .and()
             .sessionManagement()
             .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
         .and()
             .addFilterBefore( jwtFilter(), UsernamePasswordAuthenticationFilter.class);
	 }
}