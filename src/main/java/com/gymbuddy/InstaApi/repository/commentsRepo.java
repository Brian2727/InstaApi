package com.gymbuddy.InstaApi.repository;

import com.gymbuddy.InstaApi.entitys.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface commentsRepo extends JpaRepository<Comments, Integer> {
}
