/*
 * package com.cdac.service;
 * 
 * public class CustomerServiceImple {
 * 
 * }
 */

package com.cdac.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.dto.CustomerModel;
import com.cdac.dto.TranspProfile;
import com.cdac.repository.CustomerRepo;
import com.cdac.repository.CustomerTemplateRepo;

@Service

public class CustomerServiceImple implements CustomerService {
         @Autowired
              public CustomerTemplateRepo customrepo;
         @Autowired
         public CustomerRepo crepo;
     // get shipment list
	@Override
	
	public List<CustomerModel> getShipmentlistbyUserId(int userId) {
		
//		Iterable<CustomerModel> itr = customrepo.ShipList(userId);
//		Iterator<CustomerModel> it = itr.iterator();
//		List<CustomerModel> li = new ArrayList<CustomerModel>();
//		while(it.hasNext()) {
//			System.out.println(it.next());
//			li.add(it.next()); 
//		}
//		System.out.println(li);
//		return li;
		
         return customrepo.ShipList(userId);
	
	}
	// delete shipment by shipid
	@Override
	public void removeUser(int id) {
		
		crepo.deleteById((long) id);
		
	}
	// add shpment details
	/*
	 * @Override public void addShipmentDetails(CustomerModel details) {
	 * 
	 * crepo.save(details); }
	 */
	@Override
	public boolean addShipmentDetails(CustomerModel details, int userId) {
		return customrepo.saveShipment(details, userId);
		
	}
	@Override
	public boolean updateCusShipment(CustomerModel mobj, Long id) {
		// TODO Auto-generated method stub
		 return customrepo.updateshipmentDetails(mobj, id);
	}
	

}

