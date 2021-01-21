package com.cdac.dto;

import java.util.List;

//import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name="User")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "userId")

public class User {
	 @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="user_id", nullable = false)
	private int userId;
	@Column(name="user_name")
	private String userName;
	@Column(name="first_name")
	private String firstName;
	@Column (name="last_name")
	private String lastName;
	@Column (name="mobile_no")
	private String mobileNo;
	
	@Column (name="email_id")
	private String emailId;
	@Column (name="password")
	private String password;
	@Column(name = "role")
	private String role;
	
	@OneToOne(mappedBy = "user", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
	@JoinColumn(name="profile_id")
	  private TranspProfile transprof;
	  
	//customer
	
	@OneToMany( mappedBy = "user",cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
           )
	
    private List<CustomerModel> customer;
	
	 // private User user;
	
	public List<CustomerModel> getCustomer() {
		return customer;
	}
	public void setCustomer(List<CustomerModel> customer) {
		this.customer = customer;
	}
	
	public TranspProfile getTransprof() {
		return transprof;
	}
	public void setTransprof(TranspProfile transprof) {
		this.transprof = transprof;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", firstName=" + firstName + ", lastName="
				+ lastName + ", mobileNo=" + mobileNo + ", emailId=" + emailId + ", password=" + password + ", role="
				+ role + "]";
	}
	
	
	
	

}
