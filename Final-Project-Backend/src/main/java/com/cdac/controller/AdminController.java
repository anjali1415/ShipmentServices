package com.cdac.controller;

import java.lang.module.ResolutionException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

import com.cdac.dto.TranspProfile;
import com.cdac.dto.User;
import com.cdac.repository.UserRepository;
import com.cdac.service.AdminServiceimple;
import com.cdac.service.UserServiceImple;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class AdminController {
  
	@Autowired
	  private UserServiceImple userServiceImple;
	
	//@Autowired
	// private UserRepository userRepo;
	
	@Autowired
	private AdminServiceimple admServiceForprofile;
	
	@GetMapping(value = "user_list")
	
	public List<User> UserList(){
		
		return userServiceImple.GetUserList();
	}
	
		
    @DeleteMapping(value = "/del_user/{id}") 
	public void  UserDelete(@PathVariable int id) 
	 {
			 
		  userServiceImple.removeUser(id); 
		  System.out.println("In dell"); 
		  //return "success"; 
	}
		 
	
	/*  @DeleteMapping("/del_user/{id}") 
	  public ResponseEntity<Map<String,Boolean>> deleteUser(@PathVariable int id) 
	  
	  {
		  User usr =userRepo.findById(id)
				  .orElseThrow(() -> new ResolutionException("not found"));
				  
				  
		  userRepo.delete(usr);
	        Map<String,Boolean> response=new HashMap<>();
	         response.put("deleted",Boolean.TRUE);
	           return ResponseEntity.ok(response);
	  
	  }*/
	// Transporter profile part
    
   @GetMapping(value = "profile_list")
	
	public List<TranspProfile> profileList(){
    	
		return admServiceForprofile.GetProfileList();
    
   }
   
	// delete profile of transporter
   
   
   
   @DeleteMapping(value = "/del_profile/{profileId}") 
	public void  transpProfileDelete(@PathVariable int profileId) 
	 {
	   admServiceForprofile.removeProfile(profileId);
		 // userServiceImple.removeUser(id); 
		  System.out.println("In dell==============="); 
		  //return "success"; 
	}
}
