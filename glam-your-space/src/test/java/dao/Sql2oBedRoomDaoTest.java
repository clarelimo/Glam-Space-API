package dao;

import models.BedRoom;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.sql2o.Connection;


import static org.junit.Assert.*;

public class Sql2oBedRoomDaoTest {
    private static Sql2oBedRoomDao bedRoomDao;
    private static Connection conn;

    @BeforeClass
    public static void setUp() throws Exception {
        bedRoomDao = new Sql2oBedRoomDao(DatabaseRule.sql2o);
        conn = DatabaseRule.sql2o.open();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("clearing database");
        bedRoomDao.clearAll();
    }

    @AfterClass
    public static void shutDown() throws Exception{
        conn.close();
        System.out.println("connection closed");
    }

    @Test
    public void getAll() throws Exception {
        BedRoom bedRoom = setupBedroom();
        BedRoom bedRoom1 = setupBedroom();
        assertEquals(2, bedRoomDao.getAll().size());
    }

    @Test
    public void deleteById() throws Exception {
        BedRoom bedRoom = setupBedroom();
        BedRoom bedRoom1 = setupBedroom();
        assertEquals(2, bedRoomDao.getAll().size());
        bedRoomDao.deleteById(bedRoom1.getId());
        assertEquals(1, bedRoomDao.getAll().size());
    }

    @Test
    public void clearAll() throws Exception {
        BedRoom bedRoom = setupBedroom();
        BedRoom bedRoom1 = setupBedroom();
        bedRoomDao.clearAll();
        assertEquals(0, bedRoomDao.getAll().size());
    }

    //helpers
    public BedRoom setupBedroom(){
        BedRoom bedRoom = new BedRoom("Sleeping beauty","mrp","https://www.mrphome.com/");
        bedRoomDao.add(bedRoom);
        return bedRoom;
    }

}
