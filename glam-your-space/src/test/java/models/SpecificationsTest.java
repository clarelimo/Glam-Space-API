package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class SpecificationsTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getDesignSpaceReturnsCorrectDesignSpace() throws Exception {
        Specifications testSpecifications = setupSpecifications();
        assertEquals("Living room", testSpecifications.getDesignSpace());
    }

    @Test
    public void getBudgetReturnsCorrectBudget() throws Exception {
        Specifications testSpecifications = setupSpecifications();
        assertEquals("20,000", testSpecifications.getBudget());
    }

    @Test
    public void setDesignSpaceSetsCorrectDesignSpace() throws Exception {
        Specifications testSpecification = setupSpecifications();
        testSpecification.setDesignSpace("Dinning room");
        assertNotEquals("Living room",testSpecification.getDesignSpace());
    }

    @Test
    public void setBudgetSetsCorrectBudget() throws Exception {
        Specifications testSpecification = setupSpecifications();
        testSpecification.setBudget("50,000");
        assertNotEquals("20,000", testSpecification.getBudget());
    }



    public Specifications setupSpecifications (){
        return new Specifications("Living room", "20,000");
    }

    public Specifications setupAltSpecification (){
        return new Specifications("Living room", "20,000");
    }

}