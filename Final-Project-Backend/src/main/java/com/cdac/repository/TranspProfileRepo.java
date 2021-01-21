package com.cdac.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdac.dto.TranspProfile;

public interface TranspProfileRepo extends JpaRepository<TranspProfile, Integer>{
	
	//public void deleteByuserId(int userId);

}
