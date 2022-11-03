package DataBase;

import CoffeeVan.CoffeeCreators.CoffeeCreator;


import java.sql.*;

public class DataBase {

    private static Connection conn;
    private static Statement mainStatm, secondStatm;

    //connecting
    public static void connection() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:CoffeeVan.db");

        System.out.println("basaDate connected");
    }

    //create tables
    public static void createTable() throws SQLException {
        mainStatm = conn.createStatement();
        secondStatm = conn.createStatement();


        mainStatm.execute("CREATE TABLE IF NOT EXISTS 'typesOfCreator' (" +
                "'id'           INTEGER         PRIMARY KEY AUTOINCREMENT," +
                "'type'         VARCHAR (20)" +
                ")");


        ResultSet existTable = mainStatm.executeQuery("SELECT EXISTS(SELECT * FROM 'typesOfCreator' WHERE id BETWEEN 1 AND 3)");

        if (!existTable.getBoolean(1)) {
            mainStatm.executeUpdate("INSERT INTO 'typesOfCreator'('id', 'type') VALUES ('1','чайник')");
            mainStatm.executeUpdate("INSERT INTO 'typesOfCreator'('id', 'type') VALUES ('2','кавова машина')");
            mainStatm.executeUpdate("INSERT INTO 'typesOfCreator'('id', 'type') VALUES ('3','турка')");
        }

        mainStatm.execute("CREATE TABLE IF NOT EXISTS 'typesOfCoffee' (" +
                "'id'           INTEGER         PRIMARY KEY AUTOINCREMENT," +
                "'type'         VARCHAR (20)," +
                "'idCreator'    INTEGER         REFERENCES 'typesOfCreator' ('id')" +
                ")");

        existTable = mainStatm.executeQuery("SELECT EXISTS(SELECT * FROM 'typesOfCoffee' WHERE id BETWEEN 1 AND 3)");

        if (!existTable.getBoolean(1)) {
            mainStatm.executeUpdate("INSERT INTO 'typesOfCoffee'('id', 'type','idCreator') VALUES ('1','зернова','2')");
            mainStatm.executeUpdate("INSERT INTO 'typesOfCoffee'('id', 'type','idCreator') VALUES ('2','мелена','3')");
            mainStatm.executeUpdate("INSERT INTO 'typesOfCoffee'('id', 'type','idCreator') VALUES ('3','розчинна','1')");
        }

        mainStatm.execute("CREATE TABLE IF NOT EXISTS 'Coffees' (" +
                "'id'           INTEGER         PRIMARY KEY AUTOINCREMENT," +
                "'name'         VARCHAR (60)," +
                "'canSell'      BOOLEAN," +
                "'idType'       INTEGER         REFERENCES 'typesOfCoffee' ('id')," +
                "'state'        VARCHAR (100)," +
                "'countOfSell'  INTEGER         DEFAULT(0)," +
                "'cost'         INTEGER         NOT NULL," +
                "'volume'       DOUBLE          NOT NULL," +
                "'recommendAdd'   VARCHAR (50)" +
                ")");

        mainStatm.execute("CREATE TABLE IF NOT EXISTS 'Creators' (" +
                "'id'           INTEGER         PRIMARY KEY AUTOINCREMENT," +
                "'idType'       INTEGER         REFERENCES 'typesOfCreator' ('id') ," +
                "'isWorking'    BOOLEAN         DEFAULT(1)," +
                "'state'        VARCHAR (100)   DEFAULT('Все добре')" +
                ")");

        existTable.close();
    }

    //geters
    public static Statement getMainStatm(){
        return mainStatm;
    }

    public static Statement getSecondStatm() {
        return secondStatm;
    }

    public static ResultSet getTypeOfCoffee(Statement st, int id) throws SQLException {
        return st.executeQuery("SELECT * FROM 'typesOfCoffee' WHERE id = " + id + "");
    }

    public static ResultSet getTypeOfCreator(Statement st, int id) throws SQLException {
        return st.executeQuery("SELECT * FROM 'typesOfCreator'WHERE id = " + id + "");
    }

    public static Connection getConn() {
        return conn;
    }

    //close
    public static void closeBD() throws SQLException {
        conn.close();
        mainStatm.close();
        secondStatm.close();
        System.out.println("basaDate closed");
    }



}