package com.gymbuddy.InstaApi.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.gymbuddy.InstaApi.entitys.Users;
import com.gymbuddy.InstaApi.repository.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class usersService {
	
	@Autowired
	UserRepo userRepo;
	
	public Users submitMetaDataOfUser(Users user) {
		return  userRepo.save(user);
	}
	
	public Users displayUserMetaData(int id) {
		return userRepo.findById(id);
		 
	}

	public Users deleteUserMetaData(int id) {
		return userRepo.deleteUsersById(id);
	}
}
