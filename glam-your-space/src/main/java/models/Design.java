package models;

public abstract class Design {
    public String description;
    public String place;
    public String link;
    public int id;

    public String getDescription() {
        return description;
    }

    public String getPlace() {
        return place;
    }

    public String getLink() {
        return link;
    }

    public int getId() {
        return id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setId(int id) {
        this.id = id;
    }
}
