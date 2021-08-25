package models;

import java.util.Objects;

public class Specifications {
    private String designSpace;
    private String budget;
    private int id;


    public Specifications(String designSpace, String budget) {
        this.designSpace = designSpace;
        this.budget = budget;
    }

    public String getDesignSpace() {
        return designSpace;
    }

    public String getBudget() {
        return budget;
    }

    public int getId() {
        return id;
    }

    public void setDesignSpace(String designSpace) {
        this.designSpace = designSpace;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Specifications)) return false;
        Specifications that = (Specifications) o;
        return id == that.id &&
                Objects.equals(designSpace, that.designSpace) &&
                Objects.equals(budget, that.budget);
    }

    @Override
    public int hashCode() {
        return Objects.hash(designSpace, budget, id);
    }
}
