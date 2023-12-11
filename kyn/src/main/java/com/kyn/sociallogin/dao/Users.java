package com.kyn.sociallogin.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = "email")})
public class Users {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long usersId;
	
	@Column(nullable = false)
//	@Size(max=15, min=9, message="Your registeration is success.")
	//@Min(value=7, message="Your registeration is failed!! you need to register at least 7 characters")
	// @Max(value=15, message="Your registeration is failed!! you are greater than 25 characters")
	private String userName;
	
	@Email
	@Column(nullable = false)
//	@Max(value=6, message="Your email is more ht")
	private String email;
	
	@JsonIgnore
	//@Max(value=8, message="Your password is more than 8 characters")
	//@Max(value=6, message="Your password is less than 6 characters")
	//@Size(max=8, min=6, message="Your password is success.")
	//@Size(max=20, min=8, message="Your password is valid.")
	//@Size(min=7, message="Your password is invalid.")
	//@Size(max=20, message="Your password is invalid.")
	private String password;
	
	private String imageUrl;
	
	@Column(nullable = false)
	private Boolean emailVerified = false;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private AuthProvider provider;
	
	private String providerId;
	
	public long getUsersId() {
		return usersId;
	}
	public void setUsersId(long usersId) {
		this.usersId = usersId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public Boolean getEmailVerified() {
		return emailVerified;
	}
	public void setEmailVerified(Boolean emailVerified) {
		this.emailVerified = emailVerified;
	}
	public AuthProvider getProvider() {
		return provider;
	}
	public void setProvider(AuthProvider provider) {
		this.provider = provider;
	}
	public String getProviderId() {
		return providerId;
	}
	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}
	
	
}
