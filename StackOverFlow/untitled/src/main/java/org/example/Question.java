package org.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Question {
    private String id;
    private String title;
    private String description;
    private User author;
    private Date createdOn;

    List<Answer> answers;
    List<Comment> comments;
    List<Tag> tags;
    List<Vote> votes;

    public Question(String title, String description, User author){
        this.id= UUID.randomUUID().toString();
        this.title=title;
        this.description=description;
        this.author=author;
        this.createdOn=new Date();

        answers = new ArrayList<>();
        comments = new ArrayList<>();
        tags = new ArrayList<>();
        votes = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public User getAuthor() {
        return author;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void addAnswer(Answer answer){
        answers.add(answer);
    }
    public void addTag(Tag tag){
        tags.add(tag);
    }
    public void addComment(Comment comment){
        comments.add(comment);
    }
    public void addVote(Vote vote){
        votes.add(vote);
    }
}
