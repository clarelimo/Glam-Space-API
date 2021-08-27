package dao;

import models.Kitchen;

import java.util.List;

public interface KitchenDao {
    //create
    void add(Kitchen kitchen);

    //read
    List<Kitchen> getAll();
    Kitchen findById(int id);

    //delete
    void deleteById(int id);
    void clearAll();
}
