package org.example;

public class Comment {
    private User author;
    private String msg;
    public Comment(User author, String msg){
        this.author=author;
        this.msg=msg;
    }

    public User getAuthor() {
        return author;
    }

    public String getMsg() {
        return msg;
    }
}
