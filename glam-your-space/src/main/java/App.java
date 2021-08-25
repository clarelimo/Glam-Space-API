import com.google.gson.Gson;
import dao.DB;
import dao.Sql2oBedRoomDao;
import dao.Sql2oKitchenDao;
import dao.Sql2oLivingRoomDao;
import exceptions.ApiException;
import models.BedRoom;
import models.Kitchen;
import models.LivingRoom;
import org.sql2o.Connection;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        Sql2oKitchenDao sql2oKitchenDao;
        Sql2oLivingRoomDao sql2oLivingRoomDao;
        Sql2oBedRoomDao sql2oBedRoomDao;
        Gson gson = new Gson();
        Connection conn;

        sql2oKitchenDao = new Sql2oKitchenDao(DB.sql2o);
        sql2oLivingRoomDao = new Sql2oLivingRoomDao(DB.sql2o);
        sql2oBedRoomDao = new Sql2oBedRoomDao(DB.sql2o);
        conn = DB.sql2o.open();

//        get("/", "application/json", (req, res) -> {
//            System.out.println(.getAll());
//
//            if(departmentDao.getAll().size() > 0){
//                return gson.toJson(departmentDao.getAll());
//            }
//
//            else {
//                return "{\"message\":\"I'm sorry, but no departments are currently listed in the database.\"}";
//            }
//        });

        //CREATE
        post("/kitchen/new", "application/json", (req, res) -> {
            Kitchen kitchen = gson.fromJson(req.body(), Kitchen.class);
            sql2oKitchenDao.add(kitchen);
            res.status(201);
            return gson.toJson(kitchen);
        });

        post("/livingroom/new", "application/json", (req, res) -> {
            LivingRoom livingRoom = gson.fromJson(req.body(), LivingRoom.class);
            sql2oLivingRoomDao.add(livingRoom);
            res.status(201);
            return gson.toJson(livingRoom);
        });

        post("/bedroom/new", "application/json", (req, res) -> {
            BedRoom bedRoom = gson.fromJson(req.body(), BedRoom.class);
            sql2oBedRoomDao.add(bedRoom);
            res.status(201);
            return gson.toJson(bedRoom);
        });

        //READ
        get("/kitchens", "application/json", (req, res) -> {
            System.out.println(sql2oKitchenDao.getAll());

            if(sql2oKitchenDao.getAll().size() > 0){
                return gson.toJson(sql2oKitchenDao.getAll());
            }

            else {
                return "{\"message\":\"I'm sorry, but no kitchens are currently listed in the database.\"}";
            }
        });

        get("/livingrooms", "application/json", (req, res) -> {
            System.out.println(sql2oLivingRoomDao.getAll());

            if(sql2oLivingRoomDao.getAll().size() > 0){
                return gson.toJson(sql2oLivingRoomDao.getAll());
            }

            else {
                return "{\"message\":\"I'm sorry, but no living rooms are currently listed in the database.\"}";
            }
        });

        get("/bedrooms", "application/json", (req, res) -> {
            System.out.println(sql2oBedRoomDao.getAll());

            if(sql2oBedRoomDao.getAll().size() > 0){
                return gson.toJson(sql2oBedRoomDao.getAll());
            }

            else {
                return "{\"message\":\"I'm sorry, but no bedrooms are currently listed in the database.\"}";
            }
        });

        //FILTERS
        exception(ApiException.class, (exception, req, res) -> {
            ApiException err = exception;
            Map<String, Object> jsonMap = new HashMap<>();
            jsonMap.put("status", err.getStatusCode());
            jsonMap.put("errorMessage", err.getMessage());
            res.type("application/json");
            res.status(err.getStatusCode());
            res.body(gson.toJson(jsonMap));
        });

        after((req, res) ->{
            res.type("application/json");
        });
    }
}
