package dao;

import models.BedRoom;
import models.LivingRoom;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.sql2o.Connection;

import static org.junit.Assert.*;

public class Sql2oLivingRoomDaoTest {
    private static Sql2oLivingRoomDao livingRoomDao;
    private static Connection conn;

    @BeforeClass
    public static void setUp() throws Exception {
        livingRoomDao = new Sql2oLivingRoomDao(DatabaseRule.sql2o);
        conn = DatabaseRule.sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("clearing database");
        livingRoomDao.clearAll();
    }

    @AfterClass
    public static void shutDown() throws Exception{
        conn.close();
        System.out.println("connection closed");
    }

    @Test
    public void getAll() throws Exception {
        LivingRoom livingRoom = setupLivingRoom();
        LivingRoom livingRoom1 = setupLivingRoom();
        assertEquals(2, livingRoomDao.getAll().size());
    }

    @Test
    public void deleteById() throws Exception {
        LivingRoom livingRoom = setupLivingRoom();
        LivingRoom livingRoom1 = setupLivingRoom();
        assertEquals(2, livingRoomDao.getAll().size());
        livingRoomDao.deleteById(livingRoom1.getId());
        assertEquals(1, livingRoomDao.getAll().size());
    }

    @Test
    public void clearAll() throws Exception {
        LivingRoom livingRoom = setupLivingRoom();
        LivingRoom livingRoom1 = setupLivingRoom();
        livingRoomDao.clearAll();
        assertEquals(0, livingRoomDao.getAll().size());
    }

    //helpers
    public LivingRoom setupLivingRoom(){
        LivingRoom livingRoom = new LivingRoom("Get comfy","mrp","https://www.mrphome.com/");
        livingRoomDao.add(livingRoom);
        return livingRoom;
    }

}