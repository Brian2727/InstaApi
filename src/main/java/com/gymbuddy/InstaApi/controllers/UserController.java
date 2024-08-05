package com.gymbuddy.InstaApi.controllers;

import com.gymbuddy.InstaApi.ErrorHandling.UserNotFoundException;
import com.gymbuddy.InstaApi.entitys.Post;
import com.gymbuddy.InstaApi.services.postService;
import jakarta.validation.Valid;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gymbuddy.InstaApi.entitys.Users;
import com.gymbuddy.InstaApi.services.usersService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	usersService userService;
	@Autowired
	postService  postService;

	// Removed this code since user creation will now be handled by the account endpoint.
//	@PostMapping("")
//	private boolean submitUser(@RequestBody Users user) {
//		userService.submitMetaDataOfUser(user);
//		return true;
//
//	}

	@GetMapping("/{id}")
	private Users getUser(@PathVariable("id") int id) {

		Users user = userService.displayUserMetaData(id);

		if (user==null){
			throw new UserNotFoundException("User ID was not found id ("+id+")");
		}

		return user;
	}
	@GetMapping("/{id}/posts/all")
	private List<Post> getPost(@PathVariable("id") int id) {

		Optional<Users> user = Optional.ofNullable(userService.displayUserMetaData(id));

		if (user==null){
			throw new UserNotFoundException("User ID was not found id ("+id+")");
		}

		return user.get().getPosts();

	}

	@PostMapping("/{id}/posts/")
	private Boolean CreatePost(@PathVariable("id") int id,@RequestBody Post post) {

		Users user = userService.displayUserMetaData(id);
		if (user==null){
			throw new UserNotFoundException("User ID was not found id ("+id+")");
		}
		post.setUser(user);
		postService.submitPostMetaData(post);

		return true;

	}

	@DeleteMapping("/{id}")
	private boolean deleteUser(@PathVariable("userId") int id) {
		Users user = userService.deleteUserMetaData(id);
		if (user==null){
			throw new UserNotFoundException("No Current User with  ID("+id+") Found On Database Cannot Delete");
		}
		return true;
	}

}
