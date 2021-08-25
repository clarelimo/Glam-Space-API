package dao;

import models.BedRoom;
import models.LivingRoom;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oLivingRoomDao implements LivingRoomDao {

    private final Sql2o sql2o;

    public Sql2oLivingRoomDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(LivingRoom livingRoom) {
        String sql = "INSERT INTO living_rooms (description,place,link) VALUES(:description,:place,:link)";
        try (Connection conn = sql2o.open()){
            int id = (int) conn.createQuery(sql,true)
                    .bind(livingRoom)
                    .executeUpdate()
                    .getKey();
            livingRoom.setId(id);

        }catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public List<LivingRoom> getAll() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM living_rooms")
                    .executeAndFetch(LivingRoom.class);
        }
    }

    @Override
    public LivingRoom findById(int id) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM living_rooms WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(LivingRoom.class);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from living_rooms WHERE id = :id";
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
        String sql = "DELETE from living_rooms";
        try (Connection conn = sql2o.open()){
            conn.createQuery(sql)
                    .executeUpdate();
        }catch (Sql2oException ex){
            System.out.println(ex);
        }
    }
}
