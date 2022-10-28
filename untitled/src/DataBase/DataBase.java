package DataBase;

import CoffeeVan.CoffeeCreators.CoffeeCreator;


import java.sql.*;

public class DataBase {

    private static Connection conn;
    private static Statement mainStatm, statmCoffee, statmCreator, statmTypCoffe, statmTypCreator;

    //connecting
    public static void connection() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:CoffeeVan.db");

        System.out.println("basaDate connected");
    }

    //create tables
    public static void createTable() throws SQLException {
        mainStatm = conn.createStatement();
        statmCoffee = conn.createStatement();
        statmCreator = conn.createStatement();
        statmTypCoffe = conn.createStatement();
        statmTypCreator = conn.createStatement();

        mainStatm.execute("CREATE TABLE IF NOT EXISTS 'typesOfCreator' (" +
                "'id'           INTEGER         PRIMARY KEY AUTOINCREMENT," +
                "'type'         VARCHAR (20)" +
                ")");

        ResultSet existTable = mainStatm.executeQuery("SELECT EXISTS(SELECT * FROM 'typesOfCreator' WHERE id BETWEEN 1 AND 3)");

        if (!existTable.getBoolean(1)) {
            mainStatm.execute("INSERT INTO 'typesOfCreator'('id', 'type') VALUES ('1','чайник')");
            mainStatm.execute("INSERT INTO 'typesOfCreator'('id', 'type') VALUES ('2','кавова машина')");
            mainStatm.execute("INSERT INTO 'typesOfCreator'('id', 'type') VALUES ('3','турка')");
        }

        mainStatm.execute("CREATE TABLE IF NOT EXISTS 'typesOfCoffee' (" +
                "'id'           INTEGER         PRIMARY KEY AUTOINCREMENT," +
                "'type'         VARCHAR (20)," +
                "'idCreator'    INTEGER         REFERENCES 'typesOfCreator' ('id')" +
                ")");

        existTable = mainStatm.executeQuery("SELECT EXISTS(SELECT * FROM 'typesOfCoffee' WHERE id BETWEEN 1 AND 3)");

        if (!existTable.getBoolean(1)) {
            mainStatm.execute("INSERT INTO 'typesOfCoffee'('id', 'type','idCreator') VALUES ('1','зернова','2')");
            mainStatm.execute("INSERT INTO 'typesOfCoffee'('id', 'type','idCreator') VALUES ('2','мелена','3')");
            mainStatm.execute("INSERT INTO 'typesOfCoffee'('id', 'type','idCreator') VALUES ('3','розчинна','1')");
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
                "'state'        VARCHAR (100)   DEFAULT('Everything is good')" +
                ")");

        System.out.println("tables created");

    }

    //inserts
    public static void insertCoffee(String NAME, String TYPE,
                                    int COST, double VOLUME, String RECOMMEND) throws SQLException {

        boolean canSell = false;
        String state = "Нема на складі";

        if (VOLUME > 0) {
            canSell = true;
            state = "Можна продавати";
        }

        ResultSet idType = mainStatm.executeQuery(String.format("SELECT id FROM 'typesOfCoffee' WHERE type = '%s'", TYPE));

        mainStatm.execute("INSERT INTO 'Coffees'(name, canSell, idType, state, cost, volume, recommendAdd) VALUES" +
                String.format("('%s','%b','%d','%s','%d','%f','%s')",
                        NAME, canSell, idType.getInt(1), state, COST, VOLUME, RECOMMEND));

    }

    //geters
    public static ResultSet getCoffeeData() throws SQLException {
        return statmCoffee.executeQuery("SELECT * FROM 'Coffees'");
    }

    public static ResultSet getTypeOfCoffee(int id) throws SQLException {
        return statmTypCoffe.executeQuery("SELECT * FROM 'typesOfCoffee' WHERE id = " + id + "");
    }

    public static ResultSet getTypeOfCreator(int id) throws SQLException {
        return statmTypCreator.executeQuery("SELECT * FROM 'typesOfCreator'WHERE id = " + id + "");
    }

    public static ResultSet getCreators() throws SQLException {
        return statmCreator.executeQuery("SELECT * FROM 'Creators'");
    }


    //close
    public static void closeBD() throws SQLException {
        conn.close();
        mainStatm.close();
        statmTypCreator.close();
        statmCoffee.close();
        statmCreator.close();
        statmTypCoffe.close();
        System.out.println("basaDate closed");
    }


}