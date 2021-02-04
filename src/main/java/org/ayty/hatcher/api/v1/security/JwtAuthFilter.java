package org.ayty.hatcher.api.v1.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ayty.hatcher.api.v1.user.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;



public class JwtAuthFilter extends OncePerRequestFilter {

	
	
	@Autowired
	private JwtService jwtService;

	@Autowired
	private UserServiceImpl userService;
	
	 public JwtAuthFilter( JwtService jwtService, UserServiceImpl userService ) {
	        this.jwtService = jwtService;
	        this.userService= userService;
	    }
	
	   @Override
	    protected void doFilterInternal(
	            HttpServletRequest httpServletRequest,
	            HttpServletResponse httpServletResponse,
	            FilterChain filterChain) throws ServletException, IOException {

	        String authorization = httpServletRequest.getHeader("Authorization");

	        if( authorization != null && authorization.startsWith("Bearer")){
	            String token = authorization.split(" ")[1];
	            boolean isValid = jwtService.validToken(token);

	            if(isValid){
	                String userLogin = jwtService.getUserLogin(token);
	                UserDetails userDetails = userService.loadUserByUsername(userLogin);
	                UsernamePasswordAuthenticationToken user = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
	                user.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
	                SecurityContextHolder.getContext().setAuthentication(user);
	            }
	        }

	        filterChain.doFilter(httpServletRequest, httpServletResponse);

	    }

	/*

@Value("${security.jwt.token.secret-key}")
	private String secretKey;

	@Value("${security.jwt.token.expire-length}")
	private String expiration;
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;

		String header = req.getHeader("Authorization");

		if (header == null || !header.startsWith("Beare ")) {
			throw new ServletException("missing or invalid token");
		}
		String token = header.substring(7);
		try {
			Jwts.parser().setSigningKey(this.secretKey).parseClaimsJws(token).getBody();
		} catch (SignatureException e) {
			throw new ServletException("Token Inválido");
		}
		chain.doFilter(request, response);
	}
*/
}