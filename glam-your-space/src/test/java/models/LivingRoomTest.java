package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class LivingRoomTest {
    @Test
    public void getDescriptionReturnsCorrectDescription() {
        LivingRoom livingRoom = setupLivingRoom();
        assertEquals("Get comfy", livingRoom.getDescription());
    }

    @Test
    public void getPlaceReturnsCorrectPlace() {
        LivingRoom livingRoom = setupLivingRoom();
        assertEquals("mrp", livingRoom.getPlace());
    }

    @Test
    public void getLinkReturnsCorrectLink() {
        LivingRoom livingRoom = setupLivingRoom();
        assertEquals("https://www.mrphome.com/", livingRoom.getLink());
    }

    @Test
    public void setDescriptionSetsCorrectDescription() throws Exception {
        LivingRoom livingRoom = setupLivingRoom();
        livingRoom.setDescription("Relax");
        assertNotEquals("The Aroma",livingRoom.getDescription());
    }

    @Test
    public void setPlaceSetsCorrectPlace() throws Exception {
        LivingRoom livingRoom = setupLivingRoom();
        livingRoom.setPlace("odds and ends");
        assertNotEquals("mrp",livingRoom.getPlace());
    }

    @Test
    public void setLinkCorrectLink() throws Exception {
        LivingRoom livingRoom = setupLivingRoom();
        livingRoom.setLink("https://www.oddskenya.com/");
        assertNotEquals("https://www.mrphome.com/",livingRoom.getLink());
    }

    //helper
    public LivingRoom setupLivingRoom(){
        return  new LivingRoom("Get comfy","mrp","https://www.mrphome.com/");
    }
}