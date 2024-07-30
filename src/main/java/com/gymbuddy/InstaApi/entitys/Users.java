package com.gymbuddy.InstaApi.entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity(name="Users")
public class Users {
	
	
	
	@Id
	@GeneratedValue
	private int id;

	@Nonnull
	private String userName;
	private String fname;
	private String lname;
	private String profilePicture;

	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Post> posts;

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users(int id, String userId, String userName, String fname, String lname, String profilePicture) {
		super();
		this.id = id;
		this.userName = userName;
		this.fname = fname;
		this.lname = lname;
		this.profilePicture = profilePicture;
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
