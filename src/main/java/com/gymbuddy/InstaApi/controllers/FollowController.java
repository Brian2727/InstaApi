package com.gymbuddy.InstaApi.controllers;
import com.gymbuddy.InstaApi.ErrorHandling.UserNotFoundException;
import com.gymbuddy.InstaApi.Security.DTOs.FollowDTO;
import com.gymbuddy.InstaApi.Security.DTOs.usernameDTO;
import com.gymbuddy.InstaApi.entitys.Followers;
import com.gymbuddy.InstaApi.entitys.Users;
import com.gymbuddy.InstaApi.repository.UserRepo;
import com.gymbuddy.InstaApi.services.followersService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/follow")
public class FollowController {
    @Autowired
    followersService fService;

    @Autowired
    UserRepo uRepo;
    @PostMapping("/send")
    public ResponseEntity<String> SubmitfollowUserRequest(@RequestBody FollowDTO follow) {
        Users user = uRepo.findByUserName(follow.username);
        if (user==null){
            throw new UserNotFoundException("User with the username of ("+follow.username+") found");
        }
        Users following = uRepo.findByUserName(follow.follow);
        if (follow==null){
            throw new UserNotFoundException("User with the username of ("+follow.username+") found");
        }
        fService.followUser(following,user);
        return new ResponseEntity<>("Followed user Succesful", HttpStatus.OK);
    }


    @DeleteMapping("/Unfollow")
    public ResponseEntity<String> SubmitUnfollowUserRequest(@RequestBody FollowDTO follow) {
        Users user = uRepo.findByUserName(follow.username);
        if (user==null){
            throw new UserNotFoundException("User with the username of ("+follow.username+") found");
        }
        Users following = uRepo.findByUserName(follow.follow);
        if (follow==null){
            throw new UserNotFoundException("User with the username of ("+follow.follow+") not found");
        }
        fService.unfollowUser(following,user);
        return new ResponseEntity<>("UnFollowed user Succesful", HttpStatus.OK);
    }

    @GetMapping("/count/followers")
    public int coutOfFollowers(@RequestBody usernameDTO username) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(auth.getPrincipal()+"-------------------------------------");
        int followerCount = fService.coutFollowers(username.getUsername());
        return followerCount;
    }

    @GetMapping("/count/following")
    public int coutOfFollowing(@RequestBody usernameDTO username) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        int count = fService.coutFollowing(username.getUsername());
        return count;
    }
}
