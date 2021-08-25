package models.dao;

import models.Feedback;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.assertEquals;


public class Sql20FeedbackDaoTest {
    private Connection conn;
    private Sql20FeedbackDao feedbackDao;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:DB/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "moringa", "moringa");
        feedbackDao = new Sql20FeedbackDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void addingFeedbackSetsId() throws Exception {
        Feedback testFeedback = setupFeedback();
        assertEquals(1, testFeedback.getId());
    }

    @Test
    public void getAll() throws Exception {
        Feedback feedback1 = setupFeedback();
        Feedback feedback2 = setupFeedback();
        assertEquals(2, feedbackDao.getAll().size());
    }

//    @Test
//    public void getAllFeedbackByRestaurant() throws Exception {
//        Restaurant testRestaurant = setupRestaurant();
//        Restaurant otherRestaurant = setupRestaurant(); //add in some extra data to see if it interferes
//        Review review1 = setupReviewForRestaurant(testRestaurant);
//        Review review2 = setupReviewForRestaurant(testRestaurant);
//        Review reviewForOtherRestaurant = setupReviewForRestaurant(otherRestaurant);
//        assertEquals(2, reviewDao.getAllReviewsByRestaurant(testRestaurant.getId()).size());
//    }

    @Test
    public void deleteById() throws Exception {
        Feedback testFeedback = setupFeedback();
        Feedback otherFeedback = setupFeedback();
        assertEquals(2, feedbackDao.getAll().size());
        feedbackDao.deleteById(testFeedback.getId());
        assertEquals(1, feedbackDao.getAll().size());
    }

    @Test
    public void clearAll() throws Exception {
        Feedback testFeedback = setupFeedback();
        Feedback otherFeedback = setupFeedback();
        feedbackDao.clearAll();
        assertEquals(0, feedbackDao.getAll().size());
    }

    public Feedback setupFeedback() {
        Feedback feedback = new Feedback("Fred Dean", "moringaschool@gmail.com", "It was a nice experience.");
        feedbackDao.add(feedback);
        return feedback;
    }
}