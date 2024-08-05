package com.gymbuddy.InstaApi.entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import org.springframework.context.annotation.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name="Users")
public class Users implements UserDetails {

	@Id
	@GeneratedValue
	private int id;

	@Column(nullable = false,unique = true)
    private String userName;
	@Nonnull
	private String password;
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			name = "user_roles",
			joinColumns = @JoinColumn(name = "users_id"),
			inverseJoinColumns = @JoinColumn(name = "roles_id")
	)
	private Set<Roles> roles = new HashSet<>();
	private String fname;
	private String lname;
	private String profilePicture;

	public int getId() {
		return id;
	}

	public Set<Roles> getRoles() {
		return roles;
	}

	public void setRoles(Set<Roles> roles) {
		this.roles = roles;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of();
	}

	@Nonnull
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return "";
	}

	public void setPassword(@Nonnull String password) {
		this.password = password;
	}

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

	public Users(int id, String userId, String userName, String fname, String lname, String profilePicture,String password) {
		super();
		this.password = password;
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
