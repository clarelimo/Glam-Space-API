package dao;

import models.Kitchen;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql2oKitchenDao implements KitchenDao {
    private final Sql2o sql2o;

    public Sql2oKitchenDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Kitchen kitchen) {
        String sql = "INSERT INTO kitchens (description,place,link) VALUES(:description,:place,:link)";
        try (Connection conn = sql2o.open()){
            int id = (int) conn.createQuery(sql,true)
                    .bind(kitchen)
                    .executeUpdate()
                    .getKey();
            kitchen.setId(id);

        }catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public List<Kitchen> getAll() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("SELECT * FROM kitchens")
                    .executeAndFetch(Kitchen.class);
        }
    }

    @Override
    public Kitchen findById(int id) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM kitchens WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Kitchen.class);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from kitchens WHERE id = :id";
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
        String sql = "DELETE from kitchens";
        try (Connection conn = sql2o.open()){
            conn.createQuery(sql)
                    .executeUpdate();
        }catch (Sql2oException ex){
            System.out.println(ex);
        }
    }
}
