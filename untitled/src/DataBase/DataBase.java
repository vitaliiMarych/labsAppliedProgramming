package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {

    private static Connection conn;
    private static Statement statm;

    public static void connection() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:CoffeeVan.db");

        System.out.println("basaDate connected");
    }

//    public static void insertType(String type) throws SQLException {
//        statm.execute("INSERT INTO 'types' ('type') values ('"+ type +"')");
//
//        System.out.println(type + " added");
//    }


    public static void createTable() throws SQLException {
        statm = conn.createStatement();

        statm.execute("CREATE TABLE IF NOT EXISTS 'typesOfCoffee' (" +
                "'id'           INTEGER         PRIMARY KEY AUTOINCREMENT," +
                "'type'         VARCHAR (20)" +
                ")");

        statm.execute("INSERT INTO 'typesOfCreators'('id', 'type') VALUES ('1','зернова')");
        statm.execute("INSERT INTO 'typesOfCreators'('id', 'type') VALUES ('2','мелена')");
        statm.execute("INSERT INTO 'typesOfCreators'('id', 'type') VALUES ('3','розчинна')");

        statm.execute("CREATE TABLE IF NOT EXISTS 'Coffees' (" +
                "'id'           INTEGER         PRIMARY KEY AUTOINCREMENT," +
                "'name'         VARCHAR (60)," +
                "'canSell'      BOOLEAN         DEFAULT(0)," +
                "'type'         VARCHAR (30)," +
                "'state'        VARCHAR (100)," +
                "'countOfSell'  INTEGER         DEFAULT(0)," +
                "'cost'         INTEGER         NOT NULL," +
                "'volume'       DOUBLE          NOT NULL," +
                "'idCreator'    INTEGER         REFERENCES 'typesOfCoffee' ('id')" +
                ")");

        statm.execute("CREATE TABLE IF NOT EXISTS 'Creators' (" +
                "'id'           INTEGER         PRIMARY KEY AUTOINCREMENT," +
                "'type'         INTEGER         REFERENCES 'typesOfCoffee' ('id') ," +
                "'isWorking'    BOOLEAN         DEFAULT(0)," +
                "'state'        VARCHAR (100)   DEFAULT('Everything is good')" +
                ")");

        System.out.println("tables created");

    }


    public static void closeBD() throws SQLException {
        conn.close();
        statm.close();
        System.out.println("basaDate closed");
    }


}