package models;

import java.util.Objects;

public class BedRoom extends Design{

    public BedRoom(String description, String place, String link){
        this.description = description;
        this.place = place;
        this.link = link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BedRoom)) return false;
        BedRoom that = (BedRoom) o;
        return id == that.id &&
                Objects.equals(description, that.description) &&
                Objects.equals(place, that.place) &&
                Objects.equals(link,that.link);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description,place, link, id);
    }
}
