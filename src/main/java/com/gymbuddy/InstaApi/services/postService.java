package com.gymbuddy.InstaApi.services;

import com.gymbuddy.InstaApi.entitys.Post;
import com.gymbuddy.InstaApi.repository.postRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class postService {

    @Autowired
    postRepo repo;
    public List<Post> getAllPost() {
        return repo.findAll();
    }

    public void submitPostMetaData(Post post) {
        post.setCreated_at(System.currentTimeMillis());
        repo.save(post);
    }
}
