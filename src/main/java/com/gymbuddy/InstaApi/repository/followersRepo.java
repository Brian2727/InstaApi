package com.gymbuddy.InstaApi.repository;

import com.gymbuddy.InstaApi.entitys.Followers;
import com.gymbuddy.InstaApi.entitys.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface followersRepo extends JpaRepository<Followers,Integer> {
    Followers save(Followers followers);
    int countAllByFollowerId(Users follower);
    int countAllByFollowingId(Users following);
    void deleteByFollowingIdAndFollowerId(Users following,Users follower);
}
