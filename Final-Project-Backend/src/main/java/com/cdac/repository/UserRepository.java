package com.cdac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdac.dto.User;
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
 
	public User findByEmailIdAndPasswordAndRole(String emailId,String password,String role );
	
}
