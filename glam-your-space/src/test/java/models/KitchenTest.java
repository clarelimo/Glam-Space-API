package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class KitchenTest {
    @Test
    public void getDescriptionReturnsCorrectDescription() {
        Kitchen kitchen = setupKitchen();
        assertEquals("The Aroma", kitchen.getDescription());
    }

    @Test
    public void getPlaceReturnsCorrectPlace() {
        Kitchen kitchen = setupKitchen();
        assertEquals("mrp", kitchen.getPlace());
    }

    @Test
    public void getLinkReturnsCorrectLink() {
        Kitchen kitchen = setupKitchen();
        assertEquals("https://www.mrphome.com/", kitchen.getLink());
    }

    @Test
    public void setDescriptionSetsCorrectDescription() throws Exception {
        Kitchen kitchen = setupKitchen();
        kitchen.setDescription("Cooking");
        assertNotEquals("The Aroma",kitchen.getDescription());
    }

    @Test
    public void setPlaceSetsCorrectPlace() throws Exception {
        Kitchen kitchen = setupKitchen();
        kitchen.setPlace("odds and ends");
        assertNotEquals("mrp",kitchen.getPlace());
    }

    @Test
    public void setLinkCorrectLink() throws Exception {
        Kitchen kitchen = setupKitchen();
        kitchen.setLink("https://www.oddskenya.com/");
        assertNotEquals("https://www.mrphome.com/",kitchen.getLink());
    }

    //helper
    public Kitchen setupKitchen(){
        return  new Kitchen("The Aroma","mrp","https://www.mrphome.com/");
    }
}