package com.gymbuddy.InstaApi.entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Post {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String body;
    private String path;
    private Timestamp created_at;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Users user;



    public Post() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(long current) {
        this.created_at = new Timestamp(current);
    }

    public Post(String title, String body, String path, Timestamp created_at) {
        this.title = title;
        this.body = body;
        this.user = user;
        this.path = path;
        this.created_at = created_at;
    }
}
