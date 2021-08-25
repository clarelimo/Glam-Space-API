package dao;

import models.LivingRoom;

import java.util.List;

public interface LivingRoomDao {
    //create
    void add(LivingRoom livingRoom);

    //read
    List<LivingRoom> getAll();
    LivingRoom findById(int id);

    //delete
    void deleteById(int id);
    void clearAll();
}
