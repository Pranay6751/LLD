package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StackOverFlow {
     HashMap<String, Answer> answers;
     HashMap<String, Question> questions;
    private static StackOverFlow stackOverFlowInstance;

    private StackOverFlow(){
        answers = new HashMap<>();
        questions = new HashMap<>();
    }

    public static StackOverFlow getStackOverFlowInstance(){
        if(stackOverFlowInstance == null){
            synchronized (StackOverFlow.class) {
                if(stackOverFlowInstance==null){
                    stackOverFlowInstance = new StackOverFlow();
                }
            }
        }
        return stackOverFlowInstance;
    }

    public User createUser(String name){
        User user = new User(name);
//        users.put(user.getId(), user);
        return user;
    }

    public Question askQuestion(String title, String description, User author){
        Question question = new Question(title, description, author);
        questions.put(question.getId(), question);
        return question;
    }

    public Answer addAnswer(String questionId, String msg, User author){
        if(questions.containsKey(questionId)){
            Question question = questions.get(questionId);
            Answer answer = new Answer(msg, author);
            question.addAnswer(answer);
            answers.put(answer.getId(), answer);
            return answer;
        }
        return null;
    }

    public void addCommentToAnswer(String answerId, User author, String msg){
        if(answers.containsKey(answerId)){
            Answer answer = answers.get(answerId);
            answer.addComment(new Comment(author, msg));
        }
    }

    public void addCommentToQuestion(String questionId, User author, String msg){
        if(questions.containsKey(questionId)){
            Question question = questions.get(questionId);
            question.addComment(new Comment(author, msg));
        }
    }

    public void voteQuestion(String questionId, User author, VoteType voteType, int reputation){
        if(questions.containsKey(questionId)){
            Question question = questions.get(questionId);
            if(voteType==VoteType.UPVOTE){
                question.getAuthor().increaseReputation(reputation);
            } else if(voteType==VoteType.DOWNVOTE){
                question.getAuthor().decreaseReputation(reputation);
            }
            question.addVote(new Vote(author, voteType));
        }
    }

    public void voteAnswer(String answerId, User author, VoteType voteType, int reputation){
        if(answers.containsKey(answerId)){
            Answer answer = answers.get(answerId);
            answer.addVote(new Vote(author, voteType));
            if(voteType==VoteType.UPVOTE){
                answer.getAuthor().increaseReputation(reputation);
            } else if(voteType==VoteType.DOWNVOTE){
                answer.getAuthor().decreaseReputation(reputation);
            }
        }
    }

    public int getReputation(User user){
        return user.getReputation();
    }

    public List<Question> searchQuestion(String term){
        List<Question> res = new ArrayList<>();
        for(Question question: questions.values()){
            boolean isMatched=false;
            List<Tag> tags = question.getTags();
            for(Tag tag: tags){
                if(tag.getName().toLowerCase().contains(term)) {
                    isMatched=true;
                    break;
                }
            }
            if(!isMatched && question.getTitle().toLowerCase().contains(term)){
                isMatched=true;
            }
            if(isMatched) {
                res.add(question);
            }
        }
        return res;
    }
}
