package dao;

import models.BedRoom;

import java.util.List;

public interface BedRoomDao {
    //create
    void add(BedRoom bedRoom);

    //read
    List<BedRoom> getAll();
    BedRoom findById(int id);

    //delete
    void deleteById(int id);
    void clearAll();
}
