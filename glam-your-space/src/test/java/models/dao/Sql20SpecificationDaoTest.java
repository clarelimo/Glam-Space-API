package models.dao;

import models.Specifications;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.Assert.assertEquals;
public class Sql20SpecificationDaoTest {
    private Connection conn;
    private Sql20SpecificationDao specificationDao;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:DB/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "moringa", "moringa");
        specificationDao = new Sql20SpecificationDao(sql2o);
        conn = sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

//
    @Test
    public void addedSpecificationsAreReturnedFromGetAll() throws Exception {
        Specifications testSpecification = setupSpecifications();
        assertEquals("Living room", specificationDao.getAll().size());
    }

    @Test
    public void noSpecificationReturnsEmptyList() throws Exception {
        assertEquals("null", specificationDao.getAll().size());
    }

    @Test
    public void findByIdReturnsCorrectSpecification() throws Exception {
        Specifications testSpecification = setupSpecifications();
        Specifications otherSpecification = setupSpecifications();
        assertEquals(testSpecification, specificationDao.findById(testSpecification.getId()));
    }



    @Test
    public void deleteByIdDeletesCorrectSpecification() throws Exception {
        Specifications testSpecifications = setupSpecifications();
        Specifications otherSpecifications = setupSpecifications();
        specificationDao.deleteById(testSpecifications.getId());
        assertEquals("Living room", specificationDao.getAll().size());
    }

    @Test
    public void clearAll() throws Exception {
        Specifications testSpecification = setupSpecifications();
        Specifications otherSpecifications = setupSpecifications();
        specificationDao.clearAll();
        assertEquals("Living room","", specificationDao.getAll().size());
    }

    //helpers

    public Specifications setupSpecifications (){
         Specifications specifications = new Specifications("Living room", "20,000");
        specificationDao.add(specifications);
        return specifications;
    }

    public Specifications setupAltSpecifications(){
        Specifications specifications = new Specifications("Living room", "20,000");
        specificationDao.add(specifications);
        return specifications;
    }
}