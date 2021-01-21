package com.cdac.service;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.dto.TranspProfile;
import com.cdac.dto.User;
import com.cdac.repository.TransporterRepoImple;
import com.cdac.repository.UserRepository;
import com.cdac.repository.userTemplateRepo;
@Service
public class UserServiceImple implements UserService{

	@Autowired
	private UserRepository userRepository;
	@Autowired
	public userTemplateRepo usrTemplateRepo;
	
	@Override
	public void AddUser(User usr) {
		
		userRepository.save(usr);
		
	}

	@Override
	public User FindUserForLogin(String emailId, String password, String role) {
		
	    return userRepository.findByEmailIdAndPasswordAndRole(emailId, password, role);
	}

	@Override
	public List<User> GetUserList() {
		Iterable<User> itr = userRepository.findAll();
		Iterator<User> it = itr.iterator();
		List<User> li = new ArrayList<User>();
		while(it.hasNext()) {
			li.add(it.next()); 
		}
		return li;
		
	}

	
	@Override
	public void modifyPass(User usr) {
		
		usrTemplateRepo.updatePassword(usr);
		//userRepository.updatePassword(usr);
		
	}
	
	
      @Autowired
      TransporterRepoImple transRepoImple;
      
	@Override
	public void removeUser(int id) {
      //transRepoImple.deleteTransporterByAdmin(id);
		 userRepository.deleteById(id);
		
	}



	

}
