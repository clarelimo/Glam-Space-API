package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FeedbackTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getNameReturnCorrectName() throws Exception {
        Feedback testFeedback = setupFeedback();
        assertEquals("Fred Dean", testFeedback.getName());
    }

    @Test
    public void getEmailReturnsCorrectEmail() throws Exception {
        Feedback testFeedback = setupAltFeedback();
        assertEquals("moringaschool@gmail.com", testFeedback.getEmail());
    }

    @Test
    public void getMessageReturnsCorrectMessage() throws Exception {
        Feedback testFeedback = setupFeedback();
        assertEquals("It was a nice experience.", testFeedback.getMessage());
    }


    @Test
    public void setNameSetsCorrectName() throws Exception {
        Feedback testFeedback = setupFeedback();
        testFeedback.setName("Brad Pitt");
        assertNotEquals("Fred Dean",testFeedback.getName());
    }

    @Test
    public void setEmailSetsCorrectEmail() throws Exception {
        Feedback testFeedback = setupFeedback();
        testFeedback.setEmail("jamemadisson@gmail.com");
        assertNotEquals("moringaschool@gmail.com", testFeedback.getEmail());
    }

    @Test
    public void setMessageSetsCorrectMessage() throws Exception {
        Feedback testFeedback = setupFeedback();
        testFeedback.setMessage("Thank you very much.");
        assertNotEquals("It was a nice experience.", testFeedback.getMessage());
    }

    public Feedback setupFeedback (){
        return new Feedback("Fred Dean", "moringaschool@gmail.com", "It was a nice experience.");
    }

    public Feedback setupAltFeedback (){
        return new Feedback("Fred Dean", "moringaschool@gmail.com", "It was a nice experience.");
    }

}

