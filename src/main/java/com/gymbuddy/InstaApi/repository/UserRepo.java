package com.gymbuddy.InstaApi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gymbuddy.InstaApi.entitys.Users;

@Repository
public interface UserRepo extends CrudRepository<Users, Integer> {

	Users save(Users user);
	Users findById(int id);
	Users deleteUsersById(int id);
	
}
