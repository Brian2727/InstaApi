package com.gymbuddy.InstaApi.controllers;

import com.gymbuddy.InstaApi.ErrorHandling.UserNotFoundException;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gymbuddy.InstaApi.entitys.Users;
import com.gymbuddy.InstaApi.services.usersService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	usersService userService;
	
	@PostMapping("")
	private boolean submitUser(@RequestBody Users user) {
		userService.submitMetaDataOfUser(user);
		return true;
		
	}
	@GetMapping("/{userId}")
	private Users getUser(@PathVariable("userId") String userId) {

		Users user = userService.displayUserMetaData(userId);

		if (user==null){
			throw new UserNotFoundException("User ID was not found id ("+userId+")");
		}

		return user;

	}

	@DeleteMapping("/{userId}")
	private boolean deleteUser(@PathVariable("userId") String userId) {
		Users user = userService.deleteUserMetaData(userId);
		if (user==null){
			throw new UserNotFoundException("No Current User with  ID("+userId+") Found On Database Cannot Delete");
		}
		return true;
	}

}
