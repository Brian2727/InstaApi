package com.gymbuddy.InstaApi.repository;

import com.gymbuddy.InstaApi.entitys.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface postRepo extends JpaRepository<Post,Integer> {
    Post save(Post post);
    Post findPostById(int id);
}
