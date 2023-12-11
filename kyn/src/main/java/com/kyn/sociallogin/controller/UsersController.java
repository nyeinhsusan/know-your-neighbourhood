package com.kyn.sociallogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kyn.sociallogin.dao.Users;
import com.kyn.sociallogin.exception.ResourceNotFoundException;
import com.kyn.sociallogin.repository.UsersRepository;
import com.kyn.sociallogin.service.UsersPrincipal;

@RestController
@RequestMapping(value = "/kyn")
@CrossOrigin("http://localhost:3000")
public class UsersController {
	
	@Autowired
	private UsersRepository usersRepo;

	@GetMapping("/user/me") 
	public Users getUser(@CurrentUser UsersPrincipal usersPrincipal) {
	   return usersRepo.findById((usersPrincipal.getUsersId())) 
	                .orElseThrow(() -> new ResourceNotFoundException("Users", "userId", usersPrincipal.getUsersId()));
	}
}
