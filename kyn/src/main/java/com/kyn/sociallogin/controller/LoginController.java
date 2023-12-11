package com.kyn.sociallogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kyn.sociallogin.jwtsecurity.TokenProvider;
import com.kyn.sociallogin.payload.AfterLogin;
import com.kyn.sociallogin.payload.Login;

@RestController
@RequestMapping(value = "/kyn")
@CrossOrigin("http://localhost:3000")
public class LoginController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private TokenProvider tokenProvider;
	
	@PostMapping(value = "/login")
	public ResponseEntity<?> loginUser(@RequestBody Login login){
		
		//Check Authentication
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		//If authentication is correct, provide the token
		String token =  tokenProvider.createToken(authentication);
		
		return ResponseEntity.ok(new AfterLogin(token));
	}
}
