package com.cdac.service;
import java.util.List;

import com.cdac.dto.CustomerModel;
import com.cdac.dto.TranspProfile;

public interface CustomerService {
	
	public List<CustomerModel> getShipmentlistbyUserId(int id);
	public boolean addShipmentDetails(CustomerModel details,int userId);
	public void removeUser(int id);
	public boolean updateCusShipment(CustomerModel mobj,Long id);

	

}
