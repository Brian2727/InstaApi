package com.gymbuddy.InstaApi.Security.DTOs;

import lombok.Data;

@Data
public class CommentDTO {
    private String comment;
    private int authorId;
    private int postId;

    public CommentDTO(String comment, int authorId, int postId) {
        this.comment = comment;
        this.authorId = authorId;
        this.postId = postId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
