package com.gymbuddy.InstaApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gymbuddy.InstaApi.entitys.Users;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {

	Users findByUserName(String userName);
	Users save(Users user);
	Users findById(int id);
	Users deleteUsersById(int id);
	Boolean existsByUserName(String userName);
	
}
