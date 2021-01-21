package com.cdac.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cdac.dto.TranspProfile;


public interface AdminService {
	
	public List<TranspProfile> GetProfileList();
	public void removeProfile(int id);
}
