package models.dao;

import models.Feedback;

import java.util.List;

public interface FeedbackDao {
    //create
    void add (Feedback feedback);

//    //read
//    static List<Feedback> getAll();
//    Feedback findById(int id);
//    // List<Feedback> getAllFeedbackForAFeedback(int feedbackId);

    List<Feedback> getAll();

    Feedback findById(int id);

    //update
    void update(int id, String name, String email, String message);

    //delete
    void deleteById(int id);
    void clearAll();
}
