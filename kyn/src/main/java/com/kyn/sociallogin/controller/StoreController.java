package com.kyn.sociallogin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.kyn.sociallogin.dao.Store;
import com.kyn.sociallogin.service.StoreService;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping(value = "/kyn")
public class StoreController {
	
	@Autowired
	 StoreService storeService;
	
	//View ALL Products API
			@GetMapping(value = "/dashboard")
			public List<Store> viewStore(){
				return storeService.viewStore();
			}
			
}
