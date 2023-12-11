package com.kyn.sociallogin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.kyn.sociallogin.dao.AuthProvider;
import com.kyn.sociallogin.dao.Users;
import com.kyn.sociallogin.exception.BadRequestException;
import com.kyn.sociallogin.payload.AfterRegister;
import com.kyn.sociallogin.payload.Register;
import com.kyn.sociallogin.repository.UsersRepository;


@RestController
@RequestMapping(value = "/kyn")
@CrossOrigin("http://localhost:3000")
public class RegisterController {
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;                      ;
	
	//Register User for Local 
	@PostMapping(value="/register")
	public ResponseEntity<?> registerUser(@RequestBody Register register){
		//Checking duplicate email
		if(usersRepository.existsByEmail(register.getEmail())) {
			throw new BadRequestException("Duplicate Email");
		}
		
		//Create new register user
		Users users = new Users();
		users.setUserName(register.getUserName());
		users.setEmail(register.getEmail());
		users.setPassword(register.getPassword());
		users.setProvider(AuthProvider.local);
		
		//Encode Password
		users.setPassword(passwordEncoder.encode(users.getPassword()));
		
		//Save new user in the database
		Users newUser = usersRepository.save(users);
		
		java.net.URI location = ServletUriComponentsBuilder
				.fromCurrentContextPath().path("/user/me")
				.buildAndExpand(newUser.getUsersId()).toUri();
		
		//Return to RegisterResponse Payload
		return ResponseEntity.created(location)
				.body(new AfterRegister(true, "Successful Register"));
	}
	
	 
}
