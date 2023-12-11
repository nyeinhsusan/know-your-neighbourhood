package com.kyn.sociallogin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kyn.sociallogin.dao.Users;
import com.kyn.sociallogin.dao.Store;
import com.kyn.sociallogin.repository.StoreRepo;



@Service
public class StoreServiceImpl implements StoreService {

	@Autowired
	StoreRepo storeRepo;
	
	@Override
	public List<Store> viewStore() {
		// TODO Auto-generated method stub
		return storeRepo.findAll();
	}

}
