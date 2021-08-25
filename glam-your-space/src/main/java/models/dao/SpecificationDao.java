package models.dao;

import models.Specifications;

import java.util.List;

public interface SpecificationDao {

    //create
    void add(Specifications specifications);

    List<Specifications> getAll();

    Specifications findById(int id);

    void update(int id, String newDesignSpace, String newBudget);

    void deleteById(int id);

    void clearAll();
}

