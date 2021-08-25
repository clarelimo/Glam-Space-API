package dao;

import models.Kitchen;
import models.LivingRoom;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.sql2o.Connection;

import static org.junit.Assert.*;

public class Sql2oKitchenDaoTest {
    private static Sql2oKitchenDao kitchenDao;
    private static Connection conn;

    @BeforeClass
    public static void setUp() throws Exception {
        kitchenDao = new Sql2oKitchenDao(DatabaseRule.sql2o);
        conn = DatabaseRule.sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("clearing database");
        kitchenDao.clearAll();
    }

    @AfterClass
    public static void shutDown() throws Exception{
        conn.close();
        System.out.println("connection closed");
    }

    @Test
    public void getAll() throws Exception {
        Kitchen kitchen = setupKitchen();
        Kitchen kitchen1 = setupKitchen();
        assertEquals(2, kitchenDao.getAll().size());
    }

    @Test
    public void deleteById() throws Exception {
        Kitchen kitchen = setupKitchen();
        Kitchen kitchen1 = setupKitchen();
        assertEquals(2, kitchenDao.getAll().size());
        kitchenDao.deleteById(kitchen1.getId());
        assertEquals(1, kitchenDao.getAll().size());
    }

    @Test
    public void clearAll() throws Exception {
        Kitchen kitchen = setupKitchen();
        Kitchen kitchen1 = setupKitchen();
        kitchenDao.clearAll();
        assertEquals(0, kitchenDao.getAll().size());
    }

    //helpers
    public Kitchen setupKitchen(){
        Kitchen kitchen = new Kitchen("The Aroma","mrp","https://www.mrphome.com/");
        kitchenDao.add(kitchen);
        return kitchen;
    }
}