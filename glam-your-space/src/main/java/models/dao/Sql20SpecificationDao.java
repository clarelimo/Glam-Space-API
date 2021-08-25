package models.dao;

import models.Specifications;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sql20SpecificationDao implements SpecificationDao{
    private final Sql2o sql2o;
    public Sql20SpecificationDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Specifications specifications) {
        String sql = "INSERT INTO restaurants (designSpace, budget) VALUES (:designSpace, :budget)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .bind(specifications)
                    .executeUpdate()
                    .getKey();
            specifications.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Specifications> getAll() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM SPECIFICATIONS")
                    .executeAndFetch(Specifications.class);
        }
    }

    @Override
    public Specifications findById(int id) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM SPECIFICATIONS WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Specifications.class);
        }
    }

    @Override
    public void update(int id, String newDesignSpace, String newBudget) {
        String sql = "UPDATE specifications SET (designSpace, budget) WHERE id=:id"; //CHECK!!!
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("designSpace", newDesignSpace)
                    .addParameter("budget", newBudget)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from specifications WHERE id = :id"; //raw sql
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public void clearAll() {
        String sql = "DELETE from specifications";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

}
