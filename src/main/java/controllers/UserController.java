package controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entitys.Users;

@RestController
@RequestMapping("/Users")
public class UserController {
	
	@PostMapping("")
	private boolean submitUser(@RequestBody Users users) {
		
		return true;
		
	}
	@GetMapping("/{userId}")
	private Users getUser(@PathVariable("userId") String userId) {
		
		return new Users();
	}

}
