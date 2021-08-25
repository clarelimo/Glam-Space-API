package dao;

import org.sql2o.Sql2o;

public class DB {
    public static Sql2o sql2o = new Sql2o("jdbc:postgresql://ec2-44-197-40-76.compute-1.amazonaws.com:5432/de524mr01r3ne2", "buhjkvweqgdhzh", "f00bce2e0a4bbacd7efa0ea069ff64b1a240988ba65ac950d70680ce0bc516ab");
}
