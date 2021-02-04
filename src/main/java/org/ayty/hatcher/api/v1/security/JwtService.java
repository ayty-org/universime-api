package org.ayty.hatcher.api.v1.security;

import java.time.Instant;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.ayty.hatcher.api.v1.user.dto.LoginDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtService {

	@Value("${security.jwt.token.secret-key}")
	private String secretKey;

	@Value("${security.jwt.token.expire-length}")
	private String expiration;
	
	
	   public String generateToken( LoginDTO user ){
			
			long expString = Long.valueOf(expiration);
	        LocalDateTime expireLength = LocalDateTime.now().plusMinutes(expString);
	        Instant instant = expireLength.atZone(ZoneId.systemDefault()).toInstant();
	        Date date = Date.from(instant);
			
	        
	        //claims admin
	        
			String token = Jwts.builder()
				.setSubject(user.getLogin())
				.signWith(SignatureAlgorithm.HS512,secretKey)
				.setExpiration(date)
				.compact();
			return token;
	    }
	   
	   private Claims getClaims( String token ) throws ExpiredJwtException {
	        return Jwts
	                 .parser()
	                 .setSigningKey(secretKey)
	                 .parseClaimsJws(token)
	                 .getBody();
	    }
	   
	   public boolean validToken( String token ){
	        try{
	            Claims claims = getClaims(token);
	            Date expirationDate= claims.getExpiration();
	            LocalDateTime date =
	            		expirationDate.toInstant()
	                            .atZone(ZoneId.systemDefault()).toLocalDateTime();
	            return !LocalDateTime.now().isAfter(date);
	        }catch (Exception e){
	            return false;
	        }
	    }
	   public String getUserLogin(String token) throws ExpiredJwtException{
	        return (String) getClaims(token).getSubject();
	    }

}
