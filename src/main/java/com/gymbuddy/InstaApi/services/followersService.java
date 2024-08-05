package com.gymbuddy.InstaApi.services;


import com.gymbuddy.InstaApi.entitys.Followers;
import com.gymbuddy.InstaApi.entitys.Users;
import com.gymbuddy.InstaApi.repository.UserRepo;
import com.gymbuddy.InstaApi.repository.followersRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;

@Service
public class followersService {

    @Autowired
    followersRepo fRepo;
    @Autowired
    private UserRepo userRepo;


    public Followers followUser(Users following,Users follower){
        Followers followers = new Followers();
        followers.setFollowingId(following);
        followers.setFollowerId(follower);
        followers.setFollowed_at(System.currentTimeMillis());
        fRepo.save(followers);
        return followers;
    }

    @Transactional
    public void unfollowUser(Users following,Users follower){

        fRepo.deleteByFollowingIdAndFollowerId(following,follower);

    }

    public int coutFollowers(String username) {
        Users user = userRepo.findByUserName(username);
        int count = fRepo.countAllByFollowerId(user);
        return count;
    }
    public int coutFollowing(String username) {
        Users user = userRepo.findByUserName(username);
        int count = fRepo.countAllByFollowingId(user);
        return count;
    }
}
