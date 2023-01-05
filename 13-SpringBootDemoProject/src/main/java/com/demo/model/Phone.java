package com.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="newPhone")
public class Phone {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int phoneId;
	private String phoneName;
	private int phonePrice;
	private String phoneColor;
	
	public int getPhoneId() {
		return phoneId;
	}
	public void setPhoneId(int phoneId) {
		this.phoneId = phoneId;
	}
	public String getPhoneName() {
		return phoneName;
	}
	public void setPhoneName(String phoneName) {
		this.phoneName = phoneName;
	}
	public int getPhonePrice() {
		return phonePrice;
	}
	public void setPhonePrice(int phonePrice) {
		this.phonePrice = phonePrice;
	}
	public String getPhoneColor() {
		return phoneColor;
	}
	public void setPhoneColor(String phoneColor) {
		this.phoneColor = phoneColor;
	}
	
	public Phone(int phoneId, String phoneName, int phonePrice, String phoneColor) {
		super();
		this.phoneId = phoneId;
		this.phoneName = phoneName;
		this.phonePrice = phonePrice;
		this.phoneColor = phoneColor;
	}
	
	public Phone() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Phone [phoneId=" + phoneId + ", phoneName=" + phoneName + ", phonePrice=" + phonePrice + ", phoneColor="
				+ phoneColor + "]";
	}
	
}
