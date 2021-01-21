package com.cdac.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name = "Tprofile")

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "profileId")
public class TranspProfile {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="profile_id") 
  private int profileId;
  
  @Column(name="insurance_No",unique = true)
  private String insuranceNo;
  
  @Column(name="vehicle_No")
  private String vehicleNo;
 
  @Column(name = "licence_No",unique = true)
  private String licenceNo;
  
  @Column(name="adhar_No",unique = true,length = 12)
  private String adharNo;
  
  
  @OneToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name="user_id")
  private User user;
  
  public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public String getLicenceNo() {
	return licenceNo;
}
public void setLicenceNo(String licenceNo) {
	this.licenceNo = licenceNo;
}

  
public int getProfileId() {
	return profileId;
}
public void setProfileId(int profileId) {
	this.profileId = profileId;
}
public String getInsuranceNo() {
	return insuranceNo;
}
public void setInsuranceNo(String insuranceNo) {
	this.insuranceNo = insuranceNo;
}
public String getVehicleNo() {
	return vehicleNo;
}
public void setVehicleNo(String vehicleNo) {
	this.vehicleNo = vehicleNo;
}
public String getAdharNo() {
	return adharNo;
}
public void setAdharNo(String adharNo) {
	this.adharNo = adharNo;
}


@Override
public String toString() {
	
	return "TranspProfile [profileId=" + profileId + ", insuranceNo=" + insuranceNo + ", vehicleNo=" + vehicleNo
			+ ", adharNo=" + adharNo + ", userid="  + "]";
}

  
  
  
  
  
  
  
}
