package com.gymbuddy.InstaApi.services;

import com.gymbuddy.InstaApi.Security.DTOs.CommentDTO;
import com.gymbuddy.InstaApi.entitys.Comments;
import com.gymbuddy.InstaApi.repository.UserRepo;
import com.gymbuddy.InstaApi.repository.commentsRepo;
import com.gymbuddy.InstaApi.repository.postRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class commentsService {



    @Autowired
    commentsRepo cRepo;

    public Comments addComment(Comments comment){
        comment.setCreated_on(System.currentTimeMillis());
        return cRepo.save(comment);
    }

}
