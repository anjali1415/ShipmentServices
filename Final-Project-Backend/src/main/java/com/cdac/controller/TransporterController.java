package com.cdac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.dto.TranspProfile;
import com.cdac.service.TransporterServiceimple;

@RestController
@CrossOrigin(origins = "*")
public class TransporterController {
   
	
	@Autowired
    
	public TransporterServiceimple trsimple;
	
	//simple way
	/* @PostMapping(value = "/add_transp_prof/{usrId}")
	 public String addTranspProfile(@RequestBody TranspProfile,@PathVariable int usrId)
	 {
		 trsimple.addTranspProfileNew(tprof);
		 return "success";
	 }*/
	
	@PostMapping(value = "/add_transp_prof/{userId}")
	public String addTransporterProfilr(@RequestBody TranspProfile trapro , @PathVariable int userId)
	{
		System.out.println("==========" + userId);
		trsimple.addTranspProfile(trapro,userId);
		return "success";
	}
}
