package com.cdac.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.dto.TranspProfile;
import com.cdac.repository.TransporterRepoImple;


@Service
public class TransporterServiceimple implements TransporterService{

	
	
	@Autowired
	 public TransporterRepoImple transImple;
	
	 //leena way
	@Override
	public void addTranspProfile(TranspProfile prop, int userId) {
		
		
		transImple.saveProfile(prop, userId);
		
		//trarepo.saveProfile(prop,usr_id);
		
	}
	
	
	

}
