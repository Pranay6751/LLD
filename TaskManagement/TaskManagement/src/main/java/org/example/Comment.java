package org.example;

import java.util.Date;

public class Comment {
    int commentId;
    User author;
    String message;
    Date createdOn;


    public Comment(User author, String message) {
        this.commentId = generateId();
        this.author = author;
        this.message = message;
        this.createdOn = new Date();
    }

    public int generateId() {
        return (int) (System.currentTimeMillis()%Integer.MAX_VALUE);
    }
}
