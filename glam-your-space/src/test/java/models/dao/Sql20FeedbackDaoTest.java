package models.dao;

import models.Feedback;
import models.dao.Sql2oFeedbackDao;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;


public class Sql20FeedbackDaoTest {
    private Connection conn;
    private Sql2oFeedbackDao feedbackDao;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
        feedbackDao = new Sql2oFeedbackDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }


    @Test
    public void addedFeedbacksAreReturnedFromGetAll() throws Exception {
        Feedback testFeedback = setupFeedback();
        assertEquals(1, FeedbacktDao.getAll().size());
    }

    @Test
    public void noFeedbacksReturnsEmptyList() throws Exception {
        assertEquals(0, feedbackDao.getAll().size());
    }

    @Test
    public void findByIdReturnsCorrectFeedback() throws Exception {
        Feedback testFeedback = setupFeedback();
        Feedback otherFeedback = setupFeedback();
        assertEquals(testFeedback, feedbackDao.findById(testFeedback.getId()));
    }

    @Test
    public void updateCorrectlyUpdatesAllFields() throws Exception {
        Feedback testFeedback = setupFeedback();
        feedbackDao.update(testFeedback.getId(), "a", "b", "c", "d", "e", "f");
        Feedback foundFeedback = feedbackDao.findById(testFeedback.getId());
        assertEquals("a", foundFeedback.getName());
        assertEquals("b", foundFeedback.getEmail());
        assertEquals("c", foundFeedback.getMessage());
    }

    @Test
    public void deleteByIdDeletesCorrectFeedback() throws Exception {
        Feedback tesFeedback = setupFeedback();
        Feedback otherFeedback = setupFeedback();
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

    //helpers

    public Feedback setupFeedback (){
        Feedback feedback = new Feedback("Fred Dean", "moringaschool@gmail.com", "It was a nice experience.");
        feedbackDao.add(feedback);
        return feedback;
    }

    public Feedback setupAltFeedback (){
        Feedback feedback = new Feedback("Fred Dean", "moringaschool@gmail.com",  "It was a nice experience.");
        feedbackDao.add(feedback);
        return feedback;
    }