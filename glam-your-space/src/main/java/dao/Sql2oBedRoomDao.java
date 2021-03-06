package dao;

import models.BedRoom;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oBedRoomDao implements BedRoomDao {
    private final Sql2o sql2o;

    public Sql2oBedRoomDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(BedRoom bedRoom) {
        String sql = "INSERT INTO bedrooms (description,place,link) VALUES(:description,:place,:link)";
        try (Connection conn = sql2o.open()){
            int id = (int) conn.createQuery(sql,true)
                    .bind(bedRoom)
                    .executeUpdate()
                    .getKey();
            bedRoom.setId(id);

        }catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public List<BedRoom> getAll() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM bedrooms")
                    .executeAndFetch(BedRoom.class);
        }
    }

    @Override
    public BedRoom findById(int id) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM bedrooms WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(BedRoom.class);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from bedrooms WHERE id = :id";
        try  (Connection conn = sql2o.open()){
            conn.createQuery(sql)
                    .addParameter("id",id)
                    .executeUpdate();
        }catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public void clearAll() {
        String sql = "DELETE from bedrooms";
        try (Connection conn = sql2o.open()){
            conn.createQuery(sql)
                    .executeUpdate();
        }catch (Sql2oException ex){
            System.out.println(ex);
        }
    }
}
