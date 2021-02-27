package org.ayty.hatcher.api.v1.security;

import java.io.IOException;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.ayty.hatcher.api.v1.user.service.LoadUserByUsarname;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {

	private final JwtService jwtService;
	
	private final LoadUserByUsarname load;
	
	@Override
	protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,FilterChain filterChain) throws ServletException, IOException {

		String authorization = httpServletRequest.getHeader("Authorization");
		if (authorization != null && authorization.startsWith("Bearer")) {
			String token = authorization.split(" ")[1];

			boolean isValid = jwtService.validToken(token);
			if (isValid) {
				String userLogin = jwtService.getUserLogin(token);
				
				UserDetails userDetails = load.loadUserByUsername(userLogin);
				UsernamePasswordAuthenticationToken user = new UsernamePasswordAuthenticationToken(userDetails, null,
						userDetails.getAuthorities());
				user.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
				SecurityContextHolder.getContext().setAuthentication(user);
			}
		}
		filterChain.doFilter(httpServletRequest, httpServletResponse);
	}
}