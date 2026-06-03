package org.example;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Answer {
    private String id;
    private String msg;
    private User author;
    private Date createdOn;
    private boolean isAnswerAccepted;

    List<Vote> votes;
    List<Comment> comments;

    public Answer(String msg, User author){
        this.id = UUID.randomUUID().toString();
        this.msg = msg;
        this.author = author;
        this.createdOn = new Date();
        comments = new ArrayList<>();
        this.isAnswerAccepted=false;

        votes = new ArrayList<>();
        comments = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getMsg() {
        return msg;
    }

    public User getAuthor() {
        return author;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void addComment(Comment comment){
        comments.add(comment);
    }

    public void setAnswerAccepted(boolean answerAccepted){
        this.isAnswerAccepted = answerAccepted;
    }

    public boolean isAnswerAccepted() {
        return isAnswerAccepted;
    }

    public void addVote(Vote vote) {
        votes.add(vote);
    }
}
