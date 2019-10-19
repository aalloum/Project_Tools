package com.lucifer.sec;

import java.io.IOException;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lucifer.entities.AppUser;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	
	private AuthenticationManager authenticationManager;
	
	

	public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
		super();
		this.authenticationManager = authenticationManager;
	}

	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
		AppUser appUser=null;
		try {
			appUser=new ObjectMapper().readValue(request.getInputStream(), AppUser.class);
		} catch(Exception e ) {
			throw new RuntimeException(e);
		}
		
		System.out.println("*************");
		System.out.println("username: "+appUser.getUsername());
		System.out.println("pass:"+appUser.getPassword());
		return authenticationManager.authenticate(
			new UsernamePasswordAuthenticationToken(appUser.getUsername(), appUser.getPassword()));
	}
	
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			FilterChain chain ,Authentication authResult) 
			throws IOException, ServletException {
		
		User springUser=(User) authResult.getPrincipal();
		String jwt = Jwts.builder()
		   .setSubject(springUser.getUsername())
		   .setExpiration(new Date(System.currentTimeMillis()+SecurityConstants.EXPIRATION_TIME))
		   .signWith(SignatureAlgorithm.HS512, SecurityConstants.SECRET)
		   .claim("roles", springUser.getAuthorities())
		   .compact();
		response.addHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX+jwt);
		System.out.println("JWT : "+jwt);
		
	}
}
