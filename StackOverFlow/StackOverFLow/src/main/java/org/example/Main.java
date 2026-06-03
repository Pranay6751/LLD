package org.example;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        StackOverFlow stackOverFlowInstance =
                StackOverFlow.getStackOverFlowInstance();

        // Create Users
        User user1 = stackOverFlowInstance.createUser("Pranay");
        User user2 = stackOverFlowInstance.createUser("Pavan");
        User user3 = stackOverFlowInstance.createUser("Rohith");

        // Ask Questions
        Question question1 = stackOverFlowInstance.askQuestion("What is LLD?", "Explain it in detail", user1);

        Question question2 = stackOverFlowInstance.askQuestion("What is SQL?", "Explain it in detail", user2);

        // Add Tags
        question1.addTag(new Tag("SystemDesign"));
        question1.addTag(new Tag("LLD"));

        question2.addTag(new Tag("Database"));
        question2.addTag(new Tag("SQL"));

        // Add Answers
        Answer answer1 = stackOverFlowInstance.addAnswer(question1.getId(), "LLD focuses on classes, objects and design patterns", user2);

        Answer answer2 = stackOverFlowInstance.addAnswer(question1.getId(), "LLD converts requirements into maintainable code", user3);

        // Add Comment to Question
        stackOverFlowInstance.addCommentToQuestion(
                question1.getId(),
                user2,
                "Can you specify if you need interview perspective?"
        );

        // Add Comment to Answer
        stackOverFlowInstance.addCommentToAnswer(
                answer1.getId(),
                user1,
                "Nice explanation!"
        );

        // Vote Question
        stackOverFlowInstance.voteQuestion(
                question1.getId(),
                user2,
                VoteType.UPVOTE,
                5
        );

        // Vote Answer
        stackOverFlowInstance.voteAnswer(
                answer1.getId(),
                user1,
                VoteType.UPVOTE,
                10
        );

        // Accept Answer
        answer1.setAnswerAccepted(true);

        // Search Questions
        System.out.println("\n===== SEARCH RESULTS =====");

        List<Question> questions =
                stackOverFlowInstance.searchQuestion(
                        "systemdesign"
                );

        for(Question question : questions) {
            System.out.println(
                    question.getTitle()
            );
        }

        // Reputation
        System.out.println("\n===== REPUTATION =====");

        System.out.println(
                user1.getName()
                        + " Reputation : "
                        + stackOverFlowInstance.getReputation(user1)
        );

        System.out.println(
                user2.getName()
                        + " Reputation : "
                        + stackOverFlowInstance.getReputation(user2)
        );

        System.out.println(
                user3.getName()
                        + " Reputation : "
                        + stackOverFlowInstance.getReputation(user3)
        );

        System.out.println("\n===== DONE =====");
    }
}