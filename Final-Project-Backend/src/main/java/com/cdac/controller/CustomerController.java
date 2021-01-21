package com.cdac.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cdac.dto.CustomerModel;
import com.cdac.dto.TranspProfile;
import com.cdac.dto.User;
import com.cdac.repository.CustomerRepo;
import com.cdac.service.CustomerServiceImple;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class CustomerController <Customer>{

	@Autowired
    public CustomerRepo customerrepo;
    @Autowired
   // public CustomerServiceImple custservimple;
    
	public CustomerServiceImple cusimple;
    
  //add shipment details by customer wrong
	//@PostMapping("/Customers")
    // public String insertAllCustomer(@RequestBody CustomerModel cr) {
		//cusimple.addShipmentDetails(cr);
			
			// return "added";
		//}
		
  //
	@PostMapping(value = "/add_shipment_details/{userId}")
	public boolean addTransporterProfilr(@RequestBody CustomerModel shipdetail , @PathVariable int userId)
	{
		System.out.println("==========" + userId);
		 return cusimple.addShipmentDetails(shipdetail, userId);
		
		//return "success";
	}

	//to get all customer
	@GetMapping("/Customers_shid/{id}")
public Optional<CustomerModel> getAllCustomers1(@PathVariable Long id){
	return customerrepo.findById(id);	
	}
	//Customers/{id}
	
//19-01 tushar
	// get shipment details
	@GetMapping("/Customers/{id}")
	public List<CustomerModel> getAllCustomers(@PathVariable int id){
		System.out.println(id+"============");
		return  cusimple.getShipmentlistbyUserId(id);
		
		
		}
	


	 
	
	
	//Update shipment
//	@PutMapping(value = "/Customer_update/{id}")
//	public Boolean updateCustomer(@RequestBody CustomerModel customerDetails,@PathVariable long id ){
//		
//		System.out.println(customerDetails);
//			System.out.println("+++");
//		return cusimple.updateCusShipment(customerDetails, id);
//		
//		//System.out.println(customerDetails.toString());
//		//return "Success";
//		}
	
	// try update
	
	@PutMapping(value = "/Customer_update/{id}")
	public boolean shipUpdate(@RequestBody CustomerModel customerDetails,@PathVariable Long id) {
	 
		 return cusimple.updateCusShipment(customerDetails, id);
	 // return new ResponseEntity<>("Success",HttpStatus.OK);
	}

  //delete customer
	
	
	@DeleteMapping(value ="/Customers/{id}") 
	public void  UserDelete(@PathVariable int  id) 
	 {
			 
		cusimple.removeUser(id);
		  System.out.println("In dell"); 
		  //return "success"; 
	}

	
}
