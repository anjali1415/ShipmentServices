package com.cdac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.dto.User;
import com.cdac.service.UserServiceImple;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

//@CrossOrigin(origins ="*")
//@RequestMapping("/user/v1")

public class UserController {
  @Autowired
  private UserServiceImple userServiceImple;
  
  @PostMapping(value="/adduser")
  public String insertUser(@RequestBody User usr)
  {
	  System.out.println(usr.toString());
	  userServiceImple.AddUser(usr);
	  return "success";
  }
  @PostMapping(value="/login")
  public User LoginUser(@RequestBody User usr) throws Exception
  {
	  String tempEmailId=usr.getEmailId();
	  String tempPassword=usr.getPassword();
	  String tempRole=usr.getRole();
	  
	 // System.out.println(t);
	  User userObj=null;
	  
	  if(tempEmailId != null && tempPassword != null && tempRole != null)
	  {
		 // System.out.println(tempRole);
		  userObj=userServiceImple.FindUserForLogin(tempEmailId, tempPassword, tempRole);
	  }
	  
	  if(userObj == null)
	  {
		  throw new Exception("Invalid credentilas");
	  }
	  System.out.println("**********");
	  System.out.println(userObj.toString());
	  
	   return userObj;
  }
  
  // update password 
   
  
  @PostMapping(value = "/changepass")
	public ResponseEntity<String> PassUpdate(@RequestBody User usr) {
	  System.out.println(usr.getEmailId());
	  System.out.println(usr.getPassword());
	  userServiceImple.modifyPass(usr); 
		//return "success";
	  return new ResponseEntity<>("Success",HttpStatus.OK);
	}
}
