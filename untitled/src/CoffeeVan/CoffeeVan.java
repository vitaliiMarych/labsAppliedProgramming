package CoffeeVan;

import CoffeeVan.CoffeeCreators.CoffeeCreator;
import CoffeeVan.Coffees.Coffee;
import DataBase.DataBase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CoffeeVan {
    private static double maxVolume;
    private static String name;
    private static ArrayList<Coffee> coffees;
    private static ArrayList<CoffeeCreator> creators;

    public static void start(String n) throws SQLException {
        readCoffeeListFromDB();
        creators = new ArrayList<>();
        name = n;
    }

    public static ArrayList<Coffee> getCoffees() {
        return coffees;
    }

    public static ArrayList<CoffeeCreator> getCreators() {
        return creators;
    }

    private static void readCoffeeListFromDB() throws SQLException {

        coffees = new ArrayList<>();
        ResultSet rslt = DataBase.getCoffeeData();

        while (rslt.next()){

            int id = rslt.getInt(1);
            String name = rslt.getString(2);
            boolean canSell = rslt.getBoolean(3);
            String state = rslt.getString(5);
            int countOfSell = rslt.getInt(6);
            int cost = rslt.getInt(7);
            double volume = rslt.getDouble(8);
            String recomendAdditive = rslt.getString(9);

            int indexTypeCoffee = rslt.getInt(4);
            ResultSet typecolumh = DataBase.getTypeOfCoffee(indexTypeCoffee);
            String type = typecolumh.getString(2);
            int indexTypeCreator = typecolumh.getInt(3);

            String creatorType = DataBase.getTypeOfCreator(indexTypeCreator).getString(2);

            Coffee coffee = new Coffee(id, name, canSell, type, state, countOfSell, cost, volume, recomendAdditive, creatorType);
            coffees.add(coffee);

        }

    }

}
