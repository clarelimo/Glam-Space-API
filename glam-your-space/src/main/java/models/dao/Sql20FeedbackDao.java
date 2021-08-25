package models.dao;


import models.Feedback;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;
import java.util.List;

public class Sql20FeedbackDao implements FeedbackDao {
    private final Sql2o sql2o;
    public Sql20FeedbackDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    @Override
    public void add(Feedback feedback) {
        String sql = "INSERT INTO restaurants (name, email, message) VALUES (:name, :email, :message)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .bind(feedback)
                    .executeUpdate()
                    .getKey();
            feedback.setId(id);
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public List<Feedback> getAll() {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM restaurants")
                    .executeAndFetch(Feedback.class);
        }
    }

    @Override
    public Feedback findById(int id) {
        try (Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM restaurants WHERE id = :id")
                    .addParameter("id", id)
                    .executeAndFetchFirst(Feedback.class);
        }
    }

    @Override
    public void update(int id, String newName, String newEmail, String newMessage) {
        String sql = "UPDATE feedback SET (name, email, message) = (:name, :email, :message) WHERE id=:id"; //CHECK!!!
        try (Connection con = sql2o.open()) {
            con.createQuery(sql)
                    .addParameter("name", newName)
                    .addParameter("email", newEmail)
                    .addParameter("message", newMessage)
                    .addParameter("id", id)
                    .executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE from feedback WHERE id = :id"; //raw sql
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
        String sql = "DELETE from feedback";
        try (Connection con = sql2o.open()) {
            con.createQuery(sql).executeUpdate();
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }
}
