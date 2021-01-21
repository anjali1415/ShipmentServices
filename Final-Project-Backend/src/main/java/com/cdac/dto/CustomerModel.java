package com.cdac.dto;

import javax.persistence.CascadeType;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;


@Entity
//@JsonDeserialize(as = User.class)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
@Table(name = "Customer")
	public class CustomerModel {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id=(long) 0;
	@Column (name = "item_name")
	private String itemname;
	
	@Column (name = "item_weight")
	private float weightofitem;
	
	@Column (name = "item_size")
	private int sozeofitem;
	
	@Column (name = "pickupadd")
	private String pickupadd;
	
	@Column (name = "pickupcity")
	private String pickupcity;
	
	@Column (name = "deladd")
	private String deladd;
	
	@Column (name = "delcity")
	private String delcity;
	
	@Column (name = "ship_date")
	private String shipdate;
		
	@Column (name= "item_fare")
	private float fare;
	
	@ManyToOne(fetch = FetchType.LAZY)
	  @JoinColumn(name="user_id",referencedColumnName = "user_id")
	  private User user;///========

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user= user;
	}
	/*public User getUsercus() {
		return user;
	}

	public void setUsercus(User usercus) {
		this.user = usercus;
	}*/


	
	
	public CustomerModel() {
		
	}
	
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public float getWeightofitem() {
		return weightofitem;
	}
	public void setWeightofitem(float weightofitem) {
		this.weightofitem = weightofitem;
	}
	public int getSozeofitem() {
		return sozeofitem;
	}
	public void setSozeofitem(int sozeofitem) {
		this.sozeofitem = sozeofitem;
	}
	public String getPickupadd() {
		return pickupadd;
	}
	public void setPickupadd(String pickupadd) {
		this.pickupadd = pickupadd;
	}
	public String getPickupcity() {
		return pickupcity;
	}
	public void setPickupcity(String pickupcity) {
		this.pickupcity = pickupcity;
	}
	public String getDeladd() {
		return deladd;
	}
	public void setDeladd(String deladd) {
		this.deladd = deladd;
	}
	public String getDelcity() {
		return delcity;
	}
	public void setDelcity(String delcity) {
		this.delcity = delcity;
	}
	public String getShipdate() {
		return shipdate;
	}
	public void setShipdate(String shipdate) {
		this.shipdate = shipdate;
	}
	public float getFare() {
		return fare;
	}
	public void setFare(float fare) {
		this.fare = fare;
	}


	@Override
	public String toString() {
		return "customer [id=" + id + ", itemname=" + itemname + ", weightofitem=" + weightofitem + ", sozeofitem="
				+ sozeofitem + ", pickupadd=" + pickupadd + ", pickupcity=" + pickupcity + ", deladd=" + deladd
				+ ", delcity=" + delcity + ", shipdate=" + shipdate + ", fare=" + fare + "]";
	}
	
	
	

}
