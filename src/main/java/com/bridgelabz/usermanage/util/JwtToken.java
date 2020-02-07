package com.bridgelabz.usermanage.util;

import java.util.Date;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component	
public class JwtToken {

private static final String SECRET_KEY = "secret";

	public String createToken(String subject) {
		
		return Jwts.builder().setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.signWith(SignatureAlgorithm.HS512, SECRET_KEY).compact();
	}
	
	public String decodeToken(String token	) {
		
		return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getSubject();
	}

}
