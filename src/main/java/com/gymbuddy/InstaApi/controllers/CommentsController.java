package com.gymbuddy.InstaApi.controllers;


import com.gymbuddy.InstaApi.ErrorHandling.UserNotFoundException;
import com.gymbuddy.InstaApi.Security.DTOs.CommentDTO;
import com.gymbuddy.InstaApi.entitys.Comments;
import com.gymbuddy.InstaApi.entitys.Post;
import com.gymbuddy.InstaApi.entitys.Users;
import com.gymbuddy.InstaApi.repository.UserRepo;
import com.gymbuddy.InstaApi.repository.postRepo;
import com.gymbuddy.InstaApi.services.commentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/comments")
public class CommentsController {
    @Autowired
    UserRepo uRepo;
    @Autowired
    postRepo pRepo;
    @Autowired
    commentsService cService;

    @PostMapping("/")
    private boolean SubmitCommentMetaData(@RequestBody CommentDTO commentsDTO){
        Comments comment = new Comments();
        Users user = uRepo.findById(commentsDTO.getAuthorId());
        Post post = pRepo.findPostById(commentsDTO.getPostId());
        if (user==null){
            throw new UserNotFoundException("User ID was not found id ("+commentsDTO.getAuthorId()+")");
        }
        comment.setUser(user);
        if (user==null){
            throw new UserNotFoundException("No Such Post id ("+commentsDTO.getPostId()+")");
        }
        comment.setPost(post);
        comment.setComment(commentsDTO.getComment());
        cService.addComment(comment);
        return true;
    }
}
