package org.ayty.hatcher.api.v1.security;

import java.time.Instant;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Optional;

import org.ayty.hatcher.api.v1.user.dto.LoginDTO;
import org.ayty.hatcher.api.v1.user.entity.User;
import org.ayty.hatcher.api.v1.user.jpa.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class JwtService {

	@Value("${security.jwt.token.secret-key}")
	private String secretKey;
	@Value("${security.jwt.token.expire-length}")
	private String expiration;
	
	private final UserRepository userBD;

	public String generateToken(LoginDTO user) {
		long expString = Long.valueOf(expiration);
		LocalDateTime expireLength = LocalDateTime.now().plusMinutes(expString);
		Instant instant = expireLength.atZone(ZoneId.systemDefault()).toInstant();
		Date date = Date.from(instant);
		HashMap<String, Object> claim = new HashMap<String, Object>();
		Optional<User> userAdmin = userBD.findByLogin(user.getLogin());
		claim.put("Login", user.getLogin());
		claim.put("Email", userAdmin.get().getEmail());
		claim.put("Id", userAdmin.get().getId());

		String token = Jwts.builder().setClaims(claim).signWith(SignatureAlgorithm.HS512, secretKey).setExpiration(date)
				.compact();
		return token;
	}
	private Claims getClaims(String token) throws ExpiredJwtException {
		return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
	}
	public boolean validToken(String token) {
		try {
			Claims claims = getClaims(token);
			Date expirationDate = claims.getExpiration();
			LocalDateTime date = expirationDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
			return !LocalDateTime.now().isAfter(date);
		} catch (Exception e) {
			return false;
		}
	}
	public String getUserLogin(String token) throws ExpiredJwtException {
		return (String) getClaims(token).get("Login");
	}
}
