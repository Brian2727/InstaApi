package com.gymbuddy.InstaApi.entitys;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
public class Comments {

    @Id
    @GeneratedValue
    int id;

    @Nonnull
    String comment;
    Timestamp created_on;

    @ManyToOne
    @JoinColumn(name = "post_id")
    Post post;
    @ManyToOne
    @JoinColumn(name = "user_id")
    Users user;

    public Comments(String comment, Timestamp created_on, Post post, Users user) {
        this.comment = comment;
        this.created_on = created_on;
        this.post = post;
        this.user = user;
    }

    public Comments() {

    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Timestamp getCreated_on() {
        return created_on;
    }

    public void setCreated_on(long created_on) {
        this.created_on = new Timestamp(created_on);
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
