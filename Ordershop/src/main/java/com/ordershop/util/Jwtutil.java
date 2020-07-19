package com.ordershop.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@Component
public class Jwtutil {
	
	private String SECRET_KEY = "SECRET";
	private String USERNAME = "a0c0wk";
	
	/*
	 * public String genrateToken(String username) { Map<String,Object> claims = new
	 * HashMap<>(); return createToken(claims,username); }
	 * 
	 * private String createToken(Map<String, Object> claims, String username) { //
	 * TODO Auto-generated method stub return
	 * Jwts.builder().setClaims(claims).setSubject(username) .setIssuedAt(new
	 * Date(System.currentTimeMillis())) .setExpiration(new
	 * Date(System.currentTimeMillis()+1000*60*60))
	 * .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact(); }
	 */
	
	public boolean validateToken(String jwt)
	{		
		String jwtuser = extractUserName(jwt);
		return (USERNAME.equalsIgnoreCase(jwtuser) && ! isTokenExpired(jwt));
	}

	private String extractUserName(String jwt) {
		return extractClaim(jwt,Claims::getSubject);
	}
	
	private boolean isTokenExpired(String jwt){		
		return extractClaim(jwt,Claims::getExpiration).before(new Date());
	}

	private <R> R extractClaim(String jwt, Function<Claims, R> function) {
		Claims claims = extractAllClaim(jwt);		
		return function.apply(claims);
	}

	private Claims extractAllClaim(String jwt) {
		// TODO Auto-generated method stub
		return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(jwt).getBody();
	}

}
