package org.ayty.hatcher.api.v1.security;

import org.ayty.hatcher.api.v1.user.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.filter.OncePerRequestFilter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserServiceImpl userService;

	@Autowired
	private JwtService jwtService;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(passwordEncoder());

	}

	@Bean
	public OncePerRequestFilter jwtFilter() {
		return new JwtAuthFilter(jwtService, userService);
	}

	 @Override
	    protected void configure( HttpSecurity http ) throws Exception {
	        http
	            .cors().and().csrf().disable()
	            .authorizeRequests()
	                .antMatchers("/hatcher/profile/registerUser")
	                    .hasAnyRole("ADMIN")
	                 .antMatchers("/hatcher/profile")
	                 	.hasAnyRole("/USER,ADMIN")
	                .antMatchers("/hatcher/profile/user/registerCourse")
	                    .hasAnyRole("ADMIN")
	                .antMatchers("/hatcher/profile/user/course/remove")
	                	.hasAnyRole("ADMIN")
	                .antMatchers("/hatcher/profile/user/course/edit")
	                	.hasAnyRole("ADMIN")
	                .antMatchers(HttpMethod.POST, "/api/usuarios/**")
	                    .permitAll()
	                .anyRequest().authenticated()
	            .and()
	                .sessionManagement()
	                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	            .and()
	                .addFilterBefore( jwtFilter(), UsernamePasswordAuthenticationFilter.class);
	        ;
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
	    @Bean
	    public CorsFilter corsFilter() {
	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	        CorsConfiguration config = new CorsConfiguration();
	        config.setAllowCredentials(true);
	        config.addAllowedOrigin("*");
	        config.addAllowedHeader("*");
	        config.addAllowedMethod(HttpMethod.GET);
	        config.addAllowedMethod(HttpMethod.POST);
	        config.addAllowedMethod(HttpMethod.PUT);
	        config.addAllowedMethod(HttpMethod.DELETE);
	        config.addAllowedMethod(HttpMethod.OPTIONS);
	        source.registerCorsConfiguration("/**", config);
	        return new CorsFilter(source);
	    }

}