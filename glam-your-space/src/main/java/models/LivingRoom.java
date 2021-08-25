package models;

import java.util.Objects;

public class LivingRoom extends Design{
    public LivingRoom(String description, String place, String link){
        this.description = description;
        this.place = place;
        this.link = link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LivingRoom)) return false;
        LivingRoom that = (LivingRoom) o;
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
