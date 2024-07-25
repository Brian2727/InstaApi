package com.gymbuddy.InstaApi.entitys;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity(name="Users")
public class Users {
	
	
	
	@Id
	@GeneratedValue
	private int id;

	@Nonnull
	private String userId;
	private String userName;
	private String fname;
	private String lname;
	private String profilePicture;
	
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users(int id, String userId, String userName, String fname, String lname, String profilePicture) {
		super();
		this.id = id;
		this.userId = userId;
		this.userName = userName;
		this.fname = fname;
		this.lname = lname;
		this.profilePicture = profilePicture;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}
	
	
	
	
}
