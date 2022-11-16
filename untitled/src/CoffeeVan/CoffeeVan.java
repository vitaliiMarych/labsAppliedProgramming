package CoffeeVan;

import CoffeeVan.CoffeeCreators.CoffeeCreator;
import CoffeeVan.Coffees.Coffee;
import DataBase.DataBase;
import Logs.LoggerCoffeeVan;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;

public class CoffeeVan {
    private static double maxVolume;
    private static double currentVolume = 0;
    private static String name;
    private static ArrayList<Coffee> coffees;
    private static ArrayList<CoffeeCreator> creators;

    public static void start(String n, Double volume) throws SQLException {
        name = n;
        maxVolume = volume;
        creators = new ArrayList<>();
    }

    public static double getMaxVolume() {
        return maxVolume;
    }

    public static double getCurrentVolume() {
        return currentVolume;
    }

    public static ArrayList<Coffee> getCoffees() {
        return coffees;
    }

    public static ArrayList<CoffeeCreator> getCreators() {
        return creators;
    }

    public static void readLists() throws SQLException {
        readCreatorListFromBD();
        readCoffeeListFromDB();
    }

    private static void readCreatorListFromBD() throws SQLException {
        creators = new ArrayList<>();
        ResultSet rslt = DataBase.getMainStatm().executeQuery("SELECT Creators.id, type, isWorking, state FROM 'Creators' " +
                "INNER JOIN 'typesOfCreator' " +
                "ON Creators.idType = typesOfCreator.id");

        while (rslt.next()){
            int id = rslt.getInt(1);
            boolean isWorking = rslt.getBoolean(3);
            String state = rslt.getString(4);
            String type = rslt.getString(2);

            CoffeeCreator cc = new CoffeeCreator(id, isWorking, state, type);
            creators.add(cc);
        }
        DataBase.getSecondStatm().close();
        DataBase.getMainStatm().close();
        LoggerCoffeeVan.getLogger().log(Level.INFO, "List creators was read");
    }

    private static void readCoffeeListFromDB() throws SQLException {

        coffees = new ArrayList<>();
        ResultSet rslt = DataBase.getMainStatm().executeQuery("SELECT * FROM 'Coffees'");

        DataBase.getConn().setAutoCommit(false);

        while (rslt.next()){

            int id = rslt.getInt(1);
            String name = rslt.getString(2);
            boolean canSell = rslt.getBoolean(3);
            String state = rslt.getString(5);
            int countOfSell = rslt.getInt(6);
            int cost = rslt.getInt(7);

            double f = rslt.getDouble(8);

            double volume = (Double) rslt.getDouble(8);
            String recomendAdditive = rslt.getString(9);

            int indexTypeCoffee = rslt.getInt(4);

            ResultSet typecolumh = DataBase.getTypeOfCoffee(DataBase.getSecondStatm(), indexTypeCoffee);
            String type = typecolumh.getString(2);
            int indexTypeCreator = typecolumh.getInt(3);

            String creatorType = DataBase.getTypeOfCreator(DataBase.getSecondStatm(), indexTypeCreator).getString(2);

            DataBase.getSecondStatm().close();

            if (canSell){
                if (!findCreator(creatorType)){
                    String query = String.format("UPDATE 'Coffees' " +
                            "SET 'canSell' = '%d', " +
                            "'state' = '%s' " +
                            " WHERE id = %d", 0, "Проблема з пристоєм", id);

                    DataBase.getSecondStatm().executeUpdate(query);

                    canSell = false;
                    state = "Проблема з пристоєм";

                }
            }

            if (state.equals("Проблема з пристоєм")){
                if (findCreator(creatorType)){
                    String query = String.format("UPDATE 'Coffees' " +
                            "SET 'canSell' = '%d', " +
                            "'state' = '%s' " +
                            " WHERE id = %d", 1, "Можна продавати", id);
                    DataBase.getSecondStatm().executeUpdate(query);
                    canSell = true;
                    state = "Можна продавати";

                }
            }


            if (currentVolume + volume < maxVolume) {
                Coffee coffee = new Coffee(id, name, canSell, type, state, countOfSell, cost, volume, recomendAdditive, creatorType);
                coffees.add(coffee);
                currentVolume += volume;
            }
            else{
                System.out.println("У фургоні недостатньо місця");
            }
        }

        DataBase.getConn().commit();
        DataBase.getConn().setAutoCommit(true);

        DataBase.getSecondStatm().close();

        LoggerCoffeeVan.getLogger().log(Level.INFO, "List coffees was read");
    }

    public static String toStringe() {
        return String.format("Кавовий фургон '%s' \nМаксимальний об'єм кави на складі - %f \nПоточний зайнятий об'єм - %f",
                name, maxVolume, currentVolume);
    }

    private static boolean findCreator(String type){
        return CoffeeVan.getCreators().stream().anyMatch(x -> x.getType().equals(type) && x.isWorking());
    }


}
