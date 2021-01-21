package com.cdac.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.dto.TranspProfile;
import com.cdac.repository.TranspProfileRepo;
import com.cdac.repository.UserRepository;
@Service
public class AdminServiceimple implements AdminService {
	
    @Autowired
    
    public TranspProfileRepo transpprofileRepo;
    
    @Autowired
    public  UserRepository urepo;
	
	@Override
	public List<TranspProfile> GetProfileList() {
		Iterable<TranspProfile> itr = transpprofileRepo.findAll();
		Iterator<TranspProfile> it = itr.iterator();
		List<TranspProfile> li = new ArrayList<TranspProfile>();
		while(it.hasNext()) {
			li.add(it.next()); 
		}
		return li;
		
	}

	@Override
	public void removeProfile(int id) {
		
		urepo.deleteById(id);
		//transpprofileRepo.deleteById(id);
		//transpprofileRepo.deleteByuserId(id);
		
		
	}

}
