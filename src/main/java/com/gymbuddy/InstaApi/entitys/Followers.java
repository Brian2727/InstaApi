package com.gymbuddy.InstaApi.entitys;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
public class Followers {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "follower_id", nullable = false)
    private Users followerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "following_id", nullable = false)
    private Users followingId;
    private Timestamp followed_at;

    public Followers(){

    }

    public int getId() {
        return id;
    }

    public Users getFollowerId() {
        return followerId;
    }

    public void setFollowerId(Users followerId) {
        this.followerId = followerId;
    }

    public Users getFollowingId() {
        return followingId;
    }

    public void setFollowingId(Users followingId) {
        this.followingId = followingId;
    }

    public Timestamp getFollowed_at() {
        return followed_at;
    }

    public void setFollowed_at(long followed_at) {
        this.followed_at = new Timestamp(followed_at);
    }
}
