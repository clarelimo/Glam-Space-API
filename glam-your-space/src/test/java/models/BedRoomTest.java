package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class BedRoomTest {
    @Test
    public void getDescriptionReturnsCorrectDescription() {
        BedRoom bedRoom = setupBedroom();
        assertEquals("Sleeping beauty", bedRoom.getDescription());
    }

    @Test
    public void getPlaceReturnsCorrectPlace() {
        BedRoom bedRoom = setupBedroom();
        assertEquals("mrp", bedRoom.getPlace());
    }

    @Test
    public void getLinkReturnsCorrectLink() {
        BedRoom bedRoom = setupBedroom();
        assertEquals("https://www.mrphome.com/", bedRoom.getLink());
    }

    @Test
    public void setDescriptionSetsCorrectDescription() throws Exception {
        BedRoom bedRoom = setupBedroom();
        bedRoom.setDescription("Calm");
        assertNotEquals("Sleeping beauty",bedRoom.getDescription());
    }

    @Test
    public void setPlaceSetsCorrectPlace() throws Exception {
        BedRoom bedRoom = setupBedroom();
        bedRoom.setPlace("odds and ends");
        assertNotEquals("mrp",bedRoom.getPlace());
    }

    @Test
    public void setLinkCorrectLink() throws Exception {
        BedRoom bedRoom = setupBedroom();
        bedRoom.setLink("https://www.oddskenya.com/");
        assertNotEquals("https://www.mrphome.com/",bedRoom.getLink());
    }

    //helper
    public BedRoom setupBedroom(){
        return  new BedRoom("Sleeping beauty","mrp","https://www.mrphome.com/");
    }

}