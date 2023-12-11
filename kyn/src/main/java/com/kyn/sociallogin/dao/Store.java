package com.kyn.sociallogin.dao;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;



@Entity
@Table(name = "store")
public class Store {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long storeId;
	private String storeName;
	private String storePrice;
	private String storeRegistration;
	public long getStoreId() {
		return storeId;
	}
	public void setStoreId(long storeId) {
		this.storeId = storeId;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getStorePrice() {
		return storePrice;
	}
	public void setStorePrice(String storePrice) {
		this.storePrice = storePrice;
	}
	public String getStoreRegistration() {
		return storeRegistration;
	}
	public void setStoreRegistration(String storeRegistration) {
		this.storeRegistration = storeRegistration;
	}
	
	
}